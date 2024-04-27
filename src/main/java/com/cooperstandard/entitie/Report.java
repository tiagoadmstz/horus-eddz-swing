/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.entitie;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Cad_Report")
@NamedQueries(value = {
    @NamedQuery(name = "report.findAll", query = "SELECT cc FROM Report AS cc")
    ,@NamedQuery(name = "report.findByIds", query = "SELECT cc FROM Report AS cc WHERE cc.id IN :paramIds")
})
@SequenceGenerator(name = "seq_report", allocationSize = 1, initialValue = 1)
public class Report implements Serializable {

    private static final long serialVersionUID = 4617363613110228581L;

    private Long id;
    private String nome;
    private String sigla;
    private String path;
    private String tipo;
    private Boolean ativo;
    private Integer ordem;
    private Report_Group grupo;
    List<Report_Filter> filtros;

    public Report() {
    }

    @Id
    @Column(name = "RELATORIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME", length = 255)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "SIGLA", length = 7)
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Column(name = "PASTA", length = 2000)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "TIPO", length = 5)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "ATIVO", columnDefinition = "bit")
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Column(name = "ORDEM")
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "GRUPO")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Report_Group.class)
    public Report_Group getGrupo() {
        return grupo;
    }

    public void setGrupo(Report_Group grupo) {
        this.grupo = grupo;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Report_Filter.class)
    public List<Report_Filter> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<Report_Filter> filtros) {
        this.filtros = filtros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.sigla);
        hash = 89 * hash + Objects.hashCode(this.path);
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + Objects.hashCode(this.ativo);
        hash = 89 * hash + Objects.hashCode(this.ordem);
        hash = 89 * hash + Objects.hashCode(this.grupo);
        hash = 89 * hash + Objects.hashCode(this.filtros);
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
        final Report other = (Report) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.ordem, other.ordem)) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        if (!Objects.equals(this.filtros, other.filtros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", path=" + path + ", tipo=" + tipo + ", ativo=" + ativo + ", ordem=" + ordem + ", grupo=" + grupo + ", filtros=" + filtros + '}';
    }

}
