package com.cooperstandard.controller.pontoinsp;

import com.cooperstandard.controller.extrusao.*;
import com.cooperstandard.dao.pontoinsp.DAOInspControle;
import com.cooperstandard.model.ModelInspControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerInspControle {

    private DAOInspControle daoInspControle = new DAOInspControle();

    public int salvarInspControleController(ModelInspControle pModelInspControle) {
        return this.daoInspControle.salvarInspControleDAO(pModelInspControle);
    }

    public ModelInspControle getInspControleController(int pCodigo) {
        return this.daoInspControle.getInspControleDAO(pCodigo);
    }

    public ModelInspControle getInspControleController(String pNome) {
        return this.daoInspControle.getInspControleDAO(pNome);
    }

    public ArrayList<ModelInspControle> getListaInspControleController() {
        return this.daoInspControle.getListaInspControleDAO();
    }

    public ArrayList<ModelInspControle> getListaInspControleController(String linha) {
        return this.daoInspControle.getListaInspControleDAO(linha);
    }

    public ArrayList<ModelInspControle> getListaInspControleCloseController(String linha) {
        return this.daoInspControle.getListaInspControleCloseDAO(linha);
    }

    public boolean atualizarInspControleController(ModelInspControle pModelInspControle, long id) {
        return this.daoInspControle.atualizarInspControleDAO(pModelInspControle, id);
    }

    public boolean excluirInspControleController(int pCodigo) {
        return this.daoInspControle.excluirInspControleDAO(pCodigo);
    }
}
