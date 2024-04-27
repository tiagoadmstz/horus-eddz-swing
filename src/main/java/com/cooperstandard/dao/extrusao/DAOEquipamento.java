/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelEquipamento;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOEquipamento extends ConexaoSql {

    public int salvarEquipamentoDAO(ModelEquipamento pModelEquipamento) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Equipamento ("
                    + "ORDEM,"
                    + "EQUIPAMENTO,"
                    + "EQU_OPERACAO"
                    + ") VALUES ("
                    + "'" + pModelEquipamento.getOrdem() + "',"
                    + "'" + pModelEquipamento.getEquipamento() + "',"
                    + "'" + pModelEquipamento.getEqu_operacao() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelEquipamento getEquipamentoDAO(int pCodigo) {
        ModelEquipamento modelEquipamento = new ModelEquipamento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_EQUIPAMENTO,"
                    + "ORDEM,"
                    + "EQUIPAMENTO,"
                    + "EQU_OPERACAO "
                    + "FROM "
                    + "Cad_Equipamento"
                    + " WHERE"
                    + " ID_EQUIPAMENTO= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEquipamento.setId_equipamento(this.getResultSet().getInt(1));
                modelEquipamento.setOrdem(this.getResultSet().getInt(2));
                modelEquipamento.setEquipamento(this.getResultSet().getString(3));
                modelEquipamento.setEqu_operacao(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEquipamento;
    }

    public ModelEquipamento getEquipamentoDAO(String pNome) {
        ModelEquipamento modelEquipamento = new ModelEquipamento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_EQUIPAMENTO,"
                    + "ORDEM,"
                    + "EQUIPAMENTO,"
                    + "EQU_OPERACAO "
                    + "FROM "
                    + "Cad_Equipamento"
                    + " WHERE"
                    + " EQUIPAMENTO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEquipamento.setId_equipamento(this.getResultSet().getInt(1));
                modelEquipamento.setOrdem(this.getResultSet().getInt(2));
                modelEquipamento.setEquipamento(this.getResultSet().getString(3));
                modelEquipamento.setEqu_operacao(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEquipamento;
    }

    public ArrayList<ModelEquipamento> getListaEquipamentoDAO() {
        ArrayList<ModelEquipamento> listaEquipamento = new ArrayList();
        ModelEquipamento modelEquipamento = new ModelEquipamento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_EQUIPAMENTO,"
                    + "ORDEM,"
                    + "EQUIPAMENTO,"
                    + "EQU_OPERACAO"
                    + " FROM"
                    + " Qry_Equipamento where OPE_SETOR='Extrusão' ORDER BY ORDEM"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEquipamento = new ModelEquipamento();
                modelEquipamento.setId_equipamento(this.getResultSet().getInt(1));
                modelEquipamento.setOrdem(this.getResultSet().getInt(2));
                modelEquipamento.setEquipamento(this.getResultSet().getString(3));
                modelEquipamento.setEqu_operacao(this.getResultSet().getString(4));

                listaEquipamento.add(modelEquipamento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEquipamento;
    }

    public boolean atualizarEquipamentoDAO(ModelEquipamento pModelEquipamento) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Equipamento SET "
                    + " ORDEM= '" + pModelEquipamento.getOrdem() + "',"
                    + " EQUIPAMENTO= '" + pModelEquipamento.getEquipamento() + "',"
                    + " EQU_OPERACAO= '" + pModelEquipamento.getEqu_operacao() + "'"
                    + " WHERE "
                    + " ID_EQUIPAMENTO= '" + pModelEquipamento.getId_equipamento() + "'"
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

    public boolean excluirEquipamentoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Equipamento "
                    + "WHERE "
                    + "ID_EQUIPAMENTO = '" + pCodigo + "'"
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
