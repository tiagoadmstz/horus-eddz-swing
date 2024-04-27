package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOCausas;
import com.cooperstandard.model.ModelCausas;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerCausas {

    private final DAOCausas daoCausas = new DAOCausas();

    public int salvarCausasController(ModelCausas pModelCausas) {
        return this.daoCausas.salvarCausasDAO(pModelCausas);
    }

    public ModelCausas getCausasController(long pCodigo) {
        return this.daoCausas.getCausasDAO(pCodigo);
    }

    public ModelCausas getCausasController(String pNome) {
        return this.daoCausas.getCausasDAO(pNome);
    }

    public ArrayList<ModelCausas> getListaCausasController() {
        return this.daoCausas.getListaCausasDAO();
    }

    public boolean atualizarCausasController(ModelCausas pModelCausas) {
        return this.daoCausas.atualizarCausasDAO(pModelCausas);
    }

    public boolean excluirCausasController(long pCodigo) {
        return this.daoCausas.excluirCausasDAO(pCodigo);
    }
}
