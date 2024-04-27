package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelDdzControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAODdzControle extends ConexaoSql {

    public int salvarDdzControleDAO(ModelDdzControle pModelDdzControle) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO DDZ_Controle ("
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "PESO,"
                    + "CUSTO,"
                    + "VELOCIDADE"
                    + ") VALUES ("
                    + "'" + pModelDdzControle.getMaterial() + "',"
                    + "'" + pModelDdzControle.getData_base() + "',"
                    + "'" + pModelDdzControle.getLinha() + "',"
                    + "'" + pModelDdzControle.getPeso() + "',"
                    + "'" + pModelDdzControle.getCusto() + "',"
                    + "'" + pModelDdzControle.getVelocidade() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelDdzControle getDdzControleDAO(int pCodigo) {
        ModelDdzControle modelDdzControle = new ModelDdzControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA "
                    + "FROM "
                    + "DDZ_Controle"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelDdzControle.setId(this.getResultSet().getInt(1));
                modelDdzControle.setMaterial(this.getResultSet().getInt(2));
                modelDdzControle.setData_base(this.getResultSet().getString(3));
                modelDdzControle.setLinha(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelDdzControle;
    }

    public ModelDdzControle getDdzControleDAO(String pNome) {
        ModelDdzControle modelDdzControle = new ModelDdzControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "SCRAP_TOTAL "
                    + "FROM "
                    + "DDZ_Controle"
                    + " WHERE"
                    + " MATERIAL= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelDdzControle.setId(this.getResultSet().getInt(1));
                modelDdzControle.setMaterial(this.getResultSet().getInt(2));
                modelDdzControle.setData_base(this.getResultSet().getString(3));
                modelDdzControle.setLinha(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelDdzControle;
    }

    public ArrayList<ModelDdzControle> getListaDdzControleDAO(String linha) {
        ArrayList<ModelDdzControle> listaDdzControles = new ArrayList();
        ModelDdzControle modelDdzControle = new ModelDdzControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "SCRAP_TOTAL "
                    + " FROM"
                    + " DDZ_Controle  a "
                    + " where Linha NOT LIKE '%ATB%' and LINHA LIKE '%" + linha + "%' and not exists (select b.id_controle from ddz b where b.id_controle = a.id and b.flag = 'P') ORDER BY ID DESC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelDdzControle = new ModelDdzControle();
                modelDdzControle.setId(this.getResultSet().getInt(1));
                modelDdzControle.setMaterial(this.getResultSet().getInt(2));
                modelDdzControle.setData_base(this.getResultSet().getString(3));
                modelDdzControle.setLinha(this.getResultSet().getString(4));
                modelDdzControle.setScrap_total(this.getResultSet().getFloat(5));
                listaDdzControles.add(modelDdzControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaDdzControles;
    }

    public ArrayList<ModelDdzControle> getListaDdzATBControleDAO() {
        ArrayList<ModelDdzControle> listaDdzControles = new ArrayList();
        ModelDdzControle modelDdzControle = new ModelDdzControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA,"
                    + "SCRAP_TOTAL "
                    + " FROM"
                    + " DDZ_Controle  a "
                    + " where Linha LIKE '%ATB%' and not exists (select b.id_controle from ddz b where b.id_controle = a.id and b.flag = 'P') ORDER BY ID DESC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelDdzControle = new ModelDdzControle();
                modelDdzControle.setId(this.getResultSet().getInt(1));
                modelDdzControle.setMaterial(this.getResultSet().getInt(2));
                modelDdzControle.setData_base(this.getResultSet().getString(3));
                modelDdzControle.setLinha(this.getResultSet().getString(4));
                modelDdzControle.setScrap_total(this.getResultSet().getFloat(5));
                listaDdzControles.add(modelDdzControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaDdzControles;
    }

    public ArrayList<ModelDdzControle> getListaDdzControleAlterDAO(String perfil) {
        ArrayList<ModelDdzControle> listaDdzControles = new ArrayList();
        ModelDdzControle modelDdzControle = new ModelDdzControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MATERIAL,"
                    + "DATA_BASE,"
                    + "LINHA "
                    + " FROM"
                    + " DDZ_Controle  a "
                    + " where Linha NOT LIKE '%ATB%' and MATERIAL = '" + perfil + "'and exists (select b.id_controle from ddz b where b.id_controle = a.id and b.flag = 'P') ORDER BY ID DESC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelDdzControle = new ModelDdzControle();
                modelDdzControle.setId(this.getResultSet().getInt(1));
                modelDdzControle.setMaterial(this.getResultSet().getInt(2));
                modelDdzControle.setData_base(this.getResultSet().getString(3));
                modelDdzControle.setLinha(this.getResultSet().getString(4));
                listaDdzControles.add(modelDdzControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaDdzControles;
    }

    public boolean atualizarDdzControleDAO(ModelDdzControle pModelDdzControle, long id) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE DDZ_Controle SET "
                    + "SCRAP_TOTAL = '" + pModelDdzControle.getScrap_total() + "',"
                    + "CUSTO = '" + pModelDdzControle.getCusto() + "',"
                    + "VELOCIDADE = '" + pModelDdzControle.getVelocidade() + "',"
                    + "PESO = '" + pModelDdzControle.getPeso() + "'"
                    + " WHERE "
                    + "ID = '" + id + "'"
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

    public boolean excluirDdzControleDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM DDZ_Controle "
                    + "WHERE "
                    + "ID = '" + pCodigo + "'"
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
