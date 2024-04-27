package com.cooperstandard.controller.extrusao;

import com.cooperstandard.model.ModelPermissaousuario;
import com.cooperstandard.dao.extrusao.DAOPermissaousuario;
import java.util.ArrayList;

/**
*
* @author Rafael
*/
public class ControllerPermissaousuario {

    private DAOPermissaousuario daoPermissaousuario = new DAOPermissaousuario();

    public int salvarPermissaousuarioController(ModelPermissaousuario pModelPermissaousuario){
        return this.daoPermissaousuario.salvarPermissaousuarioDAO(pModelPermissaousuario);
    }

    public boolean excluirPermissaousuarioController(int pCodigo){
        return this.daoPermissaousuario.excluirPermissaousuarioDAO(pCodigo);
    }

    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.getListaPermissaousuarioDAO(pCodigo);
    }
}