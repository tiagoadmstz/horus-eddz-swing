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
public class ModelControleProcesso {

    private int id;
    private String metodo_avaliacao;
    private String desc_controle;
    private String prevent_detect;
    private String Setor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo_avaliacao() {
        return metodo_avaliacao;
    }

    public void setMetodo_avaliacao(String metodo_avaliacao) {
        this.metodo_avaliacao = metodo_avaliacao;
    }

    public String getDesc_controle() {
        return desc_controle;
    }

    public void setDesc_controle(String desc_controle) {
        this.desc_controle = desc_controle;
    }

    public String getPrevent_detect() {
        return prevent_detect;
    }

    public void setPrevent_detect(String prevent_detect) {
        this.prevent_detect = prevent_detect;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    @Override
    public String toString() {
        return "ModelControleProcesso{" + "id=" + id + ", metodo_avaliacao=" + metodo_avaliacao + ", desc_controle=" + desc_controle + ", prevent_detect=" + prevent_detect + ", Setor=" + Setor + '}';
    }

}
