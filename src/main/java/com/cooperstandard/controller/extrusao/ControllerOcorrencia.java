package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOOcorrencia;
import com.cooperstandard.model.ModelOcorrencia;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerOcorrencia {

    private DAOOcorrencia daoOcorrencia = new DAOOcorrencia();

    public int salvarOcorrenciaController(ModelOcorrencia pModelOcorrencia) {
        return this.daoOcorrencia.salvarOcorrenciaDAO(pModelOcorrencia);
    }

    public ModelOcorrencia getOcorrenciaController(long pCodigo) {
        return this.daoOcorrencia.getOcorrenciaDAO(pCodigo);
    }

    public ModelOcorrencia getOcorrenciaController(String pNome) {
        return this.daoOcorrencia.getOcorrenciaDAO(pNome);
    }

    public ArrayList<ModelOcorrencia> getListaOcorrenciaController() {
        return this.daoOcorrencia.getListaOcorrenciaDAO();
    }

    public boolean atualizarOcorrenciaController(ModelOcorrencia pModelOcorrencia) {
        return this.daoOcorrencia.atualizarOcorrenciaDAO(pModelOcorrencia);
    }

    public boolean excluirOcorrenciaController(long pCodigo) {
        return this.daoOcorrencia.excluirOcorrenciaDAO(pCodigo);
    }
}
