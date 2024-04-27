/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOControleProcesso;
import com.cooperstandard.model.ModelControleProcesso;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerControleProcesso {

    private DAOControleProcesso daoControleProcesso = new DAOControleProcesso();

    public int salvarControleProcessoController(ModelControleProcesso pModelControleProcesso) {
        return this.daoControleProcesso.salvarControleProcessoDAO(pModelControleProcesso);
    }

    public ModelControleProcesso getControleProcessoController(int pCodigo) {
        return this.daoControleProcesso.getControleProcessoDAO(pCodigo);
    }

    public ModelControleProcesso getControleProcessoController(String pNome) {
        return this.daoControleProcesso.getControleProcessoDAO(pNome);
    }

    public ArrayList<ModelControleProcesso> getListaControleProcessoController() {
        return this.daoControleProcesso.getListaControleProcessoDAO();
    }

    public boolean atualizarControleProcessoController(ModelControleProcesso pModelControleProcesso) {
        return this.daoControleProcesso.atualizarControleProcessoDAO(pModelControleProcesso);
    }

    public boolean excluirControleProcessoController(int pCodigo) {
        return this.daoControleProcesso.excluirControleProcessoDAO(pCodigo);
    }
}
