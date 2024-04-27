/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.pontoinsp;

import com.cooperstandard.dao.extrusao.*;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelMaterial;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOMaterial extends ConexaoSql {

    public int salvarMaterialDAO(ModelMaterial pModelMaterial) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Material ("
                    + "MATERIAL,"
                    + "BPCS,"
                    + "DESC_MATERIAL,"
                    + "MAT_LINHA,"
                    + "MAT_PROJETO,"
                    + "N_DESENHO,"
                    + "N_PLANO,"
                    + "IMAGE"
                    + ") VALUES ("
                    + "'" + pModelMaterial.getMaterial() + "',"
                    + "'" + pModelMaterial.getBpcs() + "',"
                    + "'" + pModelMaterial.getDesc_material() + "',"
                    + "'" + pModelMaterial.getMat_linha() + "',"
                    + "'" + pModelMaterial.getMat_projeto() + "',"
                    + "'" + pModelMaterial.getN_desenho() + "',"
                    + "'" + pModelMaterial.getN_plano() + "',"
                    + "'" + pModelMaterial.getImagem() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelMaterial getMaterialDAO(int pCodigo) {
        ModelMaterial modelMaterial = new ModelMaterial();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_MATERIAL,"
                    + "MATERIAL,"
                    + "BPCS,"
                    + "DESC_MATERIAL,"
                    + "MAT_LINHA,"
                    + "MAT_PROJETO,"
                    + "N_DESENHO,"
                    + "N_PLANO,"
                    + "IMAGE "
                    + "FROM "
                    + "Cad_Material"
                    + " WHERE"
                    + " ID_MATERIAL= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMaterial.setId_material(this.getResultSet().getInt(1));
                modelMaterial.setMaterial(this.getResultSet().getInt(2));
                modelMaterial.setBpcs(this.getResultSet().getString(3));
                modelMaterial.setDesc_material(this.getResultSet().getString(4));
                modelMaterial.setMat_linha(this.getResultSet().getString(5));
                modelMaterial.setMat_projeto(this.getResultSet().getString(6));
                modelMaterial.setN_desenho(this.getResultSet().getString(7));
                modelMaterial.setN_plano(this.getResultSet().getString(8));
                modelMaterial.setImagem(this.getResultSet().getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMaterial;
    }

    public ModelMaterial getMaterialDAO(Integer pNome) {
        ModelMaterial modelMaterial = new ModelMaterial();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_MATERIAL,"
                    + "MATERIAL,"
                    + "BPCS,"
                    + "DESC_MATERIAL,"
                    + "MAT_LINHA,"
                    + "MAT_PROJETO,"
                    + "N_DESENHO,"
                    + "N_PLANO,"
                    + "IMAGE "
                    + "FROM "
                    + "Cad_Material"
                    + " WHERE"
                    + " MATERIAL= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelMaterial.setId_material(this.getResultSet().getInt(1));
                modelMaterial.setMaterial(this.getResultSet().getInt(2));
                modelMaterial.setBpcs(this.getResultSet().getString(3));
                modelMaterial.setDesc_material(this.getResultSet().getString(4));
                modelMaterial.setMat_linha(this.getResultSet().getString(5));
                modelMaterial.setMat_projeto(this.getResultSet().getString(6));
                modelMaterial.setN_desenho(this.getResultSet().getString(7));
                modelMaterial.setN_plano(this.getResultSet().getString(8));
                modelMaterial.setImagem(this.getResultSet().getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMaterial;
    }

    public ArrayList<ModelMaterial> getListaMaterialDAO() {
        ArrayList<ModelMaterial> listaMaterial = new ArrayList();
        ModelMaterial modelMaterial = new ModelMaterial();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_MATERIAL,"
                    + "MATERIAL,"
                    + "BPCS,"
                    + "DESC_MATERIAL,"
                    + "MAT_LINHA,"
                    + "MAT_PROJETO,"
                    + "N_DESENHO,"
                    + "N_PLANO,"
                    + "IMAGE "
                    + " FROM"
                    + " Qry_Material where SETOR='Extrusão' ORDER BY MAT_LINHA,MATERIAL ASC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelMaterial = new ModelMaterial();
                modelMaterial.setId_material(this.getResultSet().getInt(1));
                modelMaterial.setMaterial(this.getResultSet().getInt(2));
                modelMaterial.setBpcs(this.getResultSet().getString(3));
                modelMaterial.setDesc_material(this.getResultSet().getString(4));
                modelMaterial.setMat_linha(this.getResultSet().getString(5));
                modelMaterial.setMat_projeto(this.getResultSet().getString(6));
                modelMaterial.setN_desenho(this.getResultSet().getString(7));
                modelMaterial.setN_plano(this.getResultSet().getString(8));
                modelMaterial.setImagem(this.getResultSet().getString(9));

                listaMaterial.add(modelMaterial);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaMaterial;
    }

    public boolean atualizarMaterialDAO(ModelMaterial pModelMaterial) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Material SET "
                    + " MATERIAL= '" + pModelMaterial.getMaterial() + "',"
                    + " BPCS= '" + pModelMaterial.getBpcs() + "',"
                    + " DESC_MATERIAL= '" + pModelMaterial.getDesc_material() + "',"
                    + " MAT_LINHA= '" + pModelMaterial.getMat_linha() + "',"
                    + " MAT_PROJETO= '" + pModelMaterial.getMat_projeto() + "',"
                    + " N_DESENHO= '" + pModelMaterial.getN_desenho() + "',"
                    + " N_PLANO= '" + pModelMaterial.getN_plano() + "',"
                    + " IMAGE= '" + pModelMaterial.getImagem() + "'"
                    + " WHERE "
                    + " ID_MATERIAL= '" + pModelMaterial.getId_material() + "'"
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

    public boolean excluirMaterialDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Material "
                    + "WHERE "
                    + " ID_MATERIAL= '" + pCodigo + "'"
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
