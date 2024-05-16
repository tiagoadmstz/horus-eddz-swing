/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelMontadora;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOMontadora extends ConexaoSql {

    public int salvarMontadoraDAO(ModelMontadora pModelMontadora) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Oem ("
                    + "OEM"
                    + ") VALUES ("
                    + "'" + pModelMontadora.getOemDescription() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelMontadora getMontadoraDAO(int pCodigo) {
        ModelMontadora modelMontadora = new ModelMontadora();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OEM,"
                    + "OEM "
                    + "FROM "
                    + "Cad_Oem"
                    + " WHERE"
                    + " ID_OEM= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMontadora.setId(this.getResultSet().getInt(1));
                modelMontadora.setOemDescription(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMontadora;
    }

    public ModelMontadora getMontadoraDAO(String pNome) {
        ModelMontadora modelMontadora = new ModelMontadora();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OEM,"
                    + "OEM "
                    + "FROM"
                    + "Cad_Oem"
                    + " WHERE"
                    + " OEM= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMontadora.setId(this.getResultSet().getInt(1));
                modelMontadora.setOemDescription(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMontadora;
    }

    public ArrayList<ModelMontadora> getListaMontadoraDAO() {
        ArrayList<ModelMontadora> listaMontadoras = new ArrayList();
        ModelMontadora modelMontadora = new ModelMontadora();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OEM,"
                    + "OEM"
                    + " FROM"
                    + " Cad_Oem ORDER BY ID_OEM"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelMontadora = new ModelMontadora();
                modelMontadora.setId(this.getResultSet().getInt(1));
                modelMontadora.setOemDescription(this.getResultSet().getString(2));
                listaMontadoras.add(modelMontadora);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaMontadoras;
    }

    public boolean atualizarMontadoraDAO(ModelMontadora pModelMontadora) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Oem SET "
                    + "OEM = '" + pModelMontadora.getOemDescription() + "'"
                    + " WHERE "
                    + "ID_OEM = '" + pModelMontadora.getId() + "'"
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

    public boolean excluirMontadoraDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Oem "
                    + "WHERE "
                    + "ID_OEM = '" + pCodigo + "'"
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
