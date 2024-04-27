/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelEquipamento;
import com.cooperstandard.dao.acabamento.DAOEquipamento;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerEquipamento {

    private DAOEquipamento daoEquipamento = new DAOEquipamento();

    public int salvarEquipamentoAcController(ModelEquipamento pModelEquipamento) {
        return this.daoEquipamento.salvarEquipamentoAcDAO(pModelEquipamento);
    }

    public ModelEquipamento getEquipamentoAcController(int pCodigo) {
        return this.daoEquipamento.getEquipamentoAcDAO(pCodigo);
    }

    public ModelEquipamento getEquipamentoAcController(String pNome) {
        return this.daoEquipamento.getEquipamentoAcDAO(pNome);
    }

    public ArrayList<ModelEquipamento> getListaEquipamentoAcController() {
        return this.daoEquipamento.getListaEquipamentoAcDAO();
    }

    public boolean atualizarEquipamentoAcController(ModelEquipamento pModelEquipamento) {
        return this.daoEquipamento.atualizarEquipamentoAcDAO(pModelEquipamento);
    }

    public boolean excluirEquipamentoAcController(int pCodigo) {
        return this.daoEquipamento.excluirEquipamentoAcDAO(pCodigo);
    }
}
