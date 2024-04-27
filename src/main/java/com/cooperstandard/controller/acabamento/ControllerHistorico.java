/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelHistorico;
import com.cooperstandard.dao.acabamento.DAOHistorico;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rsouza10
 */
public class ControllerHistorico {

    private DAOHistorico daoHistorico = new DAOHistorico();

    public ArrayList<ModelHistorico> getListaHistoricoAcController() {
        return this.daoHistorico.getListaHistoricoAcDAO();
    }

    public ArrayList<ModelHistorico> getLista2HistoricoAcController() {
        return this.daoHistorico.getLista2HistoricoAcDAO();
    }

    public ArrayList<ModelHistorico> getListaMaterialHistoAcController() {
        return this.daoHistorico.getListaMaterialHistoAcDAO();
    }

    public ArrayList<ModelHistorico> getListaLinhaHistoAcController() {
        return this.daoHistorico.getListaLinhaHistoAcDAO();
    }

    public ModelHistorico getHistoricoAcController(Time pHora) {
        return this.daoHistorico.getHistoricoAcDAO(pHora);
    }

    public ArrayList<ModelHistorico> getListaVersaoMaterialHistoAcController(String perfil, String data, String hora) {
        return this.daoHistorico.getListaVersaoAcDAO(perfil, data, hora);
    }
}
