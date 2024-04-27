/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;

import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.dao.acabamento.DAOLinhaAc;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerLinhaAc {

    private DAOLinhaAc daoLinhaAc = new DAOLinhaAc();

    public int salvarLinhaAcController(ModelLinha pModelLinha) {
        return this.daoLinhaAc.salvarLinhaAcDAO(pModelLinha);
    }

    public ModelLinha getLinhaAcController(int pCodigo) {
        return this.daoLinhaAc.getLinhaAcDAO(pCodigo);
    }

    public ModelLinha getLinhaAcController(String pNome) {
        return this.daoLinhaAc.getLinhaAcDAO(pNome);
    }

    public ArrayList<ModelLinha> getListaLinhaAcController() {
        return this.daoLinhaAc.getListaLinhaAcDAO();
    }

    public boolean atualizarLinhaAcController(ModelLinha pModelLinha) {
        return this.daoLinhaAc.atualizarLinhaAcDAO(pModelLinha);
    }

    public boolean excluirLinhaAcController(int pCodigo) {
        return this.daoLinhaAc.excluirLinhaAcDAO(pCodigo);
    }
}
