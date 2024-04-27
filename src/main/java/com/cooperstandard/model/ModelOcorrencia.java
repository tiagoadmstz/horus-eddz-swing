package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelOcorrencia {

    private long id;
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ModeOcorrencia{" + "id=" + id + ", desc=" + desc + '}';
    }

}
