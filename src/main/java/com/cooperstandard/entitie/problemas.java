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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Problemas")
@NamedQueries(value = {
    @NamedQuery(name = "problemas.findAll", query = "SELECT m FROM problemas AS m")
    ,@NamedQuery(name = "problemas.findById", query = "SELECT m FROM problemas AS m WHERE m.id = :paramId")
})
public class problemas implements Serializable {

    private long id;
    private String desc_problema;
    private List<causas> c_id;

    public problemas(long id, String desc_problema, List<causas> c_id) {
        this.id = id;
        this.desc_problema = desc_problema;
        this.c_id = c_id;
    }

    public problemas() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "DESC_PROBLEMA", length = 255)
    public String getDesc_problema() {
        return desc_problema;
    }

    public void setDesc_problema(String desc_problema) {
        this.desc_problema = desc_problema;
    }

    @OneToMany(mappedBy = "id_problema")
    public List<causas> getC_id() {
        return c_id;
    }

    public void setC_id(List<causas> c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "problemas{" + "id=" + id + ", desc_problema=" + desc_problema + ", c_id=" + c_id + '}';
    }

}
