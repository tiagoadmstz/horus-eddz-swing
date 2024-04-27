package com.cooperstandard.dao.extrusao;

import java.util.ArrayList;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelPermissaousuario;
/**
*
* @author Rafael
*/
public class DAOPermissaousuario extends ConexaoSql {

    /**
    * grava Permissaousuario
    * @param pModelPermissaousuario
    * return int
    */
    public int salvarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario) {
        try {
            this.conectar();
            int sizeLista = pModelPermissaousuario.getListaModelPermissaousuarios().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO Cad_Usuario_Permissao ("
                        + "FK_ID_USUARIO, "
                        + " PERMISSAO "
                        + ") VALUES ("
                        + "'" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getCodigo_usuario() + "',"
                        + "'" + pModelPermissaousuario.getListaModelPermissaousuarios().get(i).getPermissao() + "'"
                        + ");"
                );
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
    * recupera Permissaousuario
    * @param pCodigo
    * return ModelPermissaousuario
    */
    public ModelPermissaousuario getPermissaousuarioDAO(int pCodigo){
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "PK_ID,"
                    + "FK_ID_USUARIO,"
                    + "PERMISSAO"
                 + " FROM"
                     + " Cad_Usuario_Permissao"
                 + " WHERE"
                     + " PK_ID = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }
    
    /**
    * recupera Permissaousuario pelo código do usuário
    * @param pCodigoUsuario
    * return ModelPermissaousuario
    */
    public ModelPermissaousuario getPermissaousuarioCodUsuDAO(int pCodigoUsuario){
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "PK_ID,"
                    + "FK_ID_USUARIO,"
                    + "PERMISSAO"
                 + " FROM"
                     + " Cad_Usuario_Permissao"
                 + " WHERE"
                     + " FK_ID_USUARIO = '" + pCodigoUsuario + "' and PERMISSAO = 'compras'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /**
    * recupera uma lista de Permissaousuario
        * return ArrayList
    */
    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO(){
        ArrayList<ModelPermissaousuario> listamodelPermissaousuario = new ArrayList();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "PK_ID,"
                    + "FK_ID_USUARIO,"
                    + "PERMISSAO"
                 + " FROM"
                     + " Cad_Usuario_Permissao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }

    /**
    * atualiza Permissaousuario
    * @param pModelPermissaousuario
    * return boolean
    */
    public boolean atualizarPermissaousuarioDAO(ModelPermissaousuario pModelPermissaousuario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE Cad_Usuario_Permissao SET "
                    + " PK_ID= '" + pModelPermissaousuario.getCodigo() + "',"
                    + " FK_ID_USUARIO= '" + pModelPermissaousuario.getCodigo_usuario() + "',"
                    + "PERMISSAO = '" + pModelPermissaousuario.getPermissao() + "'"
                + " WHERE "
                    + "PK_ID = '" + pModelPermissaousuario.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Permissaousuario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirPermissaousuarioDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM Cad_Usuario_Permissao "
                + " WHERE "
                    + "FK_ID_USUARIO = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioDAO(int pCodigo) {
        final ArrayList<ModelPermissaousuario> listamodelPermissaousuario = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "PK_ID,"
                    + "FK_ID_USUARIO,"
                    + "PERMISSAO"
                 + " FROM"
                     + " Cad_Usuario_Permissao WHERE FK_ID_USUARIO = '"+pCodigo+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                final ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }
}