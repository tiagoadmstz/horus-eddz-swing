package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOResultado;
import com.cooperstandard.model.ModelResultado;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerResultado {

    private DAOResultado daoResultado = new DAOResultado();

    public int salvarResultadoController(ModelResultado pModelResultado) {
        return this.daoResultado.salvarResultadoDAO(pModelResultado);
    }

    public ModelResultado getResultadoController(int pCodigo) {
        return this.daoResultado.getResultadoDAO(pCodigo);
    }

    public ModelResultado getResultadoController(Integer pNome) {
        return this.daoResultado.getResultadoDAO(pNome);
    }

    public ArrayList<ModelResultado> getListaResultadoController(String perfil) {
        return this.daoResultado.getListaResultadoDAO(perfil);
    }
    
        public ArrayList<ModelResultado> getListaDigitadooController() {
        return this.daoResultado.getListaDigitadoDAO();
    }

    public boolean atualizarResultadoController(ModelResultado pModelResultado) {
        return this.daoResultado.atualizarResultadoDAO(pModelResultado);
    }

    public boolean excluirResultadoController(int pCodigo) {
        return this.daoResultado.excluirResultadoDAO(pCodigo);
    }
}
