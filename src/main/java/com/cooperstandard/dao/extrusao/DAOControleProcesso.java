/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelControleProcesso;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOControleProcesso extends ConexaoSql {

    public int salvarControleProcessoDAO(ModelControleProcesso pModelControleProcesso) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Controle_Processo ("
                    + "DESC_CONTROLE,"
                    + "PREVENT_DETECT,"
                    + "METODO_AVALIACAO,"
                    + "SETOR "
                    + ") VALUES ("
                    + "'" + pModelControleProcesso.getDesc_controle() + "',"
                    + "'" + pModelControleProcesso.getPrevent_detect() + "',"
                    + "'" + pModelControleProcesso.getMetodo_avaliacao() + "',"
                    + "'" + pModelControleProcesso.getSetor() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelControleProcesso getControleProcessoDAO(int pCodigo) {
        ModelControleProcesso modelControleProcesso = new ModelControleProcesso();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_CONTROLE,"
                    + "PREVENT_DETECT,"
                    + "METODO_AVALIACAO,"
                    + "SETOR "
                    + "FROM "
                    + "Cad_Controle_Processo"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelControleProcesso.setId(this.getResultSet().getInt(1));
                modelControleProcesso.setDesc_controle(this.getResultSet().getString(2));
                modelControleProcesso.setPrevent_detect(this.getResultSet().getString(3));
                modelControleProcesso.setMetodo_avaliacao(this.getResultSet().getString(4));
                modelControleProcesso.setSetor(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelControleProcesso;
    }

    public ModelControleProcesso getControleProcessoDAO(String pNome) {
        ModelControleProcesso modelControleProcesso = new ModelControleProcesso();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_CONTROLE,"
                    + "PREVENT_DETECT,"
                    + "METODO_AVALIACAO,"
                    + "SETOR "
                    + "FROM "
                    + "Cad_Equipamento"
                    + " WHERE"
                    + " EQUIPAMENTO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelControleProcesso.setId(this.getResultSet().getInt(1));
                modelControleProcesso.setDesc_controle(this.getResultSet().getString(2));
                modelControleProcesso.setPrevent_detect(this.getResultSet().getString(3));
                modelControleProcesso.setMetodo_avaliacao(this.getResultSet().getString(4));
                modelControleProcesso.setSetor(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelControleProcesso;
    }

    public ArrayList<ModelControleProcesso> getListaControleProcessoDAO() {
        ArrayList<ModelControleProcesso> listaControleProcesso = new ArrayList();
        ModelControleProcesso modelControleProcesso = new ModelControleProcesso();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_CONTROLE,"
                    + "PREVENT_DETECT,"
                    + "METODO_AVALIACAO,"
                    + "SETOR "
                    + " FROM"
                    + " Cad_Controle_Processo where SETOR='Extrusão' ORDER BY DESC_CONTROLE"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelControleProcesso = new ModelControleProcesso();
                modelControleProcesso.setId(this.getResultSet().getInt(1));
                modelControleProcesso.setDesc_controle(this.getResultSet().getString(2));
                modelControleProcesso.setPrevent_detect(this.getResultSet().getString(3));
                modelControleProcesso.setMetodo_avaliacao(this.getResultSet().getString(4));
                modelControleProcesso.setSetor(this.getResultSet().getString(5));

                listaControleProcesso.add(modelControleProcesso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaControleProcesso;
    }

    public boolean atualizarControleProcessoDAO(ModelControleProcesso pModelControleProcesso) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Controle_Processo SET "
                    + " DESC_CONTROLE= '" + pModelControleProcesso.getDesc_controle() + "',"
                    + " PREVENT_DETECT= '" + pModelControleProcesso.getPrevent_detect() + "',"
                    + " METODO_AVALIACAO= '" + pModelControleProcesso.getMetodo_avaliacao() + "',"
                    + " SETOR= '" + pModelControleProcesso.getSetor() + "'"
                    + " WHERE "
                    + "ID = '" + pModelControleProcesso.getId() + "'"
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

    public boolean excluirControleProcessoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Controle_Processo "
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
