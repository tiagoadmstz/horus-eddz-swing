/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOEquipamento;
import com.cooperstandard.model.ModelEquipamento;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerEquipamento {

    private DAOEquipamento daoEquipamento = new DAOEquipamento();

    public int salvarEquipamentoController(ModelEquipamento pModelEquipamento) {
        return this.daoEquipamento.salvarEquipamentoDAO(pModelEquipamento);
    }

    public ModelEquipamento getEquipamentoController(int pCodigo) {
        return this.daoEquipamento.getEquipamentoDAO(pCodigo);
    }

    public ModelEquipamento getEquipamentoController(String pNome) {
        return this.daoEquipamento.getEquipamentoDAO(pNome);
    }

    public ArrayList<ModelEquipamento> getListaEquipamentoController() {
        return this.daoEquipamento.getListaEquipamentoDAO();
    }

    public boolean atualizarEquipamentoController(ModelEquipamento pModelEquipamento) {
        return this.daoEquipamento.atualizarEquipamentoDAO(pModelEquipamento);
    }

    public boolean excluirEquipamentoController(int pCodigo) {
        return this.daoEquipamento.excluirEquipamentoDAO(pCodigo);
    }
}
