/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelOperacao {
    
private int id_operacao;
private int ordem;
private String operacao;
private String ope_setor;
private int cod_op;
private String cliente;
private String cod_simbol_op;
private String fornecedor;
private String preparado_por;
private String telefone;
private String responsavel_processo;
private String equipe;
private String data_criacao;

    public int getId_operacao() {
        return id_operacao;
    }

    public void setId_operacao(int id_operacao) {
        this.id_operacao = id_operacao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getOpe_setor() {
        return ope_setor;
    }

    public void setOpe_setor(String ope_setor) {
        this.ope_setor = ope_setor;
    }

    public int getCod_op() {
        return cod_op;
    }

    public void setCod_op(int cod_op) {
        this.cod_op = cod_op;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCod_simbol_op() {
        return cod_simbol_op;
    }

    public void setCod_simbol_op(String cod_simbol_op) {
        this.cod_simbol_op = cod_simbol_op;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPreparado_por() {
        return preparado_por;
    }

    public void setPreparado_por(String preparado_por) {
        this.preparado_por = preparado_por;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel_processo() {
        return responsavel_processo;
    }

    public void setResponsavel_processo(String responsavel_processo) {
        this.responsavel_processo = responsavel_processo;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Override
    public String toString() {
        return "ModelOperacao{" + "id_operacao=" + id_operacao + ", ordem=" + ordem + ", operacao=" + operacao + ", ope_setor=" + ope_setor + ", cod_op=" + cod_op + ", cliente=" + cliente + ", cod_simbol_op=" + cod_simbol_op + ", fornecedor=" + fornecedor + ", preparado_por=" + preparado_por + ", telefone=" + telefone + ", responsavel_processo=" + responsavel_processo + ", equipe=" + equipe + ", data_criacao=" + data_criacao + '}';
    }


}
