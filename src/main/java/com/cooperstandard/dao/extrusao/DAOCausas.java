package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelCausas;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOCausas extends ConexaoSql {

    public int salvarCausasDAO(ModelCausas pModelModelCausas) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Causas ("
                    + "ID_PROBLEMA_ID,"
                    + "DESC_CAUSA"
                    + ") VALUES ("
                    + "'" + pModelModelCausas.getId_problema() + "',"
                    + "'" + pModelModelCausas.getDesc_causa() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelCausas getCausasDAO(long pCodigo) {
        ModelCausas modelCausas = new ModelCausas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "causas.ID,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = ID_PROBLEMA_ID"
                    + " WHERE causas.ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelCausas.setId(this.getResultSet().getInt(1));
                modelCausas.setDesc_problema(this.getResultSet().getString(2));
                modelCausas.setDesc_causa(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCausas;
    }

    public ModelCausas getCausasDAO(String pNome) {
        ModelCausas modelCausas = new ModelCausas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "causas.ID,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = ID_PROBLEMA_ID"
                    + " WHERE DESC_CAUSA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelCausas.setId(this.getResultSet().getInt(1));
                modelCausas.setDesc_problema(this.getResultSet().getString(2));
                modelCausas.setDesc_causa(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCausas;
    }

    public ArrayList<ModelCausas> getListaCausasDAO() {
        ArrayList<ModelCausas> listaCausas = new ArrayList();
        ModelCausas modelCausas = new ModelCausas();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "causas.ID,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = ID_PROBLEMA_ID"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCausas = new ModelCausas();
                modelCausas.setId(this.getResultSet().getInt(1));
                modelCausas.setDesc_problema(this.getResultSet().getString(2));
                modelCausas.setDesc_causa(this.getResultSet().getString(3));

                listaCausas.add(modelCausas);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaCausas;
    }

    public boolean atualizarCausasDAO(ModelCausas pModelCausas) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Causas SET "
                    + " ID_PROBLEMA_ID= '" + pModelCausas.getId_problema() + "',"
                    + " DESC_CAUSA= '" + pModelCausas.getDesc_causa() + "'"
                    + " WHERE "
                    + " ID= '" + pModelCausas.getId() + "'"
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

    public boolean excluirCausasDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Causas "
                    + "WHERE "
                    + " ID= '" + pCodigo + "'"
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
