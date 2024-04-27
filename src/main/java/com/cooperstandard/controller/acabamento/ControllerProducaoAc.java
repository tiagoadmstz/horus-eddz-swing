/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;

import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.dao.acabamento.DAOProducaoAc;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerProducaoAc {

    private DAOProducaoAc daoProducao = new DAOProducaoAc();

    public ArrayList<ModelProducao> getListaProducaoAcController() {
        return this.daoProducao.getListaProducaoAcDAO();
    }

    public ArrayList<ModelProducao> getListaLinhaAcController() {
        return this.daoProducao.getListaLinhaAcDAO();
    }

    public ArrayList<ModelProducao> getListaPerfilAcController() {
        return this.daoProducao.getListaPerfilAcDAO();
    }

    public ArrayList<ModelProducao> getListaProducaoAcController(String perfil) {
        return this.daoProducao.getListaProducaoAcDAO(perfil);
    }
}
