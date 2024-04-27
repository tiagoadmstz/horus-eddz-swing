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
public class ModelUnidFreq {

    private String unidade_frequencia;
    private int id;
    private String setor;

    public String getUnidade_frequencia() {
        return unidade_frequencia;
    }

    public void setUnidade_frequencia(String unidade_frequencia) {
        this.unidade_frequencia = unidade_frequencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "ModelUnidFreq{" + "unidade_frequencia=" + unidade_frequencia + ", id=" + id + ", setor=" + setor + '}';
    }

}
