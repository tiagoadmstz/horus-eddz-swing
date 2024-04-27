package com.cooperstandard.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelDDZ {

    private long id;
    private int id_material;
    private String turno;
    private int id_causa;
    private float qtd_scrap;
    private String data_input;
    private String hora_input;
    private String observacao;
    private String acao_tomada;
    private Timestamp hora;
    private float qtd_scrap_reais;
    private float qtd_scrap_kg;
    private String desc_problema;
    private String desc_causa;
    private int material;
    private String desc_material;
    private String linha;
    private String bpcs;
    private float velocidade;
    private float peso;
    private Timestamp data;
    private Timestamp data_real;
    private String plano;
    private int prioridade;
    private String participantes;
    private String responsavel;
    private String data_conclusao;
    private String data_plano;
    private String flag;
    private String status;
    private String avaliacao;
    private String data_prazo;
    private int id_controle;

}
