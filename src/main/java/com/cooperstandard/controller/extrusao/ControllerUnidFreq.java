/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOUnidFreq;
import com.cooperstandard.model.ModelUnidFreq;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerUnidFreq {

    private DAOUnidFreq daoUnidFreq = new DAOUnidFreq();

    public int salvarUnidFreqController(ModelUnidFreq pModelUnidFreq) {
        return this.daoUnidFreq.salvarUnidFreqDAO(pModelUnidFreq);
    }

    public ModelUnidFreq getUnidFreqController(int pCodigo) {
        return this.daoUnidFreq.getUnidFreqDAO(pCodigo);
    }

    public ModelUnidFreq getUnidFreqController(String pNome) {
        return this.daoUnidFreq.getUnidFreqDAO(pNome);
    }

    public ArrayList<ModelUnidFreq> getListaUnidFreqController() {
        return this.daoUnidFreq.getListaUnidFreqDAO();
    }

    public boolean atualizarUnidFreqController(ModelUnidFreq pModelUnidFreq) {
        return this.daoUnidFreq.atualizarUnidFreqDAO(pModelUnidFreq);
    }

    public boolean excluirUnidFreqController(int pCodigo) {
        return this.daoUnidFreq.excluirUnidFreqDAO(pCodigo);
    }
}
