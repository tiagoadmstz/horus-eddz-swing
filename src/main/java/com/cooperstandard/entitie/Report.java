package com.cooperstandard.entitie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Report {

    private Long id;
    private String nome;
    private String sigla;
    private String path;
    private String tipo;
    private Boolean ativo;
    private Integer ordem;
    private Long groupId;
    private List<ReportFilter> filtros;

}
