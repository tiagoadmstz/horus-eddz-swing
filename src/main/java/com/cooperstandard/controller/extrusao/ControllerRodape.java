/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAORodape;
import com.cooperstandard.model.ModelRodape;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerRodape {

    private DAORodape daoRodape = new DAORodape();

    public int salvarRodapeController(ModelRodape pModelRodape) {
        return this.daoRodape.salvarRodapeDAO(pModelRodape);
    }

    public ModelRodape getRodapeController(int pCodigo) {
        return this.daoRodape.getRodapeDAO(pCodigo);
    }

    public ModelRodape getRodapeController(String pNome) {
        return this.daoRodape.getRodapeDAO(pNome);
    }

    public ArrayList<ModelRodape> getListaRodapeController(String perfil) {
        return this.daoRodape.getListaRodapeDAO(perfil);
    }

    public boolean atualizarRodapeController(ModelRodape pModelRodape) {
        return this.daoRodape.atualizarRodapeDAO(pModelRodape);
    }

    public boolean excluirRodapeController(int pCodigo) {
        return this.daoRodape.excluirRodapeDAO(pCodigo);
    }
}
