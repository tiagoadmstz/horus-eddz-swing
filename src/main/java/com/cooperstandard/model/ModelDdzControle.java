package com.cooperstandard.model;

import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelDdzControle {

    private long id;
    private int material;
    private String data_base;
    private String linha;
    private float scrap_total;
    private float custo;
    private float velocidade;
    private float peso;

}
