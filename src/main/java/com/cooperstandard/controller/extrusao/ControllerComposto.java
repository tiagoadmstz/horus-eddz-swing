/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOComposto;
import com.cooperstandard.model.ModelComposto;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerComposto {

    private DAOComposto daoComposto = new DAOComposto();

    public int salvarCompostoController(ModelComposto pModelComposto) {
        return this.daoComposto.salvarCompostoDAO(pModelComposto);
    }

    public ModelComposto getCompostoController(int pCodigo) {
        return this.daoComposto.getCompostoDAO(pCodigo);
    }

    public ModelComposto getCompostoController(Integer pNome) {
        return this.daoComposto.getCompostoDAO(pNome);
    }

    public ArrayList<ModelComposto> getListaCompostoController() {
        return this.daoComposto.getListaCompostoDAO();
    }

    public boolean atualizarCompostoController(ModelComposto pModelComposto) {
        return this.daoComposto.atualizarCompostoDAO(pModelComposto);
    }

    public boolean excluirCompostoController(int pCodigo) {
        return this.daoComposto.excluirCompostoDAO(pCodigo);
    }
}
