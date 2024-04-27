package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelCausas {

    private long id;
    private String desc_causa;
    private int id_problema;
    private String desc_problema;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc_causa() {
        return desc_causa;
    }

    public void setDesc_causa(String desc_causa) {
        this.desc_causa = desc_causa;
    }

    public int getId_problema() {
        return id_problema;
    }

    public void setId_problema(int id_problema) {
        this.id_problema = id_problema;
    }

    public String getDesc_problema() {
        return desc_problema;
    }

    public void setDesc_problema(String desc_problema) {
        this.desc_problema = desc_problema;
    }

    @Override
    public String toString() {
        return "ModelCausas{" + "id=" + id + ", desc_causa=" + desc_causa + ", id_problema=" + id_problema + ", desc_problema=" + desc_problema + '}';
    }
}
