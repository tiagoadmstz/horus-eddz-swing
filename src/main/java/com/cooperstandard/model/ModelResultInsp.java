package com.cooperstandard.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelResultInsp {

    private int id;
    private Timestamp data_registro;
    private String solicitante;
    private int analista;
    private String data_jet;
    private String hora_jet;
    private String tipo;
    private String resultado_texto;
    private float resultado_num;
    private String status;
    private String obs;
    private int id_espec_id;
    private int id_material_id;
    private String usuario;
    private String desc_material;
    private String ordem;
    private String desc_teste;
    private String espec_completo;
    private String complemento;
    private String nome;
    private float min;
    private float max;
    private String texto;
    private String referencia;
    private String Tipo_espec;
    private String observacao;
    private float minimo;
    private float maximo;
    private String reconhecimento;
    private String aprovador;
    private int id_controle;
}
