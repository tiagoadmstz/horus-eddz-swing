package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOProblema;
import com.cooperstandard.model.ModelProblema;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerProblema {

    private final DAOProblema daoProblemas = new DAOProblema();

    public int salvarProblemasController(ModelProblema pModelProblemas) {
        return this.daoProblemas.salvarProblemasDAO(pModelProblemas);
    }

    public ModelProblema getProblemasController(int pCodigo) {
        return this.daoProblemas.getProblemasDAO(pCodigo);
    }

    public ModelProblema getProblemasController(String pNome) {
        return this.daoProblemas.getProblemasDAO(pNome);
    }

    public ArrayList<ModelProblema> getListaProblemasController() {
        return this.daoProblemas.getListaProblemasDAO();
    }

    public boolean atualizarProblemasController(ModelProblema pModelProblemas) {
        return this.daoProblemas.atualizarProblemasDAO(pModelProblemas);
    }

    public boolean excluirProblemasController(long pCodigo) {
        return this.daoProblemas.excluirProblemasDAO(pCodigo);
    }
}
