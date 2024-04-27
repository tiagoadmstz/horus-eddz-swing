/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelComposto;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOComposto extends ConexaoSql {

    public int salvarCompostoDAO(ModelComposto ModelComposto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Composto ("
                    + "COMPOSTO,"
                    + "BPCS,"
                    + "DESC_COMPOSTO"
                    + ") VALUES ("
                    + "'" + ModelComposto.getComposto() + "',"
                    + "'" + ModelComposto.getBpcs() + "',"
                    + "'" + ModelComposto.getDesc_composto() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelComposto getCompostoDAO(int pCodigo) {
        ModelComposto modelComposto = new ModelComposto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_COMPOSTO,"
                    + "COMPOSTO,"
                    + "BPCS,"
                    + "DESC_COMPOSTO "
                    + "FROM "
                    + "Cad_Composto"
                    + " WHERE"
                    + " ID_COMPOSTO= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelComposto.setId(this.getResultSet().getInt(1));
                modelComposto.setComposto(this.getResultSet().getInt(2));
                modelComposto.setBpcs(this.getResultSet().getString(3));
                modelComposto.setDesc_composto(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelComposto;
    }

    public ModelComposto getCompostoDAO(Integer pNome) {
        ModelComposto modelComposto = new ModelComposto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_COMPOSTO,"
                    + "COMPOSTO,"
                    + "BPCS,"
                    + "DESC_COMPOSTO "
                    + "FROM "
                    + "Cad_Composto"
                    + " WHERE"
                    + " COMPOSTO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelComposto.setId(this.getResultSet().getInt(1));
                modelComposto.setComposto(this.getResultSet().getInt(2));
                modelComposto.setBpcs(this.getResultSet().getString(3));
                modelComposto.setDesc_composto(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelComposto;
    }

    public ArrayList<ModelComposto> getListaCompostoDAO() {
        ArrayList<ModelComposto> listaComposto = new ArrayList();
        ModelComposto modelComposto = new ModelComposto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_COMPOSTO,"
                    + "COMPOSTO,"
                    + "BPCS,"
                    + "DESC_COMPOSTO"
                    + " FROM"
                    + " Cad_Composto ORDER BY COMPOSTO"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelComposto = new ModelComposto();
                modelComposto.setId(this.getResultSet().getInt(1));
                modelComposto.setComposto(this.getResultSet().getInt(2));
                modelComposto.setBpcs(this.getResultSet().getString(3));
                modelComposto.setDesc_composto(this.getResultSet().getString(4));

                listaComposto.add(modelComposto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaComposto;
    }

    public boolean atualizarCompostoDAO(ModelComposto pModelComposto) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Composto SET "
                    + " COMPOSTO= '" + pModelComposto.getComposto() + "',"
                    + " BPCS= '" + pModelComposto.getBpcs() + "',"
                    + " DESC_COMPOSTO= '" + pModelComposto.getDesc_composto() + "'"
                    + " WHERE "
                    + "ID_COMPOSTO = '" + pModelComposto.getId() + "'"
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

    public boolean excluirCompostoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Composto "
                    + "WHERE "
                    + "ID_COMPOSTO = '" + pCodigo + "'"
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
