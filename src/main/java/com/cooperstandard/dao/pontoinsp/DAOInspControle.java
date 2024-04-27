package com.cooperstandard.dao.pontoinsp;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelInspControle;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOInspControle extends ConexaoSql {

    public int salvarInspControleDAO(ModelInspControle pModelInspControle) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO INSP_Controle ("
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "DATA_BASE"
                    + ") VALUES ("
                    + "'" + pModelInspControle.getPerfil() + "',"
                    + "'" + pModelInspControle.getSolicitante() + "',"
                    + "'" + pModelInspControle.getData_jet() + "',"
                    + "'" + pModelInspControle.getHora_jet() + "',"
                    + "'" + pModelInspControle.getData_base() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelInspControle getInspControleDAO(int pCodigo) {
        ModelInspControle modelInspControle = new ModelInspControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "DATA_BASE"
                    + "FROM "
                    + "INSP_Controle"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelInspControle.setId(this.getResultSet().getInt(1));
                modelInspControle.setPerfil(this.getResultSet().getInt(2));
                modelInspControle.setData_jet(this.getResultSet().getString(3));
                modelInspControle.setHora_jet(this.getResultSet().getString(4));
                modelInspControle.setData_base(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelInspControle;
    }

    public ModelInspControle getInspControleDAO(String pNome) {
        ModelInspControle modelInspControle = new ModelInspControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "DATA_BASE"
                    + "FROM "
                    + "INSP_Controle"
                    + " WHERE"
                    + " MATERIAL= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelInspControle.setId(this.getResultSet().getInt(1));
                modelInspControle.setPerfil(this.getResultSet().getInt(2));
                modelInspControle.setData_jet(this.getResultSet().getString(3));
                modelInspControle.setHora_jet(this.getResultSet().getString(4));
                modelInspControle.setData_base(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelInspControle;
    }

    public ArrayList<ModelInspControle> getListaInspControleDAO() {
        ArrayList<ModelInspControle> listaInspControles = new ArrayList();
        ModelInspControle modelInspControle = new ModelInspControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "INSP_Controle.ID,"
                    + "MAT_LINHA,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "INSP_Controle.STATUS,"
                    + "TIPO,"
                    + "DATA_BASE"
                    + " FROM "
                    + " INSP_Controle "
                    + "INNER JOIN Cad_ResultadoInsp R ON R.ID_CONTROLE = INSP_Controle.ID "
                    + "INNER JOIN Cad_Material ON MATERIAL = INSP_Controle.PERFIL "
                    + "WHERE RECONHECIMENTO is null "
                    + "order by DATA_BASE DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelInspControle = new ModelInspControle();
                modelInspControle.setId(this.getResultSet().getInt(1));
                modelInspControle.setLinha(this.getResultSet().getString(2));
                modelInspControle.setPerfil(this.getResultSet().getInt(3));
                modelInspControle.setSolicitante(this.getResultSet().getString(4));
                modelInspControle.setData_jet(this.getResultSet().getString(5));
                modelInspControle.setHora_jet(this.getResultSet().getString(6));
                modelInspControle.setStatus(this.getResultSet().getString(7));
                modelInspControle.setTipoteste(this.getResultSet().getString(8));
                listaInspControles.add(modelInspControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaInspControles;
    }

    public ArrayList<ModelInspControle> getListaInspControleDAO(String linha) {
        ArrayList<ModelInspControle> listaInspControles = new ArrayList();
        ModelInspControle modelInspControle = new ModelInspControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "INSP_Controle.ID,"
                    + "MAT_LINHA,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "INSP_Controle.STATUS,"
                    + "TIPO,"
                    + "DATA_BASE"
                    + " FROM "
                    + " INSP_Controle "
                    + "INNER JOIN Cad_ResultadoInsp R ON R.ID_CONTROLE = INSP_Controle.ID "
                    + "INNER JOIN Cad_Material ON MATERIAL = INSP_Controle.PERFIL "
                    + "WHERE RECONHECIMENTO is null and MAT_LINHA LIKE '%" + linha + "%' "
                    + "order by DATA_BASE DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelInspControle = new ModelInspControle();
                modelInspControle.setId(this.getResultSet().getInt(1));
                modelInspControle.setLinha(this.getResultSet().getString(2));
                modelInspControle.setPerfil(this.getResultSet().getInt(3));
                modelInspControle.setSolicitante(this.getResultSet().getString(4));
                modelInspControle.setData_jet(this.getResultSet().getString(5));
                modelInspControle.setHora_jet(this.getResultSet().getString(6));
                modelInspControle.setStatus(this.getResultSet().getString(7));
                modelInspControle.setTipoteste(this.getResultSet().getString(8));
                listaInspControles.add(modelInspControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaInspControles;
    }

    public ArrayList<ModelInspControle> getListaInspControleCloseDAO(String linha) {
        ArrayList<ModelInspControle> listaInspControles = new ArrayList();
        ModelInspControle modelInspControle = new ModelInspControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT TOP (20)"
                    + "INSP_Controle.ID,"
                    + "MAT_LINHA,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "INSP_Controle.STATUS,"
                    + "TIPO,"
                    + "DATA_BASE"
                    + " FROM "
                    + " INSP_Controle "
                    + "INNER JOIN Cad_ResultadoInsp R ON R.ID_CONTROLE = INSP_Controle.ID "
                    + "INNER JOIN Cad_Material ON MATERIAL = INSP_Controle.PERFIL "
                    + "WHERE RECONHECIMENTO != '' and MAT_LINHA LIKE '%" + linha + "%' "
                    + "order by DATA_BASE DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelInspControle = new ModelInspControle();
                modelInspControle.setId(this.getResultSet().getInt(1));
                modelInspControle.setLinha(this.getResultSet().getString(2));
                modelInspControle.setPerfil(this.getResultSet().getInt(3));
                modelInspControle.setSolicitante(this.getResultSet().getString(4));
                modelInspControle.setData_jet(this.getResultSet().getString(5));
                modelInspControle.setHora_jet(this.getResultSet().getString(6));
                modelInspControle.setStatus(this.getResultSet().getString(7));
                modelInspControle.setTipoteste(this.getResultSet().getString(8));
                listaInspControles.add(modelInspControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaInspControles;
    }

    public boolean atualizarInspControleDAO(ModelInspControle pModelInspControle, long id) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE INSP_Controle SET "
                    + " STATUS= '" + pModelInspControle.getStatus() + "'"
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

    public boolean excluirInspControleDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM INSP_Controle "
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
