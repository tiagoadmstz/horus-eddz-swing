package com.cooperstandard.controller.pontoinsp;

import com.cooperstandard.dao.pontoinsp.DAOResultInsp;
import com.cooperstandard.model.ModelResultInsp;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerResultInsp {

    private DAOResultInsp daoResultInsp = new DAOResultInsp();

    public int salvarResultInspController(ModelResultInsp pModelResultInsp) {
        return this.daoResultInsp.salvarResultInspDAO(pModelResultInsp);
    }

    public ModelResultInsp getResultInspController(int pCodigo) {
        return this.daoResultInsp.getResultInspDAO(pCodigo);
    }

    public ModelResultInsp getResultInspController(Integer pNome) {
        return this.daoResultInsp.getResultInspDAO(pNome);
    }

    public ArrayList<ModelResultInsp> getListaResultInspController() {
        return this.daoResultInsp.getListaResultInspDAO();
    }

    public ArrayList<ModelResultInsp> getListaStatusResultInspController() {
        return this.daoResultInsp.getListaStatusResultInspDAO();
    }

    public ArrayList<ModelResultInsp> getListaEmAbertoController() {
        return this.daoResultInsp.getListaEmAbertoDAO();
    }

    public boolean updateResultadoInspController(ModelResultInsp pModelResultInsp) {
        return this.daoResultInsp.updateResultadoInspDAO(pModelResultInsp);
    }

    public boolean atualizarResultInspController(ModelResultInsp pModelResultInsp) {
        return this.daoResultInsp.atualizarResultInspDAO(pModelResultInsp);
    }

    public boolean atualizarResultLabController(ModelResultInsp pModelResultInsp) {
        return this.daoResultInsp.atualizarResultLabDAO(pModelResultInsp);
    }

    public ArrayList<ModelResultInsp> getUltimoRegistroDataController(String dataini, String datafim) {
        return this.daoResultInsp.getListaUltimoRegistroDataDAO(dataini, datafim);

    }

    public ArrayList<ModelResultInsp> getResultadoLabController(String perfil, String dataini, String datafim) {
        return this.daoResultInsp.getListaResultadoLabDAO(perfil, dataini, datafim);

    }

    public ArrayList<ModelResultInsp> getResultadoLabDataController(String dataini, String datafim) {
        return this.daoResultInsp.getListaResultadoInspDataDAO(dataini, datafim);

    }

    public ArrayList<ModelResultInsp> getUltimoRegistroController() {
        return this.daoResultInsp.getListaUltimoRegistroDAO();

    }

    public ArrayList<ModelResultInsp> getUltimoRegistroRetesteController() {
        return this.daoResultInsp.getListaUltimoRegistroRetesteDAO();

    }

    public boolean excluirResultInspController(int pCodigo) {
        return this.daoResultInsp.excluirResultInspDAO(pCodigo);
    }
}
