/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelTeste;
import com.cooperstandard.dao.acabamento.DAOTeste;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerTeste {

    private DAOTeste daoTeste = new DAOTeste();

    public int salvarTesteAcController(ModelTeste pModelTeste) {
        return this.daoTeste.salvarTesteAcDAO(pModelTeste);
    }

    public ModelTeste getTesteAcController(int pCodigo) {
        return this.daoTeste.getTesteAcDAO(pCodigo);
    }

    public ModelTeste getTesteAcController(Integer pNome) {
        return this.daoTeste.getTesteAcDAO(pNome);
    }

    public ArrayList<ModelTeste> getListaTesteAcController() {
        return this.daoTeste.getListaTesteAcDAO();
    }

    public boolean atualizarTesteAcController(ModelTeste pModelTeste) {
        return this.daoTeste.atualizarTesteAcDAO(pModelTeste);
    }

    public boolean excluirTesteAcController(int pCodigo) {
        return this.daoTeste.excluirTesteAcDAO(pCodigo);
    }
}
