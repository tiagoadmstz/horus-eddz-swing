package com.cooperstandard.model;

import java.sql.Timestamp;

/**
 *
 * @author rsouza10
 */
public class ModelIdControle {

    private int ID;
    private int material;
    private Timestamp data_base;
    private String linha;
    private float scrap_total;
    private String evidencia;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public Timestamp getData_base() {
        return data_base;
    }

    public void setData_base(Timestamp data_base) {
        this.data_base = data_base;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public float getScrap_total() {
        return scrap_total;
    }

    public void setScrap_total(float scrap_total) {
        this.scrap_total = scrap_total;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    @Override
    public String toString() {
        return "ModelIdControle{" + "ID=" + ID + ", material=" + material + ", data_base=" + data_base + ", linha=" + linha + ", scrap_total=" + scrap_total + ", evidencia=" + evidencia + '}';
    }

}
