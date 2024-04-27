package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAODdzControle;
import com.cooperstandard.model.ModelDdzControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerDdzControle {

    private DAODdzControle daoDdzControle = new DAODdzControle();

    public int salvarDdzControleController(ModelDdzControle pModelDdzControle) {
        return this.daoDdzControle.salvarDdzControleDAO(pModelDdzControle);
    }

    public ModelDdzControle getDdzControleController(int pCodigo) {
        return this.daoDdzControle.getDdzControleDAO(pCodigo);
    }

    public ModelDdzControle getDdzControleController(String pNome) {
        return this.daoDdzControle.getDdzControleDAO(pNome);
    }

    public ArrayList<ModelDdzControle> getListaDdzControleController(String linha) {
        return this.daoDdzControle.getListaDdzControleDAO(linha);
    }

    public ArrayList<ModelDdzControle> getListaDdzControleAlterController(String perfil) {
        return this.daoDdzControle.getListaDdzControleAlterDAO(perfil);
    }

    public ArrayList<ModelDdzControle> getListaDdzATBControleController() {
        return this.daoDdzControle.getListaDdzATBControleDAO();
    }

    public boolean atualizarDdzControleController(ModelDdzControle pModelDdzControle, long id) {
        return this.daoDdzControle.atualizarDdzControleDAO(pModelDdzControle, id);
    }

    public boolean excluirDdzControleController(int pCodigo) {
        return this.daoDdzControle.excluirDdzControleDAO(pCodigo);
    }
}
