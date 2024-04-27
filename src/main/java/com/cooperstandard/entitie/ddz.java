package com.cooperstandard.entitie;

import com.cooperstandard.converters.LocalDateTimeConverter;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "DDZ")
@NamedQueries(value = {
    @NamedQuery(name = "ddz.findAll", query = "SELECT m FROM ddz AS m")
    ,@NamedQuery(name = "ddz.findById", query = "SELECT m FROM ddz AS m WHERE m.id = :paramId")
})
public class ddz implements Serializable {

    private long id;
    private String turno;
    private material id_m;
    private causas id_causa;
    private float qtd_scrap;
    private LocalDateTime data_input;
    private Time hora_input;
    private String observacao;
    private String acao_tomada;
    private float qtd_scrap_kg;

    public ddz() {
    }

    public ddz(long id, String turno, material id_m, causas id_causa, float qtd_scrap, LocalDateTime data_input, Time hora_input, String observacao, String acao_tomada, float qtd_scrap_kg) {
        this.id = id;
        this.turno = turno;
        this.id_m = id_m;
        this.id_causa = id_causa;
        this.qtd_scrap = qtd_scrap;
        this.data_input = data_input;
        this.hora_input = hora_input;
        this.observacao = observacao;
        this.acao_tomada = acao_tomada;
        this.qtd_scrap_kg = qtd_scrap_kg;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "TURNO", length = 10)
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @ManyToOne
    public material getId_m() {
        return id_m;
    }

    public void setId_m(material id_m) {
        this.id_m = id_m;
    }

    @ManyToOne
    public causas getId_causa() {
        return id_causa;
    }

    public void setId_causa(causas id_causa) {
        this.id_causa = id_causa;
    }

    @Column(name = "QTD_SCRAP")
    public float getQtd_scrap() {
        return qtd_scrap;
    }

    public void setQtd_scrap(float qtd_scrap) {
        this.qtd_scrap = qtd_scrap;
    }

    @Column(name = "DATA_INPUT", columnDefinition = "datetime")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime getData_input() {
        return data_input;
    }

    public void setData_input(LocalDateTime data_input) {
        this.data_input = data_input;
    }

    @Column(name = "HORA_INPUT", length = 10)
    public Time getHora_input() {
        return hora_input;
    }

    public void setHora_input(Time hora_input) {
        this.hora_input = hora_input;
    }

    @Column(name = "OBSERVACAO", length = 300)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Column(name = "ACAO_TOMADA", length = 300)
    public String getAcao_tomada() {
        return acao_tomada;
    }

    public void setAcao_tomada(String acao_tomada) {
        this.acao_tomada = acao_tomada;
    }

    @Column(name = "QTD_SCRAP_KG")
    public float getQtd_scrap_kg() {
        return qtd_scrap_kg;
    }

    public void setQtd_scrap_kg(float qtd_scrap_kg) {
        this.qtd_scrap_kg = qtd_scrap_kg;
    }

    @Override
    public String toString() {
        return "ddz{" + "id=" + id + ", turno=" + turno + ", id_m=" + id_m + ", id_causa=" + id_causa + ", qtd_scrap=" + qtd_scrap + ", data_input=" + data_input + ", hora_input=" + hora_input + ", observacao=" + observacao + ", acao_tomada=" + acao_tomada + ", qtd_scrap_kg=" + qtd_scrap_kg + '}';
    }

}
