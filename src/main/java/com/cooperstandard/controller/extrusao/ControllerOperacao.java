/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;


import com.cooperstandard.dao.extrusao.DAOOperacao;
import com.cooperstandard.model.ModelOperacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerOperacao {

    private DAOOperacao daoOperacao = new DAOOperacao();

    public int salvarOperacaoController(ModelOperacao pModelOperacao) {
        return this.daoOperacao.salvarOperacaoDAO(pModelOperacao);
    }

    public ModelOperacao getOperacaoController(int pCodigo) {
        return this.daoOperacao.getOperacaoDAO(pCodigo);
    }

    public ModelOperacao getOperacaoController(String pNome) {
        return this.daoOperacao.getOperacaoDAO(pNome);
    }

    public ArrayList<ModelOperacao> getListaOperacaoController() {
        return this.daoOperacao.getListaOperacaoDAO();
    }

    public boolean atualizarOperacaoController(ModelOperacao pModelOperacao) {
        return this.daoOperacao.atualizarOperacaoDAO(pModelOperacao);
    }

    public boolean excluirOperacaoController(int pCodigo) {
        return this.daoOperacao.excluirOperacaoDAO(pCodigo);
    }
}
