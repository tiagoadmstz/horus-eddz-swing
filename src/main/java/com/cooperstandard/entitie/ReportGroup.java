
package com.cooperstandard.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Report_Group")
@NamedQueries(value = {
        @NamedQuery(name = "report_group.findAll", query = "SELECT rr FROM Report_Group AS rr")
})
@SequenceGenerator(name = "seq_report_group", allocationSize = 1, initialValue = 1)
public class Report_Group implements Serializable {

    private static final long serialVersionUID = 3983201603811180025L;

    @Id
    @Column(name = "GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_group")
    private Long id;
    @Column(name = "NOME", length = 150)
    private String nome;
    @Transient
    private List<Report> reportList;

}
