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
public class ModelMontadora {
    private String oem;
    private int id_oem;

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public int getId_oem() {
        return id_oem;
    }

    public void setId_oem(int id_oem) {
        this.id_oem = id_oem;
    }

    @Override
    public String toString() {
        return "ModelMontadora{" + "oem=" + oem + ", id_oem=" + id_oem + '}';
    }
    
    
    
}
