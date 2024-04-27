package com.cooperstandard.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelVelocidade {

    private long id;
    private Timestamp data_cadastro;
    private float velocidade;
    private int id_material;
    private int material;
    private String linha;
    private float custo;
    private float peso;
    private float meta;
    private String desc_perfil;
    private String imagem;
    private String bpcs;

}
