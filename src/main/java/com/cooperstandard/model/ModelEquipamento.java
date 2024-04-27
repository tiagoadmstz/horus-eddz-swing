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
public class ModelEquipamento {

    private int id_equipamento;
    private int ordem;
    private String equipamento;
    private String equ_operacao;

    public int getId_equipamento() {
        return id_equipamento;
    }

    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getEqu_operacao() {
        return equ_operacao;
    }

    public void setEqu_operacao(String equ_operacao) {
        this.equ_operacao = equ_operacao;
    }

    @Override
    public String toString() {
        return "ModelEquipamento{" + "id_equipamento=" + id_equipamento + ", ordem=" + ordem + ", equipamento=" + equipamento + ", equ_operacao=" + equ_operacao + '}';
    }
    
    
}
