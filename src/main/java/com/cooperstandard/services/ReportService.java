package com.cooperstandard.services;

import com.cooperstandard.dal.config.ControleInstancias;
import com.cooperstandard.entitie.Report;
import com.cooperstandard.entitie.ReportFilter;
import com.cooperstandard.entitie.ReportGroup;
import com.cooperstandard.frames.seletores.Datas;
import com.cooperstandard.frames.seletores.MessageFactory;
import com.cooperstandard.frames.seletores.SeletorDatas;
import com.cooperstandard.frames.seletores.SeletorHorario;
import com.cooperstandard.frames.seletores.SeletorInputString;
import com.cooperstandard.frames.seletores.SeletorSimpleComboBox;
import com.cooperstandard.services.dtos.ReportGenerationDto;
import com.cooperstandard.services.rest.ReportRestService;
import com.cooperstandard.tables.TableModel_Filtros;
import com.cooperstandard.views.principal.ViewRelatorio;
import net.sf.jasperreports.engine.JasperPrint;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReportService {

    private final ViewRelatorio viewRelatorio;
    private final Map<String, Object> mapParam;
    private final TableModel_Filtros filtersTableModel;
    private final ReportRestService reportRestService;

    public ReportService(
            ViewRelatorio form,
            Map<String, Object> mapParam,
            TableModel_Filtros filtersTableModel
    ) {
        this.viewRelatorio = form;
        this.mapParam = mapParam;
        this.filtersTableModel = filtersTableModel;
        this.reportRestService = new ReportRestService();
    }

    public List<ReportGroup> findBySector(final String sector) {
        return reportRestService.findBySector(sector);
    }

    public void getSeletor(
            final Report report,
            final ReportFilter reportFilter
    ) {
        switch (reportFilter.getTipo()) {
            case "datas":
                SeletorDatas sd = (SeletorDatas) ControleInstancias.getInstance(SeletorDatas.class);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                sd.getBtConfirmar().addActionListener(ev -> {
                    LocalDate[] datas = sd.getArrayDatas();
                    reportFilter.setValor(datas[0].format(dtf) + " à " + datas[1].format(dtf));
                    mapParam.put("dataini", Datas.localDateToDate(datas[0]));
                    mapParam.put("datafim", Datas.localDateToDate(datas[1]));
                    filtersTableModel.fireTableDataChanged();
                    sd.dispose();
                });
                sd.setVisible(true);
                break;
            case "horas":
                SeletorHorario horario = (SeletorHorario) ControleInstancias.getInstance(SeletorHorario.class);
                horario.getBtConfirmar().addActionListener(event -> {
                    reportFilter.setValor(horario.getHoraInicial() + " à " + horario.getHoraFinal());
                    mapParam.put("horaini", horario.getHoraInicial());
                    mapParam.put("horafim", horario.getHoraFinal());
                    horario.dispose();
                });
                horario.setVisible(true);
                break;
            case "boolean":
                break;
            case "combobox":
                if (reportFilter.getNome().equals("Linha")) {
                    montSeletorComboBox(reportFilter, "Linha", "linha", findLinesBySector("Extrusão").toArray());
                } else if (reportFilter.getNome().equals("Teste")) {
                    montSeletorComboBox(reportFilter, "Teste", "teste", findTestsByEquip("Laboratório").toArray());
                } else if (reportFilter.getNome().equals("Formato")) {
                    montSeletorComboBox(reportFilter, "Formato", "formato", "A4", "A3");
                } else if (reportFilter.getNome().equals("Entrada/Parada")) {
                    montSeletorComboBox(reportFilter, "Flag", "flag", "E", "P");
                } else if (reportFilter.getNome().equals("Tipo de teste")) {
                    montSeletorComboBox(reportFilter, "Tipo de teste", "tipo", "Produção", "Re-Teste", "Try-out");
                } else if (reportFilter.getNome().equals("Equipamento")) {
                    montSeletorComboBox(reportFilter, "Equipamento", "equipamento", getEquipamento().toArray());
                } else if (reportFilter.getNome().equals("Perfil")) {
                    if (mapParam.get("linha") != null) {
                        montSeletorComboBox(reportFilter, "Perfil", "perfil", getPerfil(mapParam.get("linha").toString()).toArray());
                    } else {
                        JOptionPane.showMessageDialog(viewRelatorio, "Selecione uma linha primeiro", "Erro de pesquisa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (report.getNome().equals("DDZ rodada") && reportFilter.getNome().equals("Lançamentos")) {
                    if (mapParam.get("dataini") != null && mapParam.get("datafim") != null && mapParam.get("perfil") != null) {
                        montSeletorComboBox(reportFilter, "Lançamentos", "datetimeinput", getLancamentos(
                                Datas.dateToTimestamp((Date) mapParam.get("dataini")),
                                Datas.dateToTimestamp((Date) mapParam.get("datafim")),
                                mapParam.get("perfil").toString()).toArray());
                    } else {
                        MessageFactory.getInfoMessage("Informe data e perfil!", viewRelatorio);
                    }
                }
                break;
            case "texto":
                SeletorInputString seletor = (SeletorInputString) ControleInstancias.getInstance(SeletorInputString.class);
                if (reportFilter.getNome().equals("Texto")) {
                    seletor.setLabelText("Problema:");
                }
                seletor.getBtConfirmar().addActionListener(event -> {
                    reportFilter.setValor(seletor.getItem());
                    seletor.setVisible(true);
                    if (reportFilter.getNome().equals("Texto")) {
                        mapParam.put("obs", seletor.getItem());
                    }
                    seletor.dispose();
                });
                seletor.setVisible(true);
                break;
        }
    }

    private void montSeletorComboBox(
            final ReportFilter filtro,
            final String label,
            final String key,
            final Object... itens
    ) {
        SeletorSimpleComboBox seletorSimpleComboBox = (SeletorSimpleComboBox) ControleInstancias.getInstance(SeletorSimpleComboBox.class);
        seletorSimpleComboBox.setLabelText(label);
        seletorSimpleComboBox.carregarLista(Arrays.asList(itens));
        seletorSimpleComboBox.getBtConfirmar().addActionListener(event -> {
            Object ob = seletorSimpleComboBox.getSelectItem();
            if (Objects.nonNull(ob)) {
                filtro.setValor(ob.toString());
                if (filtro.getNome().equals("Perfil")) {
                    mapParam.put(key, ob.toString().split(" - ")[0]);
                } else {
                    mapParam.put(key, ob);
                }
            }
            filtersTableModel.fireTableDataChanged();
            seletorSimpleComboBox.dispose();
        });
        seletorSimpleComboBox.getBtCancelar().addActionListener(event -> {
            filtro.setValor(null);
            mapParam.remove(key);
        });
        seletorSimpleComboBox.setVisible(true);
    }

    private List<String> findLinesBySector(final String sector) {
        return reportRestService.findLinesBySector(sector);
    }

    private List<String> findTestsByEquip(final String sector) {
        return reportRestService.findTestsByEquip(sector);
    }

    private List<String> getPerfil(final String line) {
        return reportRestService.findMaterialByLine(line);
    }

    private List<String> getLancamentos(final Timestamp initialDate, final Timestamp finalDate, final String rcProfile) {
        return reportRestService.findDdzByDateAndProfile(initialDate, finalDate, rcProfile);
    }

    private List<String> getEquipamento() {
        return reportRestService.findAllEquip();
    }

    private List<Long> getPermissoes(final Integer userId) {
        return reportRestService.findReportPermissionsByUserId(userId);
    }

    public JasperPrint print(final ReportGenerationDto reportGenerationDto) {
        return reportRestService.generateReport(reportGenerationDto);
    }
}
