package com.cooperstandard.entitie;

import com.cooperstandard.frames.seletores.ManipulaBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "Qry_EspecTeste_Insp")
@NamedQueries(value = {
    @NamedQuery(name = "teste.findAll", query = "SELECT tts FROM Teste  AS tts  ")
    ,@NamedQuery(name = "teste.findByID_MATERIAL_ID", query = "SELECT tts FROM Teste AS tts WHERE tts.id_material_id = :paramID_MATERIAL_ID")
})
public class Teste extends ManipulaBean<Teste> {

    private static final long serialVersionUID = -661205167249370409L;
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESC_TESTE")
    private String dteste;
    @Column(name = "ID_MATERIAL_ID")
    private int id_material_id;
    @Column(name = "ORDEM")
    private int ordem;

    public Teste() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDteste() {
        return dteste;
    }

    public void setDteste(String dteste) {
        this.dteste = dteste;
    }

    public int getId_material_id() {
        return id_material_id;
    }

    public void setId_material_id(int id_material_id) {
        this.id_material_id = id_material_id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

}
