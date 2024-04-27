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
public class ModelRodape {

    private int id;
    private String rod_data;
    private int rod_rev;
    private String rod_descricao;
    private String rod_emitente;
    private String rod_setor;
    private String rod_responsavel;
    private int rod_material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRod_data() {
        return rod_data;
    }

    public void setRod_data(String rod_data) {
        this.rod_data = rod_data;
    }

    public int getRod_rev() {
        return rod_rev;
    }

    public void setRod_rev(int rod_rev) {
        this.rod_rev = rod_rev;
    }

    public String getRod_descricao() {
        return rod_descricao;
    }

    public void setRod_descricao(String rod_descricao) {
        this.rod_descricao = rod_descricao;
    }

    public String getRod_emitente() {
        return rod_emitente;
    }

    public void setRod_emitente(String rod_emitente) {
        this.rod_emitente = rod_emitente;
    }

    public String getRod_setor() {
        return rod_setor;
    }

    public void setRod_setor(String rod_setor) {
        this.rod_setor = rod_setor;
    }

    public String getRod_responsavel() {
        return rod_responsavel;
    }

    public void setRod_responsavel(String rod_responsavel) {
        this.rod_responsavel = rod_responsavel;
    }

    public int getRod_material() {
        return rod_material;
    }

    public void setRod_material(int rod_material) {
        this.rod_material = rod_material;
    }

    @Override
    public String toString() {
        return "ModelRodape{" + "id=" + id + ", rod_data=" + rod_data + ", rod_rev=" + rod_rev + ", rod_descricao=" + rod_descricao + ", rod_emitente=" + rod_emitente + ", rod_setor=" + rod_setor + ", roda_responsavel=" + rod_responsavel + ", rod_material=" + rod_material + '}';
    }

}
