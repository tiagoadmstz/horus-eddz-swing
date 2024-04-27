package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOVelocidade;
import com.cooperstandard.model.ModelVelocidade;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerVelocidade {

    private final DAOVelocidade daoVelocidade = new DAOVelocidade();

    public int salvarVelocidadeController(ModelVelocidade pModelVelocidade) {
        return this.daoVelocidade.salvarVelocidadeDAO(pModelVelocidade);
    }

    public ModelVelocidade getVelocidadeController(long pCodigo) {
        return this.daoVelocidade.getVelocidadeDAO(pCodigo);
    }

    public ArrayList<ModelVelocidade> getListaVelocidadePerfilController() {
        return this.daoVelocidade.getListaVelocidadeDAO();
    }

    public ArrayList<ModelVelocidade> getListaVelocidadePerfilController(int cod_perfil) {
        return this.daoVelocidade.getListaVelocidadePerfilDAO(cod_perfil);
    }

    public ArrayList<ModelVelocidade> getListaVelocidadeLinhaController(String linha) {
        return this.daoVelocidade.getListaVelocidadeLinhaDAO(linha);
    }

    public boolean atualizarVelocidadeController(ModelVelocidade pModelVelocidade) {
        return this.daoVelocidade.atualizarVelocidadeDAO(pModelVelocidade);
    }

    public boolean excluirVelocidadeController(int pCodigo) {
        return this.daoVelocidade.excluirVelocidadeDAO(pCodigo);
    }
}
