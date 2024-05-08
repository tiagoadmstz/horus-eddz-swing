package com.cooperstandard.listeners;

import com.cooperstandard.entitie.Report;
import com.cooperstandard.entitie.ReportFilter;
import com.cooperstandard.entitie.ReportGroup;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.services.ReportService;
import com.cooperstandard.services.dtos.ReportGenerationDto;
import com.cooperstandard.tables.TableModel_Filtros;
import com.cooperstandard.tables.TableModel_Report;
import com.cooperstandard.tables.TableModel_ReportGroup;
import com.cooperstandard.views.principal.ViewRelatorio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ListenerReportManager implements ActionListener {

    private final ViewRelatorio form;
    private final TableModel_ReportGroup modelGroup;
    private final TableModel_Report modelReport;
    private final TableModel_Filtros modelFilters;
    private List<ReportGroup> groups;
    private final Map<String, Object> mapParam = new HashMap<>(1);
    private final ReportService reportService;

    public ListenerReportManager(ViewRelatorio form) {
        this.form = form;
        this.modelGroup = new TableModel_ReportGroup();
        this.modelReport = new TableModel_Report();
        this.modelFilters = new TableModel_Filtros();
        this.reportService = new ReportService(form, mapParam, modelFilters);
        initComponents();
    }

    public void initComponents() {
        attachListener();
        chargeLists();
        addModel();
    }

    public void attachListener() {
        form.getButtonList().forEach(b -> b.addActionListener(this));
        form.getTbGrupo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                final ReportGroup reportGroup = modelGroup.getObject(form.getTbGrupo().getSelectedRow());
                modelReport.setLista(reportGroup.getReportList());
            }
        });
        form.getTbRelatorio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                modelFilters.deletarLista();
                final Report selectedReport = modelReport.getObject(form.getTbRelatorio().getSelectedRow());
                if (Objects.nonNull(selectedReport.getFiltros())) {
                    selectedReport.getFiltros().stream()
                            .sorted(Comparator.comparing(ReportFilter::getOrdem).thenComparing(ReportFilter::getNome))
                            .forEach(modelFilters::addObject);
                }
            }
        });
        form.getTbFiltro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    getSelector();
                }
            }
        });
    }

    public void addModel() {
        modelGroup.setLista(groups);
        form.getTbGrupo().setModel(modelGroup);
        form.getTbFiltro().setModel(modelFilters);
        form.getTbRelatorio().setModel(modelReport);
    }

    private void chargeLists() {
        groups = reportService.findBySector(ModelSessaoUsuario.setor);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        final String actionCommand = ae.getActionCommand();
        if (actionCommand.equals("editarFiltro")) {
            getSelector();
        } else if (actionCommand.equals("imprimir")) {
            form.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final Report report = modelReport.getObject(form.getTbRelatorio().getSelectedRow());
            final ReportGenerationDto reportGenerationDto = new ReportGenerationDto(report);
            //TODO: change to view PDF file
            reportService.print(reportGenerationDto);
        }
        form.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void getSelector() {
        final Report report = modelReport.getObject(form.getTbRelatorio().getSelectedRow());
        final ReportFilter reportFilter = modelFilters.getObject(form.getTbFiltro().getSelectedRow());
        reportService.getSeletor(report, reportFilter);
    }
}
