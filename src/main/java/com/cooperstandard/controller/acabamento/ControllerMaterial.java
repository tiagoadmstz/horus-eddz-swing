/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.acabamento;


import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.dao.acabamento.DAOMaterial;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerMaterial {

    private DAOMaterial daoMaterial = new DAOMaterial();

    public int salvarMaterialAcController(ModelMaterial pModelMaterial) {
        return this.daoMaterial.salvarMaterialAcDAO(pModelMaterial);
    }

    public ModelMaterial getMaterialAcController(int pCodigo) {
        return this.daoMaterial.getMaterialAcDAO(pCodigo);
    }

    public ModelMaterial getMaterialAcController(Integer pNome) {
        return this.daoMaterial.getMaterialAcDAO(pNome);
    }

    public ArrayList<ModelMaterial> getListaMaterialAcController() {
        return this.daoMaterial.getListaMaterialAcDAO();
    }

    public boolean atualizarMaterialAcController(ModelMaterial pModelMaterial) {
        return this.daoMaterial.atualizarMaterialAcDAO(pModelMaterial);
    }

    public boolean excluirMaterialAcController(int pCodigo) {
        return this.daoMaterial.excluirMaterialAcDAO(pCodigo);
    }
}
