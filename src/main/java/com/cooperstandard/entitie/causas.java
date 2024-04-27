package com.cooperstandard.entitie;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Causas")
@NamedQueries(value = {
    @NamedQuery(name = "causas.findAll", query = "SELECT m FROM causas AS m")
    ,@NamedQuery(name = "causas.findById", query = "SELECT m FROM causas AS m WHERE m.id = :paramId")
})
public class causas implements Serializable {

    private long id;
    private String desc_causa;
    private problemas id_problema;
    private List<ddz> d_id;

    public causas(long id, String desc_causa, problemas id_problema, List<ddz> d_id) {
        this.id = id;
        this.desc_causa = desc_causa;
        this.id_problema = id_problema;
        this.d_id = d_id;
    }

    public causas() {
    }

    public causas(long id, String desc_causa) {
        this.id = id;
        this.desc_causa = desc_causa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "DESC_CAUSA", length = 255)
    public String getDesc_causa() {
        return desc_causa;
    }

    public void setDesc_causa(String desc_causa) {
        this.desc_causa = desc_causa;
    }

    @ManyToOne
    public problemas getId_problema() {
        return id_problema;
    }

    public void setId_problema(problemas id_problema) {
        this.id_problema = id_problema;
    }

    @OneToMany(mappedBy = "id_causa")
    public List<ddz> getD_id() {
        return d_id;
    }

    public void setD_id(List<ddz> d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "causas{" + "id=" + id + ", desc_causa=" + desc_causa + ", id_problema=" + id_problema + ", d_id=" + d_id + '}';
    }

}
