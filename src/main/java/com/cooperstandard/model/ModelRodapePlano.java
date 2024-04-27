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
public class ModelRodapePlano {

    private int id;
    private int rodplan_material;
    private String rodplan_linha;
    private String rodplan_data;
    private int rodplan_rev;
    private String rodplan_descricao;
    private String rodplan_emitente;
    private String rodplan_setor;
    private String rodplan_responsavel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRodplan_material() {
        return rodplan_material;
    }

    public void setRodplan_material(int rodplan_material) {
        this.rodplan_material = rodplan_material;
    }

    public String getRodplan_linha() {
        return rodplan_linha;
    }

    public void setRodplan_linha(String rodplan_linha) {
        this.rodplan_linha = rodplan_linha;
    }

    public String getRodplan_data() {
        return rodplan_data;
    }

    public void setRodplan_data(String rodplan_data) {
        this.rodplan_data = rodplan_data;
    }

    public int getRodplan_rev() {
        return rodplan_rev;
    }

    public void setRodplan_rev(int rodplan_rev) {
        this.rodplan_rev = rodplan_rev;
    }

    public String getRodplan_descricao() {
        return rodplan_descricao;
    }

    public void setRodplan_descricao(String rodplan_descricao) {
        this.rodplan_descricao = rodplan_descricao;
    }

    public String getRodplan_emitente() {
        return rodplan_emitente;
    }

    public void setRodplan_emitente(String rodplan_emitente) {
        this.rodplan_emitente = rodplan_emitente;
    }

    public String getRodplan_setor() {
        return rodplan_setor;
    }

    public void setRodplan_setor(String rodplan_setor) {
        this.rodplan_setor = rodplan_setor;
    }

    public String getRodplan_responsavel() {
        return rodplan_responsavel;
    }

    public void setRodplan_responsavel(String rodplan_responsavel) {
        this.rodplan_responsavel = rodplan_responsavel;
    }

    @Override
    public String toString() {
        return "ModelRodapePlano{" + "id=" + id + ", rodplan_material=" + rodplan_material + ", rodplan_linha=" + rodplan_linha + ", rodplan_data=" + rodplan_data + ", rodplan_rev=" + rodplan_rev + ", rodplan_descricao=" + rodplan_descricao + ", rodplan_emitente=" + rodplan_emitente + ", rodplan_setor=" + rodplan_setor + ", rodplan_responsavel=" + rodplan_responsavel + '}';
    }

}
