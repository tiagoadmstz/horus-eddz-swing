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
public class ModelMetodoAvaliacao {

    private int id;
    private String desc_metodo;
    private String setor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc_metodo() {
        return desc_metodo;
    }

    public void setDesc_metodo(String desc_metodo) {
        this.desc_metodo = desc_metodo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "ModelMetodoAvaliacao{" + "id=" + id + ", desc_metodo=" + desc_metodo + ", setor=" + setor + '}';
    }

}
