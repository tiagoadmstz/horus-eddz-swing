/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelEspecLab {

    private int id;
    private int ordem;
    private float minimo;
    private float maximo;
    private String unid_medida;
    private String texto;
    private String referencia;
    private String tipo_espec;
    private String observacao;
    private String historico;
    private String atributo;
    private String inf;
    private String sup;
    private String bilateral;
    private String informativo;
    private String id_material_id;
    private String id_teste_id;
    private String desc_teste;
    private String equipamento;
    private String cod_teste;
    private String espec_completo;
    private String result_text;
    private float result_num;
    private String obs;
    private String status;
    private String data_registro;

}
