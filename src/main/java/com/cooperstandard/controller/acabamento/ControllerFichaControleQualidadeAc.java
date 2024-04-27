/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelFichaControleQualidade;
import com.cooperstandard.dao.acabamento.DAOFichaControleQualidadeAc;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerFichaControleQualidadeAc {

    private DAOFichaControleQualidadeAc daoFichaControleQualidade = new DAOFichaControleQualidadeAc();

    public int salvarFichaControleQualidadeAcController(ModelFichaControleQualidade pModelFichaControleQualidade) {
        return this.daoFichaControleQualidade.salvarFichaControleQualidadeAcDAO(pModelFichaControleQualidade);
    }

    public ModelFichaControleQualidade getFichaControleQualidadeAcController(int pCodigo) {
        return this.daoFichaControleQualidade.getFichaControleQualidadeAcDAO(pCodigo);
    }

    public ModelFichaControleQualidade getFichaControleQualidadeAcController(String pNome) {
        return this.daoFichaControleQualidade.getFichaControleQualidadeAcDAO(pNome);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeAcController(String perfil) {
        return this.daoFichaControleQualidade.getListaFichaControleQualidadeAcDAO(perfil);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeAcEditController(String perfil) {
        return this.daoFichaControleQualidade.getListaFichaControleQualidadeEditAcDAO(perfil);
    }

    public boolean atualizarFichaControleQualidadeAcController(ModelFichaControleQualidade pModelFichaControleQualidade) {
        return this.daoFichaControleQualidade.atualizarFichaControleQualidadeAcDAO(pModelFichaControleQualidade);
    }

    public boolean excluirFichaControleQualidadeAcController(int pCodigo) {
        return this.daoFichaControleQualidade.excluirFichaControleQualidadeAcDAO(pCodigo);
    }

    public boolean updateStatusFichaControleQualidadeAcController(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        return this.daoFichaControleQualidade.updatStatusAc(pModelFichaControleQualidade, perfilupdat);
    }

    public boolean updateProducaoStatusFichaControleQualidadeAcController(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        return this.daoFichaControleQualidade.updateProducaoStatusAc(pModelFichaControleQualidade, perfilupdat);
    }

    public boolean CopiaHistoricoControleQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.CopiaHistoricoAc(perfilupdat);
    }

    public boolean CopiaFichaControleQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.CopiaFichaAc(perfilupdat);
    }

    public boolean DeletaFichaControleQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaFichaControleAc(perfilupdat);
    }

    public boolean DeletaFichaControleProducaoQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaFichaControleProducaoAc(perfilupdat);
    }

    public boolean DeletaTesteRemovidoQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.DeletaTesteRemovidoAc(perfilupdat);
    }

    public boolean DataAlteracaoQualidadeAcController(String perfilupdat) {
        return this.daoFichaControleQualidade.DataAlteracaoAc(perfilupdat);
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaemAbertoAlterAcController() {
        return this.daoFichaControleQualidade.getListaFichaemAbertoAlterAcDAO();
    }

    public ModelFichaControleQualidade getFichaAcController(int pPerfilaberto) {
        return this.daoFichaControleQualidade.getFichaAcDAO(pPerfilaberto);
    }
}
