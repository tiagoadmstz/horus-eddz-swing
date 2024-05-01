package com.cooperstandard.entitie;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportFilter {

    private Long id;
    private String nome;
    private String valor;
    private String tipo;
    private Integer ordem;

}
