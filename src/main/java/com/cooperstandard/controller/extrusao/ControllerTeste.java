package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOTeste;
import com.cooperstandard.model.ModelTeste;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerTeste {

    private DAOTeste daoTeste = new DAOTeste();

    public int salvarTesteController(ModelTeste pModelTeste) {
        return this.daoTeste.salvarTesteDAO(pModelTeste);
    }

    public ModelTeste getTesteController(int pCodigo) {
        return this.daoTeste.getTesteDAO(pCodigo);
    }

    public ModelTeste getTesteController(Integer pNome) {
        return this.daoTeste.getTesteDAO(pNome);
    }

    public ArrayList<ModelTeste> getListaTesteController() {
        return this.daoTeste.getListaTesteDAO();
    }

    public boolean atualizarTesteController(ModelTeste pModelTeste) {
        return this.daoTeste.atualizarTesteDAO(pModelTeste);
    }

    public boolean excluirTesteController(int pCodigo) {
        return this.daoTeste.excluirTesteDAO(pCodigo);
    }
}
