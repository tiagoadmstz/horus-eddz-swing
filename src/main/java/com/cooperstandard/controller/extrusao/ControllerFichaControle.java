/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOFichaControle;
import com.cooperstandard.model.ModelFichaControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerFichaControle {

    private DAOFichaControle daoFichaControle = new DAOFichaControle();

    public int salvarFichaControleController(ModelFichaControle pModelFichaControle) {
        return this.daoFichaControle.salvarFichaControleDAO(pModelFichaControle);
    }

    public ModelFichaControle getFichaControleController(int pCodigo) {
        return this.daoFichaControle.getFichaControleDAO(pCodigo);
    }

    public ModelFichaControle getFichaControleController(String pNome) {
        return this.daoFichaControle.getFichaControleDAO(pNome);
    }

    public ArrayList<ModelFichaControle> getListaFichaControleController(String perfil) {
        return this.daoFichaControle.getListaFichaControleDAO(perfil);
    }

    public ArrayList<ModelFichaControle> getListaFichaControleEditController(String perfil) {
        return this.daoFichaControle.getListaFichaControleEditDAO(perfil);
    }

    public boolean atualizarFichaControleController(ModelFichaControle pModelFichaControle) {
        return this.daoFichaControle.atualizarFichaControleDAO(pModelFichaControle);
    }

    public boolean excluirFichaControleController(int pCodigo) {
        return this.daoFichaControle.excluirFichaControleDAO(pCodigo);
    }

    public boolean updateStatusFichaControleController(String perfilupdat, String pendencia, String responsavel) {
        return this.daoFichaControle.updatStatus(perfilupdat, pendencia, responsavel);
    }


    public boolean updatecopiaStatusFichaControleController(ModelFichaControle pModelFichaControle, String perfilupdat) {
        return this.daoFichaControle.updatecopiaStatus(pModelFichaControle, perfilupdat);
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoController() {
        return this.daoFichaControle.getListaFichaemAbertoDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoAlterController() {
        return this.daoFichaControle.getListaFichaemAbertoAlterDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoCopiaController() {
        return this.daoFichaControle.getListaFichaemAbertoCopiaDAO();
    }

    public ModelFichaControle getFichaController(int pPerfilaberto) {
        return this.daoFichaControle.getFichaDAO(pPerfilaberto);
    }

    public boolean updateStatusAlterarFichaControleController(ModelFichaControle pModelFichaControle, String perfilupdat) {
        return this.daoFichaControle.updatStatusAlterar(pModelFichaControle, perfilupdat);
    }

    public ArrayList<ModelFichaControle> getListaFichaValidacaoController() {
        return this.daoFichaControle.getListaFichaValidacaoDAO();
    }

    public ArrayList<ModelFichaControle> getListaFichaControleComboController() {
        return this.daoFichaControle.getListaFichaControleComboDAO();
    }
}
