/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelRodape;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rsouza10
 */
public class DAORodape extends ConexaoSql {

    public int salvarRodapeDAO(ModelRodape pModelRodape) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Rodape ("
                    + "ROD_DATA,"
                    + "ROD_REV,"
                    + "ROD_DESCRICAO,"
                    + "ROD_EMITENTE,"
                    + "ROD_SETOR,"
                    + "ROD_RESPONSAVEL,"
                    + "ROD_MATERIAL"
                    + ") VALUES ("
                    + "'" + pModelRodape.getRod_data() + "',"
                    + "'" + pModelRodape.getRod_rev() + "',"
                    + "'" + pModelRodape.getRod_descricao() + "',"
                    + "'" + pModelRodape.getRod_emitente() + "',"
                    + "'" + pModelRodape.getRod_setor() + "',"
                    + "'" + pModelRodape.getRod_responsavel() + "',"
                    + "'" + pModelRodape.getRod_material() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelRodape getRodapeDAO(int pCodigo) {
        ModelRodape modelRodape = new ModelRodape();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "ROD_DATA,"
                    + "ROD_REV,"
                    + "ROD_DESCRICAO,"
                    + "ROD_EMITENTE,"
                    + "ROD_SETOR,"
                    + "ROD_RESPONSAVEL,"
                    + "ROD_MATERIAL "
                    + "FROM "
                    + "Cad_Rodape"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelRodape.setId(this.getResultSet().getInt(1));
                modelRodape.setRod_data(this.getResultSet().getString(2));
                modelRodape.setRod_rev(this.getResultSet().getInt(3));
                modelRodape.setRod_descricao(this.getResultSet().getString(4));
                modelRodape.setRod_emitente(this.getResultSet().getString(5));
                modelRodape.setRod_setor(this.getResultSet().getString(6));
                modelRodape.setRod_responsavel(this.getResultSet().getString(7));
                modelRodape.setRod_material(this.getResultSet().getInt(8));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelRodape;
    }

    public ModelRodape getRodapeDAO(String pNome) {
        ModelRodape modelRodape = new ModelRodape();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "ROD_DATA,"
                    + "ROD_REV,"
                    + "ROD_EMITENTE,"
                    + "ROD_SETOR,"
                    + "ROD_RESPONSAVEL,"
                    + "ROD_MATERIAL "
                    + "FROM"
                    + " Cad_Rodape"
                    + " WHERE"
                    + " ROD_DESCRICAO= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelRodape.setId(this.getResultSet().getInt(1));
                modelRodape.setRod_data(this.getResultSet().getString(2));
                modelRodape.setRod_rev(this.getResultSet().getInt(3));
                modelRodape.setRod_descricao(this.getResultSet().getString(4));
                modelRodape.setRod_emitente(this.getResultSet().getString(5));
                modelRodape.setRod_setor(this.getResultSet().getString(6));
                modelRodape.setRod_responsavel(this.getResultSet().getString(7));
                modelRodape.setRod_material(this.getResultSet().getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelRodape;
    }

    public ArrayList<ModelRodape> getListaRodapeDAO(String perfil) {
        ArrayList<ModelRodape> listaRodape = new ArrayList();
        ModelRodape modelRodape = new ModelRodape();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "ROD_DATA,"
                    + "ROD_REV,"
                    + "ROD_DESCRICAO,"
                    + "ROD_EMITENTE,"
                    + "ROD_SETOR,"
                    + "ROD_RESPONSAVEL,"
                    + "ROD_MATERIAL"
                    + " FROM"
                    + " Cad_Rodape where ROD_MATERIAL='" + perfil + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelRodape = new ModelRodape();
                modelRodape.setId(this.getResultSet().getInt(1));
                modelRodape.setRod_data(this.getResultSet().getString(2));
                modelRodape.setRod_rev(this.getResultSet().getInt(3));
                modelRodape.setRod_descricao(this.getResultSet().getString(4));
                modelRodape.setRod_emitente(this.getResultSet().getString(5));
                modelRodape.setRod_setor(this.getResultSet().getString(6));
                modelRodape.setRod_responsavel(this.getResultSet().getString(7));
                modelRodape.setRod_material(this.getResultSet().getInt(8));
                listaRodape.add(modelRodape);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaRodape;
    }

    public boolean atualizarRodapeDAO(ModelRodape pModelRodape) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Rodape SET "
                    + " ROD_DATA= '" + pModelRodape.getRod_data() + "',"
                    + " ROD_REV= '" + pModelRodape.getRod_rev() + "',"
                    + " ROD_DESCRICAO= '" + pModelRodape.getRod_descricao() + "',"
                    + " ROD_EMITENTE= '" + pModelRodape.getRod_emitente() + "',"
                    + " ROD_SETOR= '" + pModelRodape.getRod_setor() + "',"
                    + " ROD_RESPONSAVEL= '" + pModelRodape.getRod_responsavel() + "',"
                    + " ROD_MATERIAL= '" + pModelRodape.getRod_material() + "'"
                    + " WHERE "
                    + " ID= '" + pModelRodape.getId() + "'"
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

    public boolean excluirRodapeDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Rodape "
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
