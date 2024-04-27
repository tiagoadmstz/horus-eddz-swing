package com.cooperstandard.dao.pontoinsp;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelTeste;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOTeste extends ConexaoSql {

    public int salvarTesteDAO(ModelTeste pModelTeste) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Teste ("
                    + "ORDEM,"
                    + "TES_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "CLASSIFICACAO,"
                    + "CONTROL_PRCESS,"
                    + "COD_TESTE"
                    + ") VALUES ("
                    + "'" + pModelTeste.getOrdem() + "',"
                    + "'" + pModelTeste.getTes_equipamento() + "',"
                    + "'" + pModelTeste.getDesc_teste() + "',"
                    + "'" + pModelTeste.getClassificacao() + "',"
                    + "'" + pModelTeste.getControl_prcess() + "',"
                    + "'" + pModelTeste.getCod_teste() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelTeste getTesteDAO(int pCodigo) {
        ModelTeste modelTeste = new ModelTeste();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_TESTE,"
                    + "ORDEM,"
                    + "TES_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "CLASSIFICACAO,"
                    + "CONTROL_PRCESS,"
                    + "COD_TESTE "
                    + "FROM "
                    + "Cad_Teste"
                    + " WHERE"
                    + " ID_TESTE= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelTeste.setId_teste(this.getResultSet().getInt(1));
                modelTeste.setOrdem(this.getResultSet().getInt(2));
                modelTeste.setTes_equipamento(this.getResultSet().getString(3));
                modelTeste.setDesc_teste(this.getResultSet().getString(4));
                modelTeste.setClassificacao(this.getResultSet().getString(5));
                modelTeste.setControl_prcess(this.getResultSet().getString(6));
                modelTeste.setCod_teste(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelTeste;
    }

    public ModelTeste getTesteDAO(String pNome) {
        ModelTeste modelTeste = new ModelTeste();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_TESTE,"
                    + "ORDEM,"
                    + "TES_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "CLASSIFICACAO,"
                    + "CONTROL_PRCESS,"
                    + "COD_TESTE "
                    + "FROM "
                    + "Cad_Material"
                    + " WHERE"
                    + " DESC_TESTE= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelTeste.setId_teste(this.getResultSet().getInt(1));
                modelTeste.setOrdem(this.getResultSet().getInt(2));
                modelTeste.setTes_equipamento(this.getResultSet().getString(3));
                modelTeste.setDesc_teste(this.getResultSet().getString(4));
                modelTeste.setClassificacao(this.getResultSet().getString(5));
                modelTeste.setControl_prcess(this.getResultSet().getString(6));
                modelTeste.setCod_teste(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelTeste;
    }

    public ArrayList<ModelTeste> getListaTesteDAO() {
        ArrayList<ModelTeste> listaTeste = new ArrayList();
        ModelTeste modelTeste = new ModelTeste();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_TESTE,"
                    + "ORDEM,"
                    + "TES_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "CLASSIFICACAO,"
                    + "COD_TESTE"
                    + " FROM"
                    + " Cad_Teste where TES_EQUIPAMENTO='Laboratório' ORDER BY ORDEM"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelTeste = new ModelTeste();
                modelTeste.setId_teste(this.getResultSet().getInt(1));
                modelTeste.setOrdem(this.getResultSet().getInt(2));
                modelTeste.setTes_equipamento(this.getResultSet().getString(3));
                modelTeste.setDesc_teste(this.getResultSet().getString(4));
                modelTeste.setClassificacao(this.getResultSet().getString(5));
                modelTeste.setCod_teste(this.getResultSet().getString(6));

                listaTeste.add(modelTeste);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaTeste;
    }

    public boolean atualizarTesteDAO(ModelTeste pModelTeste) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Teste SET "
                    + " ORDEM= '" + pModelTeste.getOrdem() + "',"
                    + " TES_EQUIPAMENTO= '" + pModelTeste.getTes_equipamento() + "',"
                    + " DESC_TESTE= '" + pModelTeste.getDesc_teste() + "',"
                    + " CLASSIFICACAO= '" + pModelTeste.getClassificacao() + "',"
                    + " CONTROL_PRCESS= '" + pModelTeste.getControl_prcess() + "',"
                    + " COD_TESTE= '" + pModelTeste.getCod_teste() + "'"
                    + " WHERE "
                    + " ID_TESTE= '" + pModelTeste.getId_teste() + "'"
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

    public boolean excluirTesteDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Teste "
                    + "WHERE "
                    + " ID_TESTE= '" + pCodigo + "'"
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
