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
public class ModelLinha {

    private int id_linha;
    private int ordem;
    private String linha;
    private String tipo_linha;
    private String setor;
    private String n_plano;
    private String contatoChave;
    private String equipe_principal;
    private String data_inicial;

    public int getId_linha() {
        return id_linha;
    }

    public void setId_linha(int id_linha) {
        this.id_linha = id_linha;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getTipo_linha() {
        return tipo_linha;
    }

    public void setTipo_linha(String tipo_linha) {
        this.tipo_linha = tipo_linha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getN_plano() {
        return n_plano;
    }

    public void setN_plano(String n_plano) {
        this.n_plano = n_plano;
    }

    public String getContatoChave() {
        return contatoChave;
    }

    public void setContatoChave(String contatoChave) {
        this.contatoChave = contatoChave;
    }

    public String getEquipe_principal() {
        return equipe_principal;
    }

    public void setEquipe_principal(String equipe_principal) {
        this.equipe_principal = equipe_principal;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    @Override
    public String toString() {
        return "ModelLinha{" + "id_linha=" + id_linha + ", ordem=" + ordem + ", linha=" + linha + ", tipo_linha=" + tipo_linha + ", setor=" + setor + ", n_plano=" + n_plano + ", contatoChave=" + contatoChave + ", equipe_principal=" + equipe_principal + ", data_inicial=" + data_inicial + '}';
    }

}
