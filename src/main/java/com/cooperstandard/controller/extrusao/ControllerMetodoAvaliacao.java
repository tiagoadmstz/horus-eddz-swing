/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOMetodoAvaliacao;
import com.cooperstandard.model.ModelMetodoAvaliacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerMetodoAvaliacao {

    private DAOMetodoAvaliacao daoMetodoAvaliacao = new DAOMetodoAvaliacao();

    public int salvarMetodoAvaliacaoController(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        return this.daoMetodoAvaliacao.salvarMetodoAvaliacaoDAO(pModelMetodoAvaliacao);
    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoController(int pCodigo) {
        return this.daoMetodoAvaliacao.getMetodoAvaliacaoDAO(pCodigo);
    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoController(String pNome) {
        return this.daoMetodoAvaliacao.getMetodoAvaliacaoDAO(pNome);
    }

    public ArrayList<ModelMetodoAvaliacao> getListaMetodoAvaliacaoController() {
        return this.daoMetodoAvaliacao.getListaMetodoAvaliacaoDAO();
    }

    public boolean atualizarMetodoAvaliacaoController(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        return this.daoMetodoAvaliacao.atualizarMetodoAvaliacaoDAO(pModelMetodoAvaliacao);
    }

    public boolean excluirMetodoAvaliacaoController(int pCodigo) {
        return this.daoMetodoAvaliacao.excluirMetodoAvaliacaoDAO(pCodigo);
    }
}
