/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAORodapePlano;
import com.cooperstandard.model.ModelRodapePlano;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerRodapePlano {

    private DAORodapePlano daoRodapePlano = new DAORodapePlano();

    public int salvarRodapePlanoController(ModelRodapePlano pModelRodapePlano) {
        return this.daoRodapePlano.salvarRodapePlanoDAO(pModelRodapePlano);
    }

    public ModelRodapePlano getRodapePlanoController(int pCodigo) {
        return this.daoRodapePlano.getRodapePlanoDAO(pCodigo);
    }

    public ModelRodapePlano getRodapePlanoController(String pNome) {
        return this.daoRodapePlano.getRodapePlanoDAO(pNome);
    }

    public ArrayList<ModelRodapePlano> getListaRodapePlanoController(String perfil) {
        return this.daoRodapePlano.getListaRodapePlanoDAO(perfil);
    }

    public boolean atualizarRodapePlanoController(ModelRodapePlano pModelRodapePlano) {
        return this.daoRodapePlano.atualizarRodapePlanoDAO(pModelRodapePlano);
    }

    public boolean excluirRodapePlanoController(int pCodigo) {
        return this.daoRodapePlano.excluirRodapePlanoDAO(pCodigo);
    }
}
