package com.cooperstandard.controller.extrusao;

import com.cooperstandard.dao.extrusao.DAOUsuario;
import com.cooperstandard.model.ModelUsuario;
import java.util.ArrayList;

/**
*
* @author Rafael
*/
public class ControllerUsuario {

    private DAOUsuario daoUsuario = new DAOUsuario();

    /**
    * grava Usuario
    * @param pModelUsuario
    * return int
    */
    public int salvarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera Usuario
    * @param pCodigo
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioController(int pCodigo){
        return this.daoUsuario.getUsuarioDAO(pCodigo);
    }
    
    /**
    * recupera Usuario
    * @param pLogin
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioController(String pLogin){
        return this.daoUsuario.getUsuarioDAO(pLogin);
    }
    
    /**
    * recupera Usuario
    * @param pModelUsuario
    * return ModelUsuario
    */
    public boolean getUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.getUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera uma lista deUsuario
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioController(){
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * return boolean
    */
    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
    * exclui Usuario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUsuarioController(int pCodigo){
        return this.daoUsuario.excluirUsuarioDAO(pCodigo);
    }
}