package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOLinha;
import com.cooperstandard.model.ModelLinha;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerLinha {

    private final DAOLinha daoLinha = new DAOLinha();

    public int salvarLinhaController(ModelLinha pModelLinha) {
        return this.daoLinha.salvarLinhaDAO(pModelLinha);
    }

    public ModelLinha getLinhaController(int pCodigo) {
        return this.daoLinha.getLinhaDAO(pCodigo);
    }

    public ModelLinha getLinhaController(String pNome) {
        return this.daoLinha.getLinhaDAO(pNome);
    }

    public ArrayList<ModelLinha> getListaLinhaController() {
        return this.daoLinha.getListaLinhaDAO();
    }

    public ArrayList<ModelLinha> getListaLinhaGeralController() {
        return this.daoLinha.getListaLinhaGeralDAO();
    }

    public ArrayList<ModelLinha> getListaLinhaATBDDZController() {
        return this.daoLinha.getListaLinhaATBDDZDAO();
    }

    public ArrayList<ModelLinha> getListaLinhaDDZController() {
        return this.daoLinha.getListaLinhaDDZDAO();
    }

    public boolean atualizarLinhaController(ModelLinha pModelLinha) {
        return this.daoLinha.atualizarLinhaDAO(pModelLinha);
    }

    public boolean excluirLinhaController(long pCodigo) {
        return this.daoLinha.excluirLinhaDAO(pCodigo);
    }
}
