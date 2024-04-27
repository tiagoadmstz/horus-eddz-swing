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
@Table(name = "Report_Filter")
@NamedQueries(value = {
    @NamedQuery(name = "report_filter.findAll", query = "SELECT rr FROM Report_Filter AS rr")
})
@SequenceGenerator(name = "seq_report_filter", allocationSize = 1, initialValue = 1)
public class Report_Filter implements Serializable {

    private static final long serialVersionUID = -8031438007775305676L;

    private Long id;
    private String nome;
    private String valor;
    private String tipo;
    private Integer ordem;

    public Report_Filter() {
    }

    @Id
    @Column(name = "FILTRO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_report_filter")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME", length = 80)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "VALOR", length = 100)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Column(name = "TIPO", length = 50)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "ORDEM")
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.valor);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.ordem);
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
        final Report_Filter other = (Report_Filter) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ordem, other.ordem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report_Filter{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", tipo=" + tipo + ", ordem=" + ordem + '}';
    }

}
