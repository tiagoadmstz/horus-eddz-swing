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
public class ModelProjeto {

    private int id_projeto;
    private String projeto;
    private String pro_oem;

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getPro_oem() {
        return pro_oem;
    }

    public void setPro_oem(String pro_oem) {
        this.pro_oem = pro_oem;
    }

    @Override
    public String toString() {
        return "ModelProjeto{" + "id_projeto=" + id_projeto + ", projeto=" + projeto + ", pro_oem=" + pro_oem + '}';
    }

}
