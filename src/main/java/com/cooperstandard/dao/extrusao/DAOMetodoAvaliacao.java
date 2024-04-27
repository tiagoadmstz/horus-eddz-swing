/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelMetodoAvaliacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOMetodoAvaliacao extends ConexaoSql {

    public int salvarMetodoAvaliacaoDAO(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Metodo_Avaliacao ("
                    + "DESC_METODO,"
                    + "SETOR"
                    + ") VALUES ("
                    + "'" + pModelMetodoAvaliacao.getDesc_metodo() + "',"
                    + "'" + pModelMetodoAvaliacao.getSetor() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoDAO(int pCodigo) {
        ModelMetodoAvaliacao modelMetodoAvaliacao = new ModelMetodoAvaliacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_METODO,"
                    + "SETOR "
                    + "FROM "
                    + "Cad_Metodo_Avaliacao"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMetodoAvaliacao.setId(this.getResultSet().getInt(1));
                modelMetodoAvaliacao.setDesc_metodo(this.getResultSet().getString(2));
                modelMetodoAvaliacao.setSetor(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMetodoAvaliacao;
    }

    public ModelMetodoAvaliacao getMetodoAvaliacaoDAO(String pNome) {
        ModelMetodoAvaliacao modelMetodoAvaliacao = new ModelMetodoAvaliacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_METODO,"
                    + "SETOR "
                    + "FROM"
                    + " Cad_Metodo_Avaliacao"
                    + " WHERE"
                    + " DESC_METODO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMetodoAvaliacao.setId(this.getResultSet().getInt(1));
                modelMetodoAvaliacao.setDesc_metodo(this.getResultSet().getString(2));
                modelMetodoAvaliacao.setSetor(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMetodoAvaliacao;
    }

    public ArrayList<ModelMetodoAvaliacao> getListaMetodoAvaliacaoDAO() {
        ArrayList<ModelMetodoAvaliacao> listaMetodoAvaliacao = new ArrayList();
        ModelMetodoAvaliacao modelMetodoAvaliacao = new ModelMetodoAvaliacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_METODO,"
                    + "SETOR"
                    + " FROM"
                    + " Cad_Metodo_Avaliacao where SETOR='Extrusão' ORDER BY ID"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelMetodoAvaliacao = new ModelMetodoAvaliacao();
                modelMetodoAvaliacao.setId(this.getResultSet().getInt(1));
                modelMetodoAvaliacao.setDesc_metodo(this.getResultSet().getString(2));
                modelMetodoAvaliacao.setSetor(this.getResultSet().getString(3));
                listaMetodoAvaliacao.add(modelMetodoAvaliacao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaMetodoAvaliacao;
    }

    public boolean atualizarMetodoAvaliacaoDAO(ModelMetodoAvaliacao pModelMetodoAvaliacao) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Metodo_Avaliacao SET "
                    + " DESC_METODO= '" + pModelMetodoAvaliacao.getDesc_metodo() + "',"
                    + " SETOR= '" + pModelMetodoAvaliacao.getSetor() + "'"
                    + " WHERE "
                    + " ID= '" + pModelMetodoAvaliacao.getId() + "'"
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

    public boolean excluirMetodoAvaliacaoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Metodo_Avaliacao "
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
