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
public class ModelComposto {

    private int id;
    private int composto;
    private String bpcs;
    private String desc_composto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComposto() {
        return composto;
    }

    public void setComposto(int composto) {
        this.composto = composto;
    }

    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public String getDesc_composto() {
        return desc_composto;
    }

    public void setDesc_composto(String desc_composto) {
        this.desc_composto = desc_composto;
    }

    @Override
    public String toString() {
        return "ModelComposto{" + "id=" + id + ", composto=" + composto + ", bpcs=" + bpcs + ", desc_composto=" + desc_composto + '}';
    }
    
}
