/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOMontadora;
import com.cooperstandard.model.ModelMontadora;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class ControllerMontadora {
    
    private DAOMontadora daoMontadora = new DAOMontadora();
    
    public int salvarMontadoraController(ModelMontadora pModelMontadora) {
        return this.daoMontadora.salvarMontadoraDAO(pModelMontadora);
    }

    public ModelMontadora getMontadoraController(int pCodigo) {
        return this.daoMontadora.getMontadoraDAO(pCodigo);
    }

    public ModelMontadora getMontadoraController(String pNome) {
        return this.daoMontadora.getMontadoraDAO(pNome);
    }

    public ArrayList<ModelMontadora> getListaMontadoraController() {
        return this.daoMontadora.getListaMontadoraDAO();
    }

    public boolean atualizarMontadoraController(ModelMontadora pModelMontadora) {
        return this.daoMontadora.atualizarMontadoraDAO(pModelMontadora);
    }

    public boolean excluirMontadoraController(int pCodigo) {
        return this.daoMontadora.excluirMontadoraDAO(pCodigo);
    }
}
