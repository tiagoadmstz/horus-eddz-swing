/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOFichaControleQualidade;
import com.cooperstandard.model.ModelFichaControleQualidade;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerFichaControleQualidade {

    private DAOFichaControleQualidade daoFichaControleQualidade = new DAOFichaControleQualidade();

    public int salvarFichaControleQualidadeController(ModelFichaControleQualidade pModelFichaControleQualidade) {
        return this.daoFichaControleQualidade.salvarFichaControleQualidadeDAO(pModelFichaControleQualidade);
    }

    public ModelFichaControleQualidade getFichaControleQualidadeController(int pCodigo) {
        return this.daoFichaControleQualidade.getFichaControleQualidadeDAO(pCodigo);
    }

    public ModelFichaControleQualidade getFichaControleQualidadeController(String pNome) {
        return this.daoFichaControleQualidade.getFichaControleQualidadeDAO(pNome);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeController(String perfil) {
        return this.daoFichaControleQualidade.getListaFichaControleQualidadeDAO(perfil);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeEditController(String perfil) {
        return this.daoFichaControleQualidade.getListaFichaControleQualidadeEditDAO(perfil);
    }

    public boolean atualizarFichaControleQualidadeController(ModelFichaControleQualidade pModelFichaControleQualidade) {
        return this.daoFichaControleQualidade.atualizarFichaControleQualidadeDAO(pModelFichaControleQualidade);
    }

    public boolean excluirFichaControleQualidadeController(int pCodigo) {
        return this.daoFichaControleQualidade.excluirFichaControleQualidadeDAO(pCodigo);
    }

    public boolean updateStatusFichaControleQualidadeController(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        return this.daoFichaControleQualidade.updatStatus(pModelFichaControleQualidade, perfilupdat);
    }

    public boolean updateProducaoStatusFichaControleQualidadeController(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        return this.daoFichaControleQualidade.updateProducaoStatus(pModelFichaControleQualidade, perfilupdat);
    }

    public boolean CopiaHistoricoControleQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.CopiaHistorico(perfilupdat);
    }

    public boolean CopiaFichaControleQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.CopiaFicha(perfilupdat);
    }

    public boolean DeletaFichaControleQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaFichaControle(perfilupdat);
    }

    public boolean DeletaFichaControleProducaoQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaFichaControleProducao(perfilupdat);
    }

    public boolean DeletaTesteRemovidoQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaTesteRemovido(perfilupdat);
    }

    public boolean DataAlteracaoQualidadeController(String perfilupdat) {
        return this.daoFichaControleQualidade.DataAlteracao(perfilupdat);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaemAbertoAlterController() {
        return this.daoFichaControleQualidade.getListaFichaemAbertoAlterDAO();
    }

    public ModelFichaControleQualidade getFichaController(int pPerfilaberto) {
        return this.daoFichaControleQualidade.getFichaDAO(pPerfilaberto);
    }
}
