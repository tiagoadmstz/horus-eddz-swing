package com.cooperstandard.listeners;

import com.cooperstandard.dal.config.ControleInstancias;
import com.cooperstandard.dal.config.EntityManagerHelper;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.entitie.Report;
import com.cooperstandard.entitie.Report_Filter;
import com.cooperstandard.entitie.Report_Group;
import com.cooperstandard.frames.seletores.Datas;
import com.cooperstandard.frames.seletores.MessageFactory;
import com.cooperstandard.frames.seletores.SeletorDatas;
import com.cooperstandard.frames.seletores.SeletorHorario;
import com.cooperstandard.frames.seletores.SeletorInputString;
import com.cooperstandard.frames.seletores.SeletorSimpleComboBox;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.tables.TableModel_Filtros;
import com.cooperstandard.tables.TableModel_Report;
import com.cooperstandard.tables.TableModel_ReportGroup;
import com.cooperstandard.util.JasperUtil;
import com.cooperstandard.views.principal.ViewRelatorio;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Listener_ReportManager implements ActionListener {

    private final ViewRelatorio form;
    private TableModel_ReportGroup model_group;
    private TableModel_Report model_report;
    private TableModel_Filtros model_filtros;
    private List<Report> reports;
    private List<Report_Group> groups;
    private final Map<String, Object> mapParam = new HashMap();
    private EntityManagerHelper emh;

    public Listener_ReportManager(ViewRelatorio form) {
        this.form = form;
        initComponents();

    }

    public void initComponents() {
        emh = new EntityManagerHelper();
        attachListener();
        carregaListas();
        addModel();
    }

    public void attachListener() {
        form.getButtonList().forEach(b -> b.addActionListener(this));
        form.getTbGrupo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                List<Report> rpt = reports.stream()
                        .filter(r -> r.getGrupo().equals(model_group.getObject(form.getTbGrupo().getSelectedRow())))
                        .collect(Collectors.toList());
                model_report.setLista(rpt.stream()
                        .sorted(Comparator.comparing(Report::getOrdem)
                                .thenComparing(Report::getNome))
                        .collect(Collectors.toList()));
            }
        });
        form.getTbRelatorio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                model_filtros.deletarLista();
                Optional<List<Report_Filter>> op = reports.stream()
                        .filter(r -> {
                            return r.getGrupo().equals(model_group.getObject(form.getTbGrupo().getSelectedRow()))
                                    && r.getNome().equals(model_report.getObject(form.getTbRelatorio().getSelectedRow()).getNome());
                        })
                        .map(Report::getFiltros).findFirst();
                if (op.isPresent()) {
                    List<Report_Filter> filtros = op.get();
                    filtros.stream().sorted(Comparator.comparing(Report_Filter::getOrdem).thenComparing(Report_Filter::getNome))
                            .forEach(f -> model_filtros.addObject(f));
                }
            }
        });
        form.getTbFiltro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    getSeletor();
                }
            }
        });

    }

    public void addModel() {
        model_group = new TableModel_ReportGroup();
        model_group.setLista(groups);
        form.getTbGrupo().setModel(model_group);
        model_filtros = new TableModel_Filtros();
        form.getTbFiltro().setModel(model_filtros);
        model_report = new TableModel_Report();
        form.getTbRelatorio().setModel(model_report);
    }

    private void carregaListas() {
        try {
            reports = (List<Report>) emh.getObjectListNamedQuery(Report.class, "report.findByIds", new String[]{"paramIds"}, new Object[]{this.getReportIdListBySetorUsuario(ModelSessaoUsuario.setor)}, EntityManagerHelper.SQLSERVER_PU).get();
            groups = (List<Report_Group>) emh.getObjectListNamedQuery(Report_Group.class, "report_group.findAll", null, null, EntityManagerHelper.SQLSERVER_PU).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Long> getReportIdListBySetorUsuario(String setor) {
        try {
            String valor = String.valueOf(emh.getObjectNativeQuery("SELECT dbo.OBTER_RELATORIOS_SETOR(?)", setor, EntityManagerHelper.SQLSERVER_PU));
            return Arrays.stream(valor.split(",")).map(Long::parseLong).collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "editarFiltro":
                getSeletor();
                break;
            case "imprimir":
                form.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                imprimir();

                break;

        }
        form.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void getSeletor() {
        Report report = model_report.getObject(form.getTbRelatorio().getSelectedRow());
        Report_Filter filtro = model_filtros.getObject(form.getTbFiltro().getSelectedRow());
        switch (filtro.getTipo()) {
            case "datas":
                SeletorDatas sd = (SeletorDatas) ControleInstancias.getInstance(SeletorDatas.class);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                sd.getBtConfirmar().addActionListener(ev -> {
                    LocalDate[] datas = sd.getArrayDatas();
                    filtro.setValor(datas[0].format(dtf) + " à " + datas[1].format(dtf));
                    mapParam.put("dataini", Datas.localDateToDate(datas[0]));
                    mapParam.put("datafim", Datas.localDateToDate(datas[1]));
                    model_filtros.fireTableDataChanged();
                    sd.dispose();
                });
                sd.setVisible(true);
                break;
            case "horas":
                SeletorHorario horario = (SeletorHorario) ControleInstancias.getInstance(SeletorHorario.class);
                horario.getBtConfirmar().addActionListener(event -> {
                    filtro.setValor(horario.getHoraInicial() + " à " + horario.getHoraFinal());
                    mapParam.put("horaini", horario.getHoraInicial());
                    mapParam.put("horafim", horario.getHoraFinal());
                    horario.dispose();
                });
                horario.setVisible(true);
                break;
            case "boolean":
                break;
            case "combobox":
                if (filtro.getNome().equals("Linha")) {
                    montSeletorComboBox(filtro, "Linha", "linha", getLinhas(getConnection(), "Extrusão").toArray());
                } else if (filtro.getNome().equals("Teste")) {
                    montSeletorComboBox(filtro, "Teste", "teste", getTesteInsp(getConnection(), "Laboratório").toArray());
                } else if (filtro.getNome().equals("Formato")) {
                    montSeletorComboBox(filtro, "Formato", "formato", "A4", "A3");
                } else if (filtro.getNome().equals("Entrada/Parada")) {
                    montSeletorComboBox(filtro, "Flag", "flag", "E", "P");
                } else if (filtro.getNome().equals("Tipo de teste")) {
                    montSeletorComboBox(filtro, "Tipo de teste", "tipo", "Produção", "Re-Teste", "Try-out");
                } else if (filtro.getNome().equals("Equipamento")) {
                    montSeletorComboBox(filtro, "Equipamento", "equipamento", getEquipamento(getConnection()).toArray());
                } else if (filtro.getNome().equals("Perfil")) {
                    if (mapParam.get("linha") != null) {
                        montSeletorComboBox(filtro, "Perfil", "perfil", getPerfil(getConnection(), mapParam.get("linha").toString()).toArray());
                    } else {
                        JOptionPane.showMessageDialog(form, "Selecione uma linha primeiro", "Erro de pesquisa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (report.getNome().equals("DDZ rodada") && filtro.getNome().equals("Lançamentos")) {
                    if (mapParam.get("dataini") != null && mapParam.get("datafim") != null && mapParam.get("perfil") != null) {
                        montSeletorComboBox(filtro, "Lançamentos", "datetimeinput", getLancamentos(getConnection(),
                                Datas.dateToTimestamp((Date) mapParam.get("dataini")),
                                Datas.dateToTimestamp((Date) mapParam.get("datafim")),
                                mapParam.get("perfil").toString()).toArray());
                    } else {
                        MessageFactory.getInfoMessage("Informe data e perfil!", form);
                    }
                }
                break;
            case "texto":
                SeletorInputString seletor = (SeletorInputString) ControleInstancias.getInstance(SeletorInputString.class);
                if (filtro.getNome().equals("Texto")) {
                    seletor.setLabelText("Problema:");
                }
                seletor.getBtConfirmar().addActionListener(event -> {
                    filtro.setValor(seletor.getItem());
                    seletor.setVisible(true);
                    if (filtro.getNome().equals("Texto")) {
                        mapParam.put("obs", seletor.getItem());
                    }
                    seletor.dispose();
                });
                seletor.setVisible(true);
                break;
        }
    }

    private void imprimir() {
        Report report = model_report.getObject(form.getTbRelatorio().getSelectedRow());
        if (model_filtros.getLista().stream().filter(ft -> ft.getValor() != null && !"".equals(ft.getValor())).count() > 0) {
            if (report.getTipo().equals("SQL")) {
                String path = report.getPath();
                if (report.getNome().equals("DDZ rodada") && mapParam.get("formato") == "A3") {
                    path = path.substring(0, (path.length() - 7)).concat("A3.jasper");
                }
                if (report.getNome().equals("Coleta de Dados (por Teste)") || report.getNome().equals("Coleta de Dados (por Composto)")) {

                } else {
                    if (report.getNome().equals("Resultado por Etiqueta")) {
                        JOptionPane.showMessageDialog(null, "Cópias enviadas para impressora!");
                    } else {
                        imprimirReportSQL(getConnection(), report.getNome(), path);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(form, "Campo obrigatório", "Erro de pesquisa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void imprimirReportSQL(Connection conn, String reportName, String path) {
        mapParam.putAll(JasperUtil.getMapParameterDefault());
        JasperUtil.imprimirSqlReport(conn, reportName, path, mapParam);
    }

    private void montSeletorComboBox(Report_Filter filtro, String label, String key, Object... itens) {
        SeletorSimpleComboBox seletorSimpleComboBox = (SeletorSimpleComboBox) ControleInstancias.getInstance(SeletorSimpleComboBox.class);
        seletorSimpleComboBox.setLabelText(label);
        seletorSimpleComboBox.carregarLista(Arrays.asList(itens));
        seletorSimpleComboBox.getBtConfirmar().addActionListener(event -> {
            Object ob = seletorSimpleComboBox.getSelectItem();
            filtro.setValor(ob.toString());
            if (filtro.getNome().equals("Perfil")) {
                mapParam.put(key, ob.toString().split(" - ")[0]);
            } else {
                mapParam.put(key, ob);
            }
            model_filtros.fireTableDataChanged();
            seletorSimpleComboBox.dispose();
        });
        seletorSimpleComboBox.getBtCancelar().addActionListener(event -> {
            filtro.setValor(null);
            mapParam.remove(key);
        });
        seletorSimpleComboBox.setVisible(true);
    }

    private synchronized List<?> getResultadoListaValoresDB(List<?> resultado, String campo) {
        List<Object> valores = new ArrayList();
        for (Object item : resultado) {
            try {
                Field field = item.getClass().getDeclaredField(campo);
                field.setAccessible(true);
                valores.add(field.get(item));
            } catch (Exception ex) {
                return valores;
            }
        }
        return valores;
    }

    private Connection getConnection() {
        return new ConexaoSql().getCon();
    }

    private List<String> getLinhas(Connection conn, String setor) {
        List<String> lista = new ArrayList();
        try {
            ResultSet rs = getResultSet(conn, "Select LINHA from Cad_Linha where LINHA <> 'L01' and LINHA <> 'L03' and LINHA <> 'L03ATB' and LINHA <> 'L04ATB'"
                    + "and LINHA <> 'L05' and LINHA <> 'L10' and LINHA <> 'L13' and LINHA <> 'L14' and LINHA <> 'L16' and LINHA <> 'Carrossel 37' and LINHA <> 'Carrossel 153' and LINHA <> 'Carrossel 197' and SETOR = ? ", setor);
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<String> getTesteInsp(Connection conn, String setor) {
        List<String> lista = new ArrayList();
        try {
            ResultSet rs = getResultSet(conn, "SELECT DESC_TESTE FROM Cad_Teste where TES_EQUIPAMENTO=? ORDER BY ORDEM", setor);
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<String> getPerfil(Connection conn, String linha) {
        List<String> lista = new ArrayList();
        try {
            ResultSet rs;
            if (linha == null) {
                rs = getResultSet(conn, "Select MATERIAL, BPCS from Cad_Material  order by BPCS ASC");
            } else {
                rs = getResultSet(conn, "Select MATERIAL, BPCS from Cad_Material where  MAT_LINHA= ? order by BPCS ASC", linha);
            }
            while (rs.next()) {
                lista.add(rs.getString(1) + " - " + rs.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<String> getLancamentos(Connection conn, Timestamp dataInicial, Timestamp dataFinal, String rcPerfil) {
        List<String> lista = new ArrayList();
        try {
            ResultSet rs = getResultSet(conn, "SELECT convert(varchar, data_hora_input, 120) as DATA_COMPLETA from dbo.VW_DDZ_DATAHORA WHERE (FLAG = 'E') AND convert(datetime,DATA_INPUT,103)BETWEEN  '" + dataInicial + "' and '" + dataFinal + "' AND ID_M_MATERIAL = '" + rcPerfil + "'");
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<String> getEquipamento(Connection conn) {
        List<String> lista = new ArrayList();
        try {
            ResultSet rs = getResultSet(conn, "Select * from Cad_Equipamento order by EQUIPAMENTO ASC");
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<Long> getPermissoes(Connection conn, Integer usuario) {
        List<Long> lista = new ArrayList();
        try {
            ResultSet rs = getResultSet(conn, "Select Relatorio from Cad_Relatorios_Permissoes where Usuario = ? ", usuario);
            while (rs.next()) {
                lista.add(rs.getLong(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private ResultSet getResultSet(Connection conn, String sql, Object... parameters) {
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 1; i <= parameters.length; i++) {
                pst.setObject(i, parameters[i - 1]);
            }
            return pst.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Método para tratar células númericas de arquivos .xls
     *
     * @param xls
     * @return booleano informante resultado do método
     */
    public boolean tratarCelulas(File xls) {
        try {
            FileInputStream input = new FileInputStream(xls);
            //pega a pasta de trabalho
            HSSFWorkbook pastaTrabalho = new HSSFWorkbook(input);
            //escolhe a primeira planilha da pasta
            HSSFSheet planilha = pastaTrabalho.getSheetAt(0);
            //pega todas as linhas do arquivo
            Iterator<Row> iterator = planilha.rowIterator();
            //passa linha a linha
            while (iterator.hasNext()) {
                //pega a linha atual
                Row row = iterator.next();
                //pega todas as celulas da linha
                Iterator<Cell> cellIterator = row.cellIterator();
                //passa celula a celula
                while (cellIterator.hasNext()) {
                    //pega a celula atual
                    Cell c = cellIterator.next();
                    //verifica se é do tipo string
                    if (c.getCellType() == Cell.CELL_TYPE_STRING) {
                        //if (c.getCellType() == 0) {
                        //pega o conteudo da celula
                        String valor = c.getStringCellValue();
                        //troca virgula para ponto
                        valor = valor.replace(",", ".");
                        //cria regex para garantir que o conteudo é um número com ponto flutuando
                        Pattern p = Pattern.compile("(\\d+).(\\d+)");
                        Matcher m = p.matcher(valor);
                        if (m.find()) {
                            //seta novo valor na célula como um double
                            c.setCellValue(Double.valueOf(valor));
                            //seta a célula como numérica
                            c.setCellType(Cell.CELL_TYPE_NUMERIC);
                        }
                    }

                }
            }
            //cria um stream de saida
            FileOutputStream fileOut = new FileOutputStream(xls);
            //escreve as alterações na pasta de trabalho
            pastaTrabalho.write(fileOut);
            //salva o arquivo modificado
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void exportToXls(File file, JasperPrint jasperPrint) {
        try {
            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
            configuration.setOnePagePerSheet(false);
            configuration.setDetectCellType(false);
            configuration.setCollapseRowSpan(false);
            configuration.setWhitePageBackground(false);
            configuration.setWrapText(true);
            FileOutputStream fos = new FileOutputStream(file, true);

            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(fos));
            exporterXLS.setConfiguration(configuration);
            exporterXLS.exportReport();

            fos.flush();
            fos.close();
        } catch (Exception e) {
        }

    }

}
