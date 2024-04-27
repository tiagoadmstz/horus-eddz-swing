/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelTeste {

    private int id_teste;
    private int ordem;
    private String cod_teste;
    private String desc_teste;
    private String tes_equipamento;
    private String control_prcess;
    private String classificacao;

    public int getId_teste() {
        return id_teste;
    }

    public void setId_teste(int id_teste) {
        this.id_teste = id_teste;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getCod_teste() {
        return cod_teste;
    }

    public void setCod_teste(String cod_teste) {
        this.cod_teste = cod_teste;
    }

    public String getDesc_teste() {
        return desc_teste;
    }

    public void setDesc_teste(String desc_teste) {
        this.desc_teste = desc_teste;
    }

    public String getTes_equipamento() {
        return tes_equipamento;
    }

    public void setTes_equipamento(String tes_equipamento) {
        this.tes_equipamento = tes_equipamento;
    }

    public String getControl_prcess() {
        return control_prcess;
    }

    public void setControl_prcess(String control_prcess) {
        this.control_prcess = control_prcess;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return "ModelTeste{" + "id_teste=" + id_teste + ", ordem=" + ordem + ", cod_teste=" + cod_teste + ", desc_teste=" + desc_teste + ", tes_equipamento=" + tes_equipamento + ", control_prcess=" + control_prcess + ", classificacao=" + classificacao + '}';
    }
    
    

}
