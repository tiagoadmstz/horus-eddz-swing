package com.cooperstandard.services.dtos;

import com.cooperstandard.entitie.Report;
import com.cooperstandard.entitie.ReportFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ReportGenerationDto implements Serializable {

    private String prettyName;
    private String type;
    private String fileName;
    private String sheetFormat;
    private List<ReportFilter> filters;
    private Map<String, Object> parameters = new HashMap<>(1);

    public ReportGenerationDto(final Report report) {
        this.prettyName = report.getNome();
        this.type = report.getTipo();
        this.fileName = report.getPath();
        this.filters = report.getFiltros();
        report.getFiltros().forEach(f -> {
            if ("formato".equalsIgnoreCase(f.getNome())) this.sheetFormat = f.getValor();
            parameters.put(f.getNome(), f.getValor());
        });
    }
}
