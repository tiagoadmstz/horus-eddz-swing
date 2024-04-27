/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelUnidFreq;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOUnidFreq extends ConexaoSql {

    public int salvarUnidFreqDAO(ModelUnidFreq pModelUnidFreq) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_UnidadeFQ ("
                    + "UNIDADE_FREQUENCIA,"
                    + "SETOR"
                    + ") VALUES ("
                    + "'" + pModelUnidFreq.getUnidade_frequencia() + "',"
                    + "'" + pModelUnidFreq.getSetor() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelUnidFreq getUnidFreqDAO(int pCodigo) {
        ModelUnidFreq modelUnidFreq = new ModelUnidFreq();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_FREQUENCIA,"
                    + "UNIDADE_FREQUENCIA "
                    + "FROM "
                    + "Cad_UnidadeFQ"
                    + " WHERE"
                    + " ID_UNIDADE_FREQUENCIA= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelUnidFreq.setId(this.getResultSet().getInt(1));
                modelUnidFreq.setUnidade_frequencia(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidFreq;
    }

    public ModelUnidFreq getUnidFreqDAO(String pNome) {
        ModelUnidFreq modelUnidFreq = new ModelUnidFreq();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_FREQUENCIA,"
                    + "UNIDADE_FREQUENCIA "
                    + "FROM"
                    + "Cad_UnidadeFQ"
                    + " WHERE"
                    + " UNIDADE_FREQUENCIA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelUnidFreq.setId(this.getResultSet().getInt(1));
                modelUnidFreq.setUnidade_frequencia(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUnidFreq;
    }

    public ArrayList<ModelUnidFreq> getListaUnidFreqDAO() {
        ArrayList<ModelUnidFreq> listaUnidFreq = new ArrayList();
        ModelUnidFreq modelUnidFreq = new ModelUnidFreq();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_UNIDADE_FREQUENCIA,"
                    + "UNIDADE_FREQUENCIA"
                    + " FROM"
                    + " Cad_UnidadeFQ where SETOR = 'Extrusão' ORDER BY UNIDADE_FREQUENCIA"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUnidFreq = new ModelUnidFreq();
                modelUnidFreq.setId(this.getResultSet().getInt(1));
                modelUnidFreq.setUnidade_frequencia(this.getResultSet().getString(2));
                listaUnidFreq.add(modelUnidFreq);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaUnidFreq;
    }

    public boolean atualizarUnidFreqDAO(ModelUnidFreq pModelUnidFreq) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_UnidadeFQ SET "
                    + " UNIDADE_FREQUENCIA= '" + pModelUnidFreq.getUnidade_frequencia() + "'"
                    + " WHERE "
                    + " ID_UNIDADE_FREQUENCIA= '" + pModelUnidFreq.getId() + "'"
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

    public boolean excluirUnidFreqDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_UnidadeFQ "
                    + "WHERE "
                    + " ID_UNIDADE_FREQUENCIA= '" + pCodigo + "'"
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
