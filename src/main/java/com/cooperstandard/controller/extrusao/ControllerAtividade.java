package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOAtividade;
import com.cooperstandard.model.ModelAtividade;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerAtividade {

    private final DAOAtividade daoAtividade = new DAOAtividade();

    public int salvarAtividadeController(ModelAtividade pModelAtividade) {
        return this.daoAtividade.salvarAtividadeDAO(pModelAtividade);
    }

    public ModelAtividade getAtividadeController(long pCodigo) {
        return this.daoAtividade.getAtividadeDAO(pCodigo);
    }

    public ModelAtividade getAtividadeController(String pNome) {
        return this.daoAtividade.getAtividadeDAO(pNome);
    }

    public ArrayList<ModelAtividade> getListaAtividadeController() {
        return this.daoAtividade.getListaAtividadeDAO();
    }

    public boolean atualizarAtividadeController(ModelAtividade pModelAtividade) {
        return this.daoAtividade.atualizarAtividadeDAO(pModelAtividade);
    }

    public boolean excluirAtividadeController(long pCodigo) {
        return this.daoAtividade.excluirAtividadeDAO(pCodigo);
    }
}
