
package com.cooperstandard.entitie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReportGroup {

    private Long id;
    private String nome;
    private List<Report> reportList;

}
