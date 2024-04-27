/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;

import com.cooperstandard.model.ModelFichaControle;
import com.cooperstandard.dao.acabamento.DAOFichaControleAc;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerFichaControleAc {

    private DAOFichaControleAc daoFichaControle = new DAOFichaControleAc();

    public int salvarFichaControleAcController(ModelFichaControle pModelFichaControle) {
        return this.daoFichaControle.salvarFichaControleAcDAO(pModelFichaControle);
    }

    public ModelFichaControle getFichaControleAcController(int pCodigo) {
        return this.daoFichaControle.getFichaControleAcDAO(pCodigo);
    }

    public ModelFichaControle getFichaControleAcController(String pNome) {
        return this.daoFichaControle.getFichaControleAcDAO(pNome);
    }

    public ArrayList<ModelFichaControle> getListaFichaControleAcController(String perfil) {
        return this.daoFichaControle.getListaFichaControleAcDAO(perfil);
    }

    public ArrayList<ModelFichaControle> getListaFichaControleEditAcController(String perfil) {
        return this.daoFichaControle.getListaFichaControleEditAcDAO(perfil);
    }

    public boolean atualizarFichaControleAcController(ModelFichaControle pModelFichaControle) {
        return this.daoFichaControle.atualizarFichaControleAcDAO(pModelFichaControle);
    }

    public boolean excluirFichaControleAcController(int pCodigo) {
        return this.daoFichaControle.excluirFichaControleAcDAO(pCodigo);
    }

    public boolean updateStatusFichaControleAcController(String perfilupdat, String pendencia, String responsavel) {
        return this.daoFichaControle.updatStatusAc(perfilupdat, pendencia, responsavel);
    }

    public boolean updatecopiaStatusFichaControleAcController(ModelFichaControle pModelFichaControle, String perfilupdat) {
        return this.daoFichaControle.updatecopiaStatusAc(pModelFichaControle, perfilupdat);
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoAcController() {
        return this.daoFichaControle.getListaFichaemAbertoAcDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoAcAlterController() {
        return this.daoFichaControle.getListaFichaemAbertoAlterAcDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoCopiaAcController() {
        return this.daoFichaControle.getListaFichaemAbertoCopiaAcDAO();
    }

    public ModelFichaControle getFichaAcController(int pPerfilaberto) {
        return this.daoFichaControle.getFichaAcDAO(pPerfilaberto);
    }

    public boolean updateStatusAlterarFichaControleAcController(ModelFichaControle pModelFichaControle, String perfilupdat) {
        return this.daoFichaControle.updatStatusAlterarAc(pModelFichaControle, perfilupdat);
    }

    public ArrayList<ModelFichaControle> getListaFichaValidacaoAcController() {
        return this.daoFichaControle.getListaFichaValidacaoAcDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaControleComboAcController() {
        return this.daoFichaControle.getListaFichaControleComboAcDAO();
    }
}
