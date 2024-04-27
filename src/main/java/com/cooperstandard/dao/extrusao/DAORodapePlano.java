/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelRodapePlano;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rsouza10
 */
public class DAORodapePlano extends ConexaoSql {

    public int salvarRodapePlanoDAO(ModelRodapePlano pModelRodapePlano) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_RodPlan ("
                    + "RODPLAN_LINHA,"
                    + "RODPLAN_DATA,"
                    + "RODPLAN_REV,"
                    + "RODPLAN_DESCRICAO,"
                    + "RODPLAN_EMITENTE,"
                    + "RODPLAN_SETOR,"
                    + "RODPLAN_RESPONSAVEL"
                    + ") VALUES ("
                    + "'" + pModelRodapePlano.getRodplan_linha() + "',"
                    + "'" + pModelRodapePlano.getRodplan_data() + "',"
                    + "'" + pModelRodapePlano.getRodplan_rev() + "',"
                    + "'" + pModelRodapePlano.getRodplan_descricao() + "',"
                    + "'" + pModelRodapePlano.getRodplan_emitente() + "',"
                    + "'" + pModelRodapePlano.getRodplan_setor() + "',"
                    + "'" + pModelRodapePlano.getRodplan_responsavel() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelRodapePlano getRodapePlanoDAO(int pCodigo) {
        ModelRodapePlano modelRodapePlano = new ModelRodapePlano();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "RODPLAN_LINHA,"
                    + "RODPLAN_DATA,"
                    + "RODPLAN_REV,"
                    + "RODPLAN_DESCRICAO,"
                    + "RODPLAN_EMITENTE,"
                    + "RODPLAN_SETOR,"
                    + "RODPLAN_RESPONSAVEL "
                    + "FROM "
                    + "Cad_RodPlan"
                    + " WHERE"
                    + " RODPLAN_LINHA= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelRodapePlano.setRodplan_linha(this.getResultSet().getString(1));
                modelRodapePlano.setRodplan_data(this.getResultSet().getString(2));
                modelRodapePlano.setRodplan_rev(this.getResultSet().getInt(3));
                modelRodapePlano.setRodplan_descricao(this.getResultSet().getString(4));
                modelRodapePlano.setRodplan_emitente(this.getResultSet().getString(5));
                modelRodapePlano.setRodplan_setor(this.getResultSet().getString(6));
                modelRodapePlano.setRodplan_responsavel(this.getResultSet().getString(7));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelRodapePlano;
    }

    public ModelRodapePlano getRodapePlanoDAO(String pNome) {
        ModelRodapePlano modelRodapePlano = new ModelRodapePlano();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "RODPLAN_LINHA,"
                    + "RODPLAN_DATA,"
                    + "RODPLAN_REV,"
                    + "RODPLAN_DESCRICAO,"
                    + "RODPLAN_EMITENTE,"
                    + "RODPLAN_SETOR,"
                    + "RODPLAN_RESPONSAVEL "
                    + "FROM "
                    + "Cad_RodPlan"
                    + " WHERE"
                    + " RODPLAN_LINHA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelRodapePlano.setRodplan_linha(this.getResultSet().getString(1));
                modelRodapePlano.setRodplan_data(this.getResultSet().getString(2));
                modelRodapePlano.setRodplan_rev(this.getResultSet().getInt(3));
                modelRodapePlano.setRodplan_descricao(this.getResultSet().getString(4));
                modelRodapePlano.setRodplan_emitente(this.getResultSet().getString(5));
                modelRodapePlano.setRodplan_setor(this.getResultSet().getString(6));
                modelRodapePlano.setRodplan_responsavel(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelRodapePlano;
    }

    public ArrayList<ModelRodapePlano> getListaRodapePlanoDAO(String perfil) {
        ArrayList<ModelRodapePlano> listaRodapePlano = new ArrayList();
        ModelRodapePlano modelRodapePlano = new ModelRodapePlano();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "RODPLAN_LINHA,"
                    + "RODPLAN_DATA,"
                    + "RODPLAN_REV,"
                    + "RODPLAN_DESCRICAO,"
                    + "RODPLAN_EMITENTE,"
                    + "RODPLAN_SETOR,"
                    + "RODPLAN_RESPONSAVEL"
                    + " FROM"
                    + " Cad_RodPlan where RODPLAN_LINHA='" + perfil + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelRodapePlano = new ModelRodapePlano();
                modelRodapePlano.setRodplan_linha(this.getResultSet().getString(1));
                modelRodapePlano.setRodplan_data(this.getResultSet().getString(2));
                modelRodapePlano.setRodplan_rev(this.getResultSet().getInt(3));
                modelRodapePlano.setRodplan_descricao(this.getResultSet().getString(4));
                modelRodapePlano.setRodplan_emitente(this.getResultSet().getString(5));
                modelRodapePlano.setRodplan_setor(this.getResultSet().getString(6));
                modelRodapePlano.setRodplan_responsavel(this.getResultSet().getString(7));
                listaRodapePlano.add(modelRodapePlano);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaRodapePlano;
    }

    public boolean atualizarRodapePlanoDAO(ModelRodapePlano pModelRodapePlano) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_RodPlan SET "
                    + " RODPLAN_MATERIAL= '" + pModelRodapePlano.getRodplan_material() + "',"
                    + " RODPLAN_LINHA= '" + pModelRodapePlano.getRodplan_linha() + "',"
                    + " RODPLAN_DATA= '" + pModelRodapePlano.getRodplan_data() + "',"
                    + " RODPLAN_REV= '" + pModelRodapePlano.getRodplan_rev() + "',"
                    + " RODPLAN_DESCRICAO= '" + pModelRodapePlano.getRodplan_descricao() + "',"
                    + " RODPLAN_EMITENTE= '" + pModelRodapePlano.getRodplan_emitente() + "',"
                    + " RODPLAN_SETOR= '" + pModelRodapePlano.getRodplan_setor() + "',"
                    + " RODPLAN_RESPONSAVEL= '" + pModelRodapePlano.getRodplan_responsavel() + "'"
                    + " WHERE "
                    + " RODPLAN_LINHA= '" + pModelRodapePlano.getRodplan_linha() + "'"
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

    public boolean excluirRodapePlanoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_RodPlan "
                    + "WHERE "
                    + " RODPLAN_REV= '" + pCodigo + "'"
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
