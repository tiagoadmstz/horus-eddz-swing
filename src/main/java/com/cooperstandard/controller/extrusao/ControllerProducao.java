/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOProducao;
import com.cooperstandard.model.ModelProducao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerProducao {

    private DAOProducao daoProducao = new DAOProducao();

    public ArrayList<ModelProducao> getListaProducaoController() {
        return this.daoProducao.getListaProducaoDAO();
    }

    public ArrayList<ModelProducao> getListaLinhaController() {
        return this.daoProducao.getListaLinhaDAO();
    }

    public ArrayList<ModelProducao> getListaPerfilController() {
        return this.daoProducao.getListaPerfilDAO();
    }

    public ArrayList<ModelProducao> getListaProducaoController(String perfil) {
        return this.daoProducao.getListaProducaoDAO(perfil);
    }

    public ArrayList<ModelProducao> getListaPreecheTabaleController(String perfil) {
        return this.daoProducao.getListaPreecheTabelaDAO(perfil);
    }

    public ArrayList<ModelProducao> getListaResultadoController(String perfil) {
        return this.daoProducao.getListaResultadoDAO(perfil);
    }

    public ArrayList<ModelProducao> getListaProducaoGeralController(String perfil) {
        return this.daoProducao.getListaProducaoGeralDAO(perfil);
    }
}
