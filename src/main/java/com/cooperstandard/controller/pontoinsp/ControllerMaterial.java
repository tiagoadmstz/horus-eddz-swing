/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.pontoinsp;

import com.cooperstandard.controller.extrusao.*;
import com.cooperstandard.dao.extrusao.DAOMaterial;
import com.cooperstandard.model.ModelMaterial;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerMaterial {

    private DAOMaterial daoMaterial = new DAOMaterial();

    public int salvarMaterialController(ModelMaterial pModelMaterial) {
        return this.daoMaterial.salvarMaterialDAO(pModelMaterial);
    }

    public ModelMaterial getMaterialController(int pCodigo) {
        return this.daoMaterial.getMaterialDAO(pCodigo);
    }

    public ModelMaterial getMaterialController(Integer pNome) {
        return this.daoMaterial.getMaterialDAO(pNome);
    }

    public ArrayList<ModelMaterial> getListaMaterialController() {
        return this.daoMaterial.getListaMaterialDAO();
    }

    public boolean atualizarMaterialController(ModelMaterial pModelMaterial) {
        return this.daoMaterial.atualizarMaterialDAO(pModelMaterial);
    }

    public boolean excluirMaterialController(int pCodigo) {
        return this.daoMaterial.excluirMaterialDAO(pCodigo);
    }
}
