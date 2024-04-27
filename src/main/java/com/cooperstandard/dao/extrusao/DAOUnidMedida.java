/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelUnidMedida;

import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOUnidMedida extends ConexaoSql {

    public int salvarUnidMedidaDAO(ModelUnidMedida pModelUnidMedida) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Unidade ("
                    + "UNIDADE_MEDIDA,"
                    + "SETOR"
                    + ") VALUES ("
                    + "'" + pModelUnidMedida.getUnidade_medida() + "',"
                    + "'" + pModelUnidMedida.getSetor() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelUnidMedida getUnidMedidaDAO(int pCodigo) {
        ModelUnidMedida modelUnidMedida = new ModelUnidMedida();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_MEDIDA,"
                    + "UNIDADE_MEDIDA"
                    + " FROM "
                    + "Cad_Unidade"
                    + " WHERE"
                    + " ID_UNIDADE_MEDIDA= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelUnidMedida.setId(this.getResultSet().getInt(1));
                modelUnidMedida.setUnidade_medida(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidMedida;
    }

    public ModelUnidMedida getUnidMedidaDAO(String pNome) {
        ModelUnidMedida modelUnidMedida = new ModelUnidMedida();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_MEDIDA,"
                    + "UNIDADE_MEDIDA "
                    + "FROM"
                    + "Cad_Unidade"
                    + " WHERE"
                    + " UNIDADE_MEDIDA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelUnidMedida.setId(this.getResultSet().getInt(1));
                modelUnidMedida.setUnidade_medida(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidMedida;
    }

    public ArrayList<ModelUnidMedida> getListaUnidMedidaDAO() {
        ArrayList<ModelUnidMedida> listaUnidMedida = new ArrayList();
        ModelUnidMedida modelUnidMedida = new ModelUnidMedida();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_MEDIDA,"
                    + "UNIDADE_MEDIDA"
                    + " FROM"
                    + " Cad_Unidade where SETOR = 'Extrusão' ORDER BY UNIDADE_MEDIDA"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUnidMedida = new ModelUnidMedida();
                modelUnidMedida.setId(this.getResultSet().getInt(1));
                modelUnidMedida.setUnidade_medida(this.getResultSet().getString(2));
                listaUnidMedida.add(modelUnidMedida);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaUnidMedida;
    }

    public boolean atualizarUnidMedidaDAO(ModelUnidMedida pModelUnidMedida) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Unidade SET "
                    + " UNIDADE_MEDIDA= '" + pModelUnidMedida.getUnidade_medida() + "'"
                    + " WHERE "
                    + " ID_UNIDADE_MEDIDA= '" + pModelUnidMedida.getId() + "'"
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

    public boolean excluirUnidMedidaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Unidade "
                    + "WHERE "
                    + " ID_UNIDADE_MEDIDA= '" + pCodigo + "'"
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
