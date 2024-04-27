/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOHistorico;
import com.cooperstandard.model.ModelHistorico;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rsouza10
 */
public class ControllerHistorico {

    private DAOHistorico daoHistorico = new DAOHistorico();

    public ArrayList<ModelHistorico> getListaHistoricoController() {
        return this.daoHistorico.getListaHistoricoDAO();
    }

    public ArrayList<ModelHistorico> getLista2HistoricoController() {
        return this.daoHistorico.getLista2HistoricoDAO();
    }

    public ArrayList<ModelHistorico> getListaMaterialHistoController() {
        return this.daoHistorico.getListaMaterialHistoDAO();
    }

    public ArrayList<ModelHistorico> getListaLinhaHistoController() {
        return this.daoHistorico.getListaLinhaHistoDAO();
    }

    public ModelHistorico getHistoricoController(Time pHora) {
        return this.daoHistorico.getHistoricoDAO(pHora);
    }

    public ArrayList<ModelHistorico> getListaVersaoMaterialHistoController(String perfil, String data, String hora) {
        return this.daoHistorico.getListaVersaoDAO(perfil, data, hora);
    }
}
