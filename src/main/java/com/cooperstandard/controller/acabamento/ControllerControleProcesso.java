/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;

import com.cooperstandard.model.ModelControleProcesso;
import com.cooperstandard.dao.acabamento.DAOControleProcesso;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerControleProcesso {

    private DAOControleProcesso daoControleProcesso = new DAOControleProcesso();

    public int salvarControleProcessoAcController(ModelControleProcesso pModelControleProcesso) {
        return this.daoControleProcesso.salvarControleProcessoAcDAO(pModelControleProcesso);
    }

    public ModelControleProcesso getControleProcessoAcController(int pCodigo) {
        return this.daoControleProcesso.getControleProcessoAcDAO(pCodigo);
    }

    public ModelControleProcesso getControleProcessoAcController(String pNome) {
        return this.daoControleProcesso.getControleProcessoAcDAO(pNome);
    }

    public ArrayList<ModelControleProcesso> getListaControleProcessoAcController() {
        return this.daoControleProcesso.getListaControleProcessoAcDAO();
    }

    public boolean atualizarControleProcessoAcController(ModelControleProcesso pModelControleProcesso) {
        return this.daoControleProcesso.atualizarControleProcessoAcDAO(pModelControleProcesso);
    }

    public boolean excluirControleProcessoAcController(int pCodigo) {
        return this.daoControleProcesso.excluirControleProcessoAcDAO(pCodigo);
    }
}
