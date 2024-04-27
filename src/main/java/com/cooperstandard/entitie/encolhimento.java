package com.cooperstandard.entitie;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Encolhimento")
@NamedQueries(value = {
    @NamedQuery(name = "encolhimento.findAll", query = "SELECT m FROM encolhimento AS m")
    ,@NamedQuery(name = "encolhimento.findByAmostra", query = "SELECT m FROM encolhimento AS m WHERE m.id = :paramId")
})
public class encolhimento implements Serializable {

    private long id;
    private String data_lancamento, hora, trena, observacao, desenho;
    private float amostrainicial, amostra24hrs, amostra48hrs, amostra72hrs, velocidade;
    private material id_material;

    public encolhimento() {
    }

    public encolhimento(long id, String data_lancamento, String hora, String trena, String observacao, String desenho, float amostrainicial, float amostra24hrs, float amostra48hrs, float amostra72hrs, float velocidade, material id_material) {
        this.id = id;
        this.data_lancamento = data_lancamento;
        this.hora = hora;
        this.trena = trena;
        this.observacao = observacao;
        this.desenho = desenho;
        this.amostrainicial = amostrainicial;
        this.amostra24hrs = amostra24hrs;
        this.amostra48hrs = amostra48hrs;
        this.amostra72hrs = amostra72hrs;
        this.velocidade = velocidade;
        this.id_material = id_material;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "DATA_LANCAMENTO", length = 10)
    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    @Column(name = "HORA", length = 10)
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @ManyToOne
    public material getId_material() {
        return id_material;
    }

    @Column(name = "AMOSTRA_INICIAL")
    public float getAmostrainicial() {
        return amostrainicial;
    }

    public void setAmostrainicial(float amostrainicial) {
        this.amostrainicial = amostrainicial;
    }

    @Column(name = "AMOSTRA_24HRS")
    public float getAmostra24hrs() {
        return amostra24hrs;
    }

    public void setAmostra24hrs(float amostra24hrs) {
        this.amostra24hrs = amostra24hrs;
    }

    @Column(name = "AMOSTRA_48HRS")
    public float getAmostra48hrs() {
        return amostra48hrs;
    }

    public void setAmostra48hrs(float amostra48hrs) {
        this.amostra48hrs = amostra48hrs;
    }

    @Column(name = "AMOSTRA_72HRS")
    public float getAmostra72hrs() {
        return amostra72hrs;
    }

    public void setAmostra72hrs(float amostra72hrs) {
        this.amostra72hrs = amostra72hrs;
    }

    public void setId_material(material id_material) {
        this.id_material = id_material;
    }

    @Column(name = "VELOCIDADE")
    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    @Column(name = "TRENA", length = 50)
    public String getTrena() {
        return trena;
    }

    public void setTrena(String trena) {
        this.trena = trena;
    }

    @Column(name = "OBSERVACAO", length = 255)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @Column(name = "DESENHO", length = 50)
    public String getDesenho() {
        return desenho;
    }

    public void setDesenho(String desenho) {
        this.desenho = desenho;
    }
    
    
    

}
