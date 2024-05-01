package com.cooperstandard.listeners;

import com.cooperstandard.dal.config.EntityManagerHelper;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.entitie.Report;
import com.cooperstandard.entitie.ReportFilter;
import com.cooperstandard.entitie.ReportGroup;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.services.ReportService;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Listener_ReportManager implements ActionListener {

    private final ViewRelatorio form;
    private TableModel_ReportGroup model_group;
    private TableModel_Report model_report;
    private TableModel_Filtros model_filtros;
    private List<Report> reports;
    private List<ReportGroup> groups;
    private final Map<String, Object> mapParam = new HashMap();
    private EntityManagerHelper emh;
    private final ReportService reportService;

    public Listener_ReportManager(ViewRelatorio form) {
        this.form = form;
        this.reportService = new ReportService(form, mapParam, model_filtros);
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
                final ReportGroup reportGroup = model_group.getObject(form.getTbGrupo().getSelectedRow());
                model_report.setLista(reportGroup.getReportList());
            }
        });
        form.getTbRelatorio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                model_filtros.deletarLista();
                final Report selectedReport = model_report.getObject(form.getTbRelatorio().getSelectedRow());
                if (Objects.nonNull(selectedReport.getFiltros())) {
                    selectedReport.getFiltros().stream()
                            .sorted(Comparator.comparing(ReportFilter::getOrdem).thenComparing(ReportFilter::getNome))
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
        groups = reportService.findBySector(ModelSessaoUsuario.setor);
        reports = groups.stream()
                .flatMap(group -> group.getReportList().stream())
                .collect(Collectors.toList());
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
        final Report report = model_report.getObject(form.getTbRelatorio().getSelectedRow());
        final ReportFilter reportFilter = model_filtros.getObject(form.getTbFiltro().getSelectedRow());
        reportService.getSeletor(report, reportFilter);
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
