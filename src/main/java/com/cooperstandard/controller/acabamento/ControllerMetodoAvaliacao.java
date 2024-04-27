/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelMetodoAvaliacao;
import com.cooperstandard.dao.acabamento.DAOMetodoAvaliacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerMetodoAvaliacao {

    private DAOMetodoAvaliacao daoMetodoAvaliacao = new DAOMetodoAvaliacao();

    public int salvarMetodoAvaliacaoAcController(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        return this.daoMetodoAvaliacao.salvarMetodoAvaliacaoAcDAO(pModelMetodoAvaliacao);
    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoAcController(int pCodigo) {
        return this.daoMetodoAvaliacao.getMetodoAvaliacaoAcDAO(pCodigo);
    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoAcController(String pNome) {
        return this.daoMetodoAvaliacao.getMetodoAvaliacaoAcDAO(pNome);
    }

    public ArrayList<ModelMetodoAvaliacao> getListaMetodoAvaliacaoAcController() {
        return this.daoMetodoAvaliacao.getListaMetodoAvaliacaoAcDAO();
    }

    public boolean atualizarMetodoAvaliacaoAcController(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        return this.daoMetodoAvaliacao.atualizarMetodoAvaliacaoAcDAO(pModelMetodoAvaliacao);
    }

    public boolean excluirMetodoAvaliacaoAcController(int pCodigo) {
        return this.daoMetodoAvaliacao.excluirMetodoAvaliacaoAcDAO(pCodigo);
    }
}
