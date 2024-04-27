package com.cooperstandard.model;

import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelEncolhimento {

    private long id;
    private String data;
    private String hora;
    private String periodo;
    private float amostrainicial;
    private float amostra24hrs;
    private float amostra48hrs;
    private float amostra72hrs;
    private long id_material;
    private float velocidade;
    private String trena;
    private String desenho;
    private String observacao;
    private String dhjet;

}
