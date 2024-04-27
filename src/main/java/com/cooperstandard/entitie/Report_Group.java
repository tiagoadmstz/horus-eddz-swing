
package com.cooperstandard.entitie;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Report_Group")
@NamedQueries(value = {
    @NamedQuery(name = "report_group.findAll", query = "SELECT rr FROM Report_Group AS rr")
})
@SequenceGenerator(name = "seq_report_group", allocationSize = 1, initialValue = 1)
public class Report_Group implements Serializable {

    private static final long serialVersionUID = 3983201603811180025L;

    private Long id;
    private String nome;

    public Report_Group() {
    }

    public Report_Group(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @Column(name = "GRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_group")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME", length = 150)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report_Group other = (Report_Group) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report_Group{" + "id=" + id + ", nome=" + nome + '}';
    }

}
