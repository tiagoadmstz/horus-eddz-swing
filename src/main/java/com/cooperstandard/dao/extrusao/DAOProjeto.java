/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelProjeto;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOProjeto extends ConexaoSql {

    public int salvarProjetoDAO(ModelProjeto pModelProjeto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Projeto ("
                    + "PROJETO,"
                    + "PRO_OEM"
                    + ") VALUES ("
                    + "'" + pModelProjeto.getProjeto() + "',"
                    + "'" + pModelProjeto.getPro_oem() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelProjeto getProjetoDAO(int pCodigo) {
        ModelProjeto modelProjeto = new ModelProjeto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_PROJETO,"
                    + "PROJETO,"
                    + "PRO_OEM "
                    + "FROM "
                    + "Cad_Projeto"
                    + " WHERE"
                    + " ID_PROJETO= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelProjeto.setId_projeto(this.getResultSet().getInt(1));
                modelProjeto.setProjeto(this.getResultSet().getString(2));
                modelProjeto.setPro_oem(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProjeto;
    }

    public ModelProjeto getProjetoDAO(String pNome) {
        ModelProjeto modelProjeto = new ModelProjeto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_PROJETO,"
                    + "PROJETO,"
                    + "PRO_OEM "
                    + "FROM "
                    + "Cad_Projeto"
                    + " WHERE"
                    + " PROJETO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelProjeto.setId_projeto(this.getResultSet().getInt(1));
                modelProjeto.setProjeto(this.getResultSet().getString(2));
                modelProjeto.setPro_oem(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProjeto;
    }

    public ArrayList<ModelProjeto> getListaProjetoDAO() {
        ArrayList<ModelProjeto> listaProjeto = new ArrayList();
        ModelProjeto modelProjeto = new ModelProjeto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_PROJETO,"
                    + "PRO_OEM,"
                    + "PROJETO"
                    + " FROM"
                    + " Cad_Projeto ORDER BY ID_PROJETO"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProjeto = new ModelProjeto();
                modelProjeto.setId_projeto(this.getResultSet().getInt(1));
                modelProjeto.setPro_oem(this.getResultSet().getString(2));
                modelProjeto.setProjeto(this.getResultSet().getString(3));

                listaProjeto.add(modelProjeto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProjeto;
    }

    public boolean atualizarProjetoDAO(ModelProjeto pModelProjeto) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Projeto SET "
                    + "PROJETO = '" + pModelProjeto.getProjeto() + "',"
                    + "PRO_OEM = '" + pModelProjeto.getPro_oem() + "'"
                    + " WHERE "
                    + "ID_PROJETO = '" + pModelProjeto.getId_projeto() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();

        }

    }

    public boolean excluirProjetoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Projeto "
                    + "WHERE "
                    + "ID_PROJETO = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
