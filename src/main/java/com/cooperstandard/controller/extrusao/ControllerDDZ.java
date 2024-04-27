package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAODDZ;
import com.cooperstandard.model.ModelDDZ;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerDDZ {

    private final DAODDZ daoDDZ = new DAODDZ();

    public int salvarDDZController(ModelDDZ pModelDDZ) {
        return this.daoDDZ.salvarDDZDAO(pModelDDZ);
    }

    public ModelDDZ getDDZController(String perfil) {
        return this.daoDDZ.getDDZDAO(perfil);
    }

    public ModelDDZ getAcaoController(int id) {
        return this.daoDDZ.getAcaoDAO(id);
    }

    public ArrayList<ModelDDZ> getListaDDZController(String perfil) {
        return this.daoDDZ.getListaDDZDAO(perfil);
    }

    public ArrayList<ModelDDZ> getListaDDZEditController(String perfil, int idcontrole) {
        return this.daoDDZ.getListaDDZEditDAO(perfil, idcontrole);
    }

    public ArrayList<ModelDDZ> getListaAcaoDDZController(String perfil, double onehour, double fourhour) {
        return this.daoDDZ.getListaAcaoDDZDAO(perfil, onehour, fourhour);
    }

    public boolean atualizarDDZController(ModelDDZ pModelDDZ) {
        return this.daoDDZ.atualizarDDZDAO(pModelDDZ);
    }

    public ArrayList<ModelDDZ> getListaAcaoDDZController() {
        return this.daoDDZ.getListaAcaoDDZDAO();
    }

    public boolean atualizaAcaoController(ModelDDZ pModelDDZ) {
        return this.daoDDZ.atualizaAcaoDAO(pModelDDZ);
    }

    public boolean excluirDDZController(long pCodigo) {
        return this.daoDDZ.excluirDDZDAO(pCodigo);
    }
}
