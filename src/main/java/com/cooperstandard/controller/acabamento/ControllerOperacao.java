/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;



import com.cooperstandard.model.ModelOperacao;
import com.cooperstandard.dao.acabamento.DAOOperacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerOperacao {

    private DAOOperacao daoOperacao = new DAOOperacao();

    public int salvarOperacaoAcController(ModelOperacao pModelOperacao) {
        return this.daoOperacao.salvarOperacaoAcDAO(pModelOperacao);
    }

    public ModelOperacao getOperacaoAcController(int pCodigo) {
        return this.daoOperacao.getOperacaoAcDAO(pCodigo);
    }

    public ModelOperacao getOperacaoController(String pNome) {
        return this.daoOperacao.getOperacaoAcDAO(pNome);
    }

    public ArrayList<ModelOperacao> getListaOperacaoAcController() {
        return this.daoOperacao.getListaOperacaoAcDAO();
    }

    public boolean atualizarOperacaoAcController(ModelOperacao pModelOperacao) {
        return this.daoOperacao.atualizarOperacaoAcDAO(pModelOperacao);
    }

    public boolean excluirOperacaoAcController(int pCodigo) {
        return this.daoOperacao.excluirOperacaoAcDAO(pCodigo);
    }
}
