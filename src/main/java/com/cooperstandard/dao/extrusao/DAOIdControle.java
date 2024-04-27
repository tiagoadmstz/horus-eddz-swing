package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelIdControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOIdControle extends ConexaoSql {

    public int salvarIdControleDAO(ModelIdControle pModelModelIdControle) {
        try {

            this.conectar();
            return this.insertSQL(
                    "INSERT INTO DDZ_CONTROLE ("
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "SCRAP_TOTAL,"
                    + "EVIDENCIA"
                    + ") VALUES ("
                    + "'" + pModelModelIdControle.getMaterial() + "',"
                    + "'" + pModelModelIdControle.getData_base() + "',"
                    + "'" + pModelModelIdControle.getLinha() + "',"
                    + "'" + pModelModelIdControle.getScrap_total() + "',"
                    + "'" + pModelModelIdControle.getEvidencia() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelIdControle getIdControleDAO(int pCodigo) {
        ModelIdControle modelIdControle = new ModelIdControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "LINHA,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "SCRAP_TOTAL,"
                    + "EVIDENCIA"
                    + " FROM"
                    + " DDZ_CONTROLE"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelIdControle.setID(this.getResultSet().getInt(1));
                modelIdControle.setLinha(this.getResultSet().getString(2));
                modelIdControle.setMaterial(this.getResultSet().getInt(3));
                modelIdControle.setData_base(this.getResultSet().getTimestamp(4));
                modelIdControle.setScrap_total(this.getResultSet().getFloat(5));
                modelIdControle.setEvidencia(this.getResultSet().getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelIdControle;
    }

    public ModelIdControle getIdControleDAO(String pNome) {
        ModelIdControle modelIdControle = new ModelIdControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "SCRAP_TOTAL,"
                    + "EVIDENCIA"
                    + " FROM "
                    + "DDZ_CONTROLE"
                    + " WHERE"
                    + " ID= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelIdControle.setMaterial(this.getResultSet().getInt(1));
                modelIdControle.setData_base(this.getResultSet().getTimestamp(2));
                modelIdControle.setLinha(this.getResultSet().getString(3));
                modelIdControle.setScrap_total(this.getResultSet().getFloat(4));
                modelIdControle.setEvidencia(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelIdControle;
    }

    public ArrayList<ModelIdControle> getListaIdControleDAO() {
        ArrayList<ModelIdControle> listaIdControle = new ArrayList();
        ModelIdControle modelIdControle = new ModelIdControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "LINHA,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "SCRAP_TOTAL,"
                    + "EVIDENCIA"
                    + " FROM"
                    + " DDZ_CONTROLE order by ID DESC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelIdControle = new ModelIdControle();
                modelIdControle.setID(this.getResultSet().getInt(1));
                modelIdControle.setLinha(this.getResultSet().getString(2));
                modelIdControle.setMaterial(this.getResultSet().getInt(3));
                modelIdControle.setData_base(this.getResultSet().getTimestamp(4));
                modelIdControle.setScrap_total(this.getResultSet().getFloat(5));
                modelIdControle.setEvidencia(this.getResultSet().getString(6));

                listaIdControle.add(modelIdControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaIdControle;
    }

    public boolean atualizarIdControleDAO(ModelIdControle pModelIdControle) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE DDZ_CONTROLE SET "
                    + " EVIDENCIA= '" + pModelIdControle.getEvidencia() + "'"
                    + " WHERE "
                    + " ID= '" + pModelIdControle.getID() + "'"
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

    public boolean excluirIdControleDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM DDZ_CONTROLE "
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
