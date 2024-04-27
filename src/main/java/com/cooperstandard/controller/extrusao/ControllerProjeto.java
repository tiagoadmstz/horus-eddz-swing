/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOProjeto;
import com.cooperstandard.model.ModelProjeto;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerProjeto {

    private DAOProjeto daoProjeto = new DAOProjeto();

    public int salvarProjetoController(ModelProjeto pModelProjeto) {
        return this.daoProjeto.salvarProjetoDAO(pModelProjeto);
    }

    public ModelProjeto getProjetoController(int pCodigo) {
        return this.daoProjeto.getProjetoDAO(pCodigo);
    }

    public ModelProjeto getProjetoController(String pNome) {
        return this.daoProjeto.getProjetoDAO(pNome);
    }

    public ArrayList<ModelProjeto> getListaProjetoController() {
        return this.daoProjeto.getListaProjetoDAO();
    }

    public boolean atualizarProjetoController(ModelProjeto pModelProjeto) {
        return this.daoProjeto.atualizarProjetoDAO(pModelProjeto);
    }

    public boolean excluirProjetoController(int pCodigo) {
        return this.daoProjeto.excluirProjetoDAO(pCodigo);
    }
}
