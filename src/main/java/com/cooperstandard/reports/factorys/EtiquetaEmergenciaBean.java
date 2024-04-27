
package com.cooperstandard.reports.factorys;

import java.io.Serializable;

/**
 *
 * @author tiago.teixeira
 */
public class EtiquetaEmergenciaBean implements Serializable {

    private static final long serialVersionUID = 4522964550853547505L;
    private int tcPerfil;
    private String bpcs;
    private String dPerfil;
    private String Blooming;
    private String CChart;
    private String Densidade;
    private String MH;
    private String ML;
    private String MV;
    private String T5;
    private String T90;
    private String TS2;
    private Integer batch;

    public EtiquetaEmergenciaBean() {
    }

    public EtiquetaEmergenciaBean(int tcPerfil, String bpcs, String dPerfil, String Blooming, String CChart, String Densidade, String MH, String ML, String MV, String T5, String T90, String TS2) {
        this.tcPerfil = tcPerfil;
        this.bpcs = bpcs;
        this.dPerfil = dPerfil;
        this.Blooming = Blooming;
        this.CChart = CChart;
        this.Densidade = Densidade;
        this.MH = MH;
        this.ML = ML;
        this.MV = MV;
        this.T5 = T5;
        this.T90 = T90;
        this.TS2 = TS2;
    }

    public EtiquetaEmergenciaBean(EtiquetaEmergenciaBean etiquetaEmergenciaBean) {
        copiar(etiquetaEmergenciaBean);
    }

    private void copiar(EtiquetaEmergenciaBean etiquetaEmergenciaBean) {
        this.tcPerfil = etiquetaEmergenciaBean.getTcPerfil();
        this.bpcs = etiquetaEmergenciaBean.getBpcs();
        this.dPerfil = etiquetaEmergenciaBean.getdPerfil();
        this.Blooming = etiquetaEmergenciaBean.getBlooming();
        this.CChart = etiquetaEmergenciaBean.getCChart();
        this.Densidade = etiquetaEmergenciaBean.getDensidade();
        this.MH = etiquetaEmergenciaBean.getMH();
        this.ML = etiquetaEmergenciaBean.getML();
        this.MV = etiquetaEmergenciaBean.getMV();
        this.T5 = etiquetaEmergenciaBean.getT5();
        this.T90 = etiquetaEmergenciaBean.getT90();
        this.TS2 = etiquetaEmergenciaBean.getTS2();
    }

    public int getTcPerfil() {
        return tcPerfil;
    }

    public void setTcPerfil(int tcPerfil) {
        this.tcPerfil = tcPerfil;
    }

    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public String getdPerfil() {
        return dPerfil;
    }

    public void setdPerfil(String dPerfil) {
        this.dPerfil = dPerfil;
    }

    public String getBlooming() {
        return Blooming;
    }

    public void setBlooming(String Blooming) {
        this.Blooming = Blooming;
    }

    public String getCChart() {
        return CChart;
    }

    public void setCChart(String CChart) {
        this.CChart = CChart;
    }

    public String getDensidade() {
        return Densidade;
    }

    public void setDensidade(String Densidade) {
        this.Densidade = Densidade;
    }

    public String getMH() {
        return MH;
    }

    public void setMH(String MH) {
        this.MH = MH;
    }

    public String getML() {
        return ML;
    }

    public void setML(String ML) {
        this.ML = ML;
    }

    public String getMV() {
        return MV;
    }

    public void setMV(String MV) {
        this.MV = MV;
    }

    public String getT5() {
        return T5;
    }

    public void setT5(String T5) {
        this.T5 = T5;
    }

    public String getT90() {
        return T90;
    }

    public void setT90(String T90) {
        this.T90 = T90;
    }

    public String getTS2() {
        return TS2;
    }

    public void setTS2(String TS2) {
        this.TS2 = TS2;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

}
