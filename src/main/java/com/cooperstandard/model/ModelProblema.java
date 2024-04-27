package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelProblema {

    private long id;
    private String desc_problema;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc_problema() {
        return desc_problema;
    }

    public void setDesc_problema(String desc_problema) {
        this.desc_problema = desc_problema;
    }

    @Override
    public String toString() {
        return "ModelProblema{" + "id=" + id + ", desc_problema=" + desc_problema + '}';
    }

}
