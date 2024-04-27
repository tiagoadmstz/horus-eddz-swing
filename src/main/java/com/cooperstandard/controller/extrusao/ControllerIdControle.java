package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOIdControle;
import com.cooperstandard.model.ModelIdControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerIdControle {

    private final DAOIdControle daoIdControle = new DAOIdControle();

    public int salvarIdControleController(ModelIdControle pModelIdControle) {
        return this.daoIdControle.salvarIdControleDAO(pModelIdControle);
    }

    public ModelIdControle getIdControleController(int pCodigo) {
        return this.daoIdControle.getIdControleDAO(pCodigo);
    }

    public ModelIdControle getIdControleController(String pNome) {
        return this.daoIdControle.getIdControleDAO(pNome);
    }

    public ArrayList<ModelIdControle> getListaIdControleController() {
        return this.daoIdControle.getListaIdControleDAO();
    }

    public ArrayList<ModelIdControle> getListaIdControleGeralController() {
        return this.daoIdControle.getListaIdControleDAO();
    }

    public boolean atualizarIdControleController(ModelIdControle pModelIdControle) {
        return this.daoIdControle.atualizarIdControleDAO(pModelIdControle);
    }

    public boolean excluirIdControleController(long pCodigo) {
        return this.daoIdControle.excluirIdControleDAO(pCodigo);
    }
}
