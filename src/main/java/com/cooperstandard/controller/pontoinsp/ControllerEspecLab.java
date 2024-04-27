package com.cooperstandard.controller.pontoinsp;

import com.cooperstandard.dao.pontoinsp.DAOEspecLab;
import com.cooperstandard.model.ModelEspecLab;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerEspecLab {

    private final DAOEspecLab daoEspecLab = new DAOEspecLab();

    public int salvarEspecLabController(ModelEspecLab pModelEspecLab) {
        return this.daoEspecLab.salvarEspecLabDAO(pModelEspecLab);
    }

    public ModelEspecLab getEspecLabController(int pCodigo) {

        return this.daoEspecLab.getEspecLabDAO(pCodigo);
    }

    public ModelEspecLab getEspecLabController(String pNome) {
        return this.daoEspecLab.getEspecLabDAO(pNome);
    }

    public ArrayList<ModelEspecLab> getListaEspecLabController(String perfil) {
        return this.daoEspecLab.getListaEspecLabDAO(perfil);
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDController(String id_controle) {
        return this.daoEspecLab.getListaEspecLabIDDAO(id_controle);
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDCompletoController(String id_controle) {
        return this.daoEspecLab.getListaEspecLabIDCompletoDAO(id_controle);
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDCompletoRetesteController(String id_controle) {
        return this.daoEspecLab.getListaEspecLabIDCompletoRetesteDAO(id_controle);
    }

    public boolean atualizarEspecLabController(ModelEspecLab pModelEspecLab) {
        return this.daoEspecLab.atualizarEspecLabDAO(pModelEspecLab);
    }

    public boolean excluirEspecLabController(int pCodigo) {
        return this.daoEspecLab.excluirEspecLabDAO(pCodigo);
    }
}
