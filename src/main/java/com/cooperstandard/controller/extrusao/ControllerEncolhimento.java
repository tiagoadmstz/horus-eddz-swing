package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOEncolhimento;
import com.cooperstandard.model.ModelEncolhimento;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerEncolhimento {

    private DAOEncolhimento daoEncolhimento = new DAOEncolhimento();

    public int salvarEncolhimentoController(ModelEncolhimento pModelEncolhimento) {
        return this.daoEncolhimento.salvarEncolhimentoDAO(pModelEncolhimento);
    }

    public ModelEncolhimento getEncolhimentoController(int pCodigo) {
        return this.daoEncolhimento.getEncolhimentoDAO(pCodigo);
    }

    public ArrayList<ModelEncolhimento> getListaEncolhimentoController(int cod_perfil, String velocidade) {
        return this.daoEncolhimento.getListaEncolhimentoDAO(cod_perfil, velocidade);
    }

    public boolean atualizarEncolhimentoController(ModelEncolhimento pModelEncolhimento) {
        return this.daoEncolhimento.atualizarEncolhimentoDAO(pModelEncolhimento);
    }

    public boolean excluirEncolhimentoController(int pCodigo) {
        return this.daoEncolhimento.excluirEncolhimentoDAO(pCodigo);
    }
}
