/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOUnidMedida;
import com.cooperstandard.model.ModelUnidMedida;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerUnidMedida {

    private DAOUnidMedida daoUnidMedida = new DAOUnidMedida();

    public int salvarUnidMedidaController(ModelUnidMedida pModelUnidMedida) {
        return this.daoUnidMedida.salvarUnidMedidaDAO(pModelUnidMedida);
    }

    public ModelUnidMedida getUnidMedidaController(int pCodigo) {
        return this.daoUnidMedida.getUnidMedidaDAO(pCodigo);
    }

    public ModelUnidMedida getUnidMedidaController(String pNome) {
        return this.daoUnidMedida.getUnidMedidaDAO(pNome);
    }

    public ArrayList<ModelUnidMedida> getListaUnidMedidaController() {
        return this.daoUnidMedida.getListaUnidMedidaDAO();
    }

    public boolean atualizarUnidMedidaController(ModelUnidMedida pModelUnidMedida) {
        return this.daoUnidMedida.atualizarUnidMedidaDAO(pModelUnidMedida);
    }

    public boolean excluirUnidMedidaController(int pCodigo) {
        return this.daoUnidMedida.excluirUnidMedidaDAO(pCodigo);
    }
}
