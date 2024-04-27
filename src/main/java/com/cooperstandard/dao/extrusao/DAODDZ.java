package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelDDZ;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAODDZ extends ConexaoSql {

    public int salvarDDZDAO(ModelDDZ pModelModelDDZ) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO DDZ ("
                    + "ACAO_TOMADA,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "OBSERVACAO,"
                    + "QTD_SCRAP,"
                    + "TURNO,"
                    + "ID_CAUSA_ID,"
                    + "ID_M_MATERIAL,"
                    + "QTD_SCRAP_REAIS,"
                    + "QTD_SCRAP_KG,"
                    + "VELOCIDADE,"
                    + "PESO,"
                    + "DATA_REAL,"
                    + "FLAG,"
                    + "ID_CONTROLE "
                    + ") VALUES ("
                    + "'" + pModelModelDDZ.getAcao_tomada() + "',"
                    + "'" + pModelModelDDZ.getData_input() + "',"
                    + "'" + pModelModelDDZ.getHora_input() + "',"
                    + "'" + pModelModelDDZ.getObservacao() + "',"
                    + "'" + pModelModelDDZ.getQtd_scrap() + "',"
                    + "'" + pModelModelDDZ.getTurno() + "',"
                    + "'" + pModelModelDDZ.getId_causa() + "',"
                    + "'" + pModelModelDDZ.getId_material() + "',"
                    + "'" + pModelModelDDZ.getQtd_scrap_reais() + "',"
                    + "'" + pModelModelDDZ.getQtd_scrap_kg() + "',"
                    + "'" + pModelModelDDZ.getVelocidade() + "',"
                    + "'" + pModelModelDDZ.getPeso() + "',"
                    + "'" + pModelModelDDZ.getData_real() + "',"
                    + "'" + pModelModelDDZ.getFlag() + "',"
                    + "'" + pModelModelDDZ.getId_controle() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelDDZ getDDZDAO(String perfil) {
        ModelDDZ modelDDZ = new ModelDDZ();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT top 1 "
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP,"
                    + "TURNO,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "MAT_LINHA,"
                    + "MATERIAL,"
                    + "BPCS,"
                    + "DESC_MATERIAL,"
                    + "QTD_SCRAP_KG,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID INNER JOIN DDZ DDZ ON Causas.ID = DDZ.ID_CAUSA_ID INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL  order by DDZ.ID desc"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelDDZ.setObservacao(this.getResultSet().getString(1));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(2));
                modelDDZ.setTurno(this.getResultSet().getString(3));
                modelDDZ.setDesc_problema(this.getResultSet().getString(4));
                modelDDZ.setDesc_causa(this.getResultSet().getString(5));
                modelDDZ.setLinha(this.getResultSet().getString(6));
                modelDDZ.setMaterial(this.getResultSet().getInt(7));
                modelDDZ.setBpcs(this.getResultSet().getString(8));
                modelDDZ.setDesc_material(this.getResultSet().getString(9));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelDDZ;
    }

    public ModelDDZ getAcaoDAO(int id) {
        ModelDDZ modelDDZ = new ModelDDZ();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG,"
                    + "DATA_PRAZO,"
                    + "RESPONSAVEL,"
                    + "DATA_CONCLUIDO,"
                    + "DATA_PLANO,"
                    + "STATUS,"
                    + "MAT_LINHA,"
                    + "ID_M_MATERIAL,"
                    + "PRIORIDADE,"
                    + "PARTICIPANTES"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID INNER JOIN DDZ DDZ ON Causas.ID = DDZ.ID_CAUSA_ID INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL where id_causa_id <> 59 and DDZ.ID = '" + id + "' order by DDZ.ID ASC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelDDZ.setId(this.getResultSet().getLong(1));
                modelDDZ.setData(this.getResultSet().getTimestamp(2));
                modelDDZ.setHora(this.getResultSet().getTimestamp(3));
                modelDDZ.setMaterial(this.getResultSet().getInt(4));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(5));
                modelDDZ.setQtd_scrap_reais(this.getResultSet().getFloat(6));
                modelDDZ.setAcao_tomada(this.getResultSet().getString(7));
                modelDDZ.setDesc_problema(this.getResultSet().getString(8));
                modelDDZ.setDesc_causa(this.getResultSet().getString(9));
                modelDDZ.setObservacao(this.getResultSet().getString(10));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(11));
                modelDDZ.setData_prazo(this.getResultSet().getString(12));
                modelDDZ.setResponsavel(this.getResultSet().getString(13));
                modelDDZ.setData_conclusao(this.getResultSet().getString(14));
                modelDDZ.setData_plano(this.getResultSet().getString(15));
                modelDDZ.setStatus(this.getResultSet().getString(16));
                modelDDZ.setLinha(this.getResultSet().getString(17));
                modelDDZ.setId_material(this.getResultSet().getInt(18));
                modelDDZ.setPrioridade(this.getResultSet().getInt(19));
                modelDDZ.setParticipantes(this.getResultSet().getString(20));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelDDZ;
    }

    public ArrayList<ModelDDZ> getListaDDZDAO(String perfil) {
        ArrayList<ModelDDZ> listaDDZ = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG"
                    + " FROM Problemas"
                    + " INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID"
                    + " INNER JOIN vw_ddz_datahora DDZ ON Causas.ID = DDZ.ID_CAUSA_ID"
                    + " INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL"
                    + " WHERE"
                    + " MATERIAL = '" + perfil + "'"
                    + " AND data_hora_input >= (SELECT MAX(data_hora_input) FROM vw_ddz_datahora WHERE id_causa_id = 34 AND ID_M_MATERIAL= '" + perfil + "')"
                    + " order by data_hora_input ASC"
            );
            while (this.getResultSet().next()) {
                ModelDDZ modelDDZ = new ModelDDZ();
                modelDDZ.setId(this.getResultSet().getLong(1));
                modelDDZ.setData(this.getResultSet().getTimestamp(2));
                modelDDZ.setHora(this.getResultSet().getTimestamp(3));
                modelDDZ.setMaterial(this.getResultSet().getInt(4));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(5));
                modelDDZ.setQtd_scrap_reais(this.getResultSet().getFloat(6));
                modelDDZ.setAcao_tomada(this.getResultSet().getString(7));
                modelDDZ.setDesc_problema(this.getResultSet().getString(8));
                modelDDZ.setDesc_causa(this.getResultSet().getString(9));
                modelDDZ.setObservacao(this.getResultSet().getString(10));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(11));
                listaDDZ.add(modelDDZ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaDDZ;
    }

    public ArrayList<ModelDDZ> getListaDDZEditDAO(String perfil, int idcontrole) {
        ArrayList<ModelDDZ> listaDDZ = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG"
                    + " FROM Problemas"
                    + " INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID"
                    + " INNER JOIN vw_ddz_datahora DDZ ON Causas.ID = DDZ.ID_CAUSA_ID"
                    + " INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL"
                    + " WHERE"
                    + " MATERIAL = '" + perfil + "'"
                    + " AND ID_CONTROLE ='" + idcontrole + "'"
                    + " order by data_hora_input ASC"
            );
            while (this.getResultSet().next()) {
                ModelDDZ modelDDZ = new ModelDDZ();
                modelDDZ.setId(this.getResultSet().getLong(1));
                modelDDZ.setData(this.getResultSet().getTimestamp(2));
                modelDDZ.setHora(this.getResultSet().getTimestamp(3));
                modelDDZ.setMaterial(this.getResultSet().getInt(4));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(5));
                modelDDZ.setQtd_scrap_reais(this.getResultSet().getFloat(6));
                modelDDZ.setAcao_tomada(this.getResultSet().getString(7));
                modelDDZ.setDesc_problema(this.getResultSet().getString(8));
                modelDDZ.setDesc_causa(this.getResultSet().getString(9));
                modelDDZ.setObservacao(this.getResultSet().getString(10));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(11));
                listaDDZ.add(modelDDZ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaDDZ;
    }

    public ArrayList<ModelDDZ> getListaAcaoDDZDAO() {
        ArrayList<ModelDDZ> listaDDZ = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG,"
                    + "DATA_PRAZO,"
                    + "RESPONSAVEL,"
                    + "DATA_CONCLUIDO,"
                    + "DATA_PLANO,"
                    + "STATUS,"
                    + "MAT_LINHA,"
                    + "ID_M_MATERIAL,"
                    + "PRIORIDADE,"
                    + "AVALIACAO"
                    + " FROM"
                    + " Problemas INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID INNER JOIN DDZ DDZ ON Causas.ID = DDZ.ID_CAUSA_ID INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL where id_causa_id <> 59 and ACAO_TOMADA <> '' and DATA_PLANO <> '' and AVALIACAO = 'Pendente' order by DDZ.ID ASC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                ModelDDZ modelDDZ = new ModelDDZ();
                modelDDZ.setId(this.getResultSet().getLong(1));
                modelDDZ.setData(this.getResultSet().getTimestamp(2));
                modelDDZ.setHora(this.getResultSet().getTimestamp(3));
                modelDDZ.setMaterial(this.getResultSet().getInt(4));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(5));
                modelDDZ.setQtd_scrap_reais(this.getResultSet().getFloat(6));
                modelDDZ.setAcao_tomada(this.getResultSet().getString(7));
                modelDDZ.setDesc_problema(this.getResultSet().getString(8));
                modelDDZ.setDesc_causa(this.getResultSet().getString(9));
                modelDDZ.setObservacao(this.getResultSet().getString(10));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(11));
                modelDDZ.setData_prazo(this.getResultSet().getString(12));
                modelDDZ.setResponsavel(this.getResultSet().getString(13));
                modelDDZ.setData_conclusao(this.getResultSet().getString(14));
                modelDDZ.setData_plano(this.getResultSet().getString(15));
                modelDDZ.setStatus(this.getResultSet().getString(16));
                modelDDZ.setLinha(this.getResultSet().getString(17));
                modelDDZ.setId_material(this.getResultSet().getInt(18));
                modelDDZ.setPrioridade(this.getResultSet().getInt(19));
                modelDDZ.setAvaliacao(this.getResultSet().getString(20));
                listaDDZ.add(modelDDZ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaDDZ;
    }

    public ArrayList<ModelDDZ> getListaAcaoDDZDAO(String perfil, double onehour, double fourhour) {
        ArrayList<ModelDDZ> listaDDZ = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM("
                    + " SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG"
                    + " FROM "
                    + "Problemas INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID INNER JOIN DDZ DDZ ON Causas.ID = DDZ.ID_CAUSA_ID "
                    + "INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL where MATERIAL = '" + perfil + "' and id_causa_id <> 59 and ACAO_TOMADA = '' and QTD_SCRAP > '" + fourhour + "' and FLAG <> 'E'"
                    + " UNION "
                    + " SELECT "
                    + "DDZ.ID,"
                    + "DATA_INPUT,"
                    + "HORA_INPUT,"
                    + "MATERIAL,"
                    + "QTD_SCRAP,"
                    + "QTD_SCRAP_REAIS,"
                    + "ACAO_TOMADA,"
                    + "DESC_PROBLEMA,"
                    + "DESC_CAUSA,"
                    + "DDZ.OBSERVACAO,"
                    + "QTD_SCRAP_KG"
                    + " FROM "
                    + "Problemas INNER JOIN Causas ON Problemas.ID = Causas.ID_PROBLEMA_ID INNER JOIN DDZ DDZ ON Causas.ID = DDZ.ID_CAUSA_ID "
                    + "INNER JOIN Cad_Material ON DDZ.ID_M_MATERIAL = MATERIAL where MATERIAL = '" + perfil + "' and id_causa_id <> 59 and ACAO_TOMADA = '' and QTD_SCRAP > '" + onehour + "' and FLAG = 'E') as tb order by tb.ID ASC"
            );
            while (this.getResultSet().next()) {
                ModelDDZ modelDDZ = new ModelDDZ();
                modelDDZ.setId(this.getResultSet().getLong(1));
                modelDDZ.setData(this.getResultSet().getTimestamp(2));
                modelDDZ.setHora(this.getResultSet().getTimestamp(3));
                modelDDZ.setMaterial(this.getResultSet().getInt(4));
                modelDDZ.setQtd_scrap(this.getResultSet().getFloat(5));
                modelDDZ.setQtd_scrap_reais(this.getResultSet().getFloat(6));
                modelDDZ.setAcao_tomada(this.getResultSet().getString(7));
                modelDDZ.setDesc_problema(this.getResultSet().getString(8));
                modelDDZ.setDesc_causa(this.getResultSet().getString(9));
                modelDDZ.setObservacao(this.getResultSet().getString(10));
                modelDDZ.setQtd_scrap_kg(this.getResultSet().getFloat(11));
                listaDDZ.add(modelDDZ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaDDZ;
    }

    public boolean atualizarDDZDAO(ModelDDZ pModelDDZ) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE DDZ SET "
                    + " ID_CAUSA_ID= '" + pModelDDZ.getId_causa() + "',"
                    + " OBSERVACAO= '" + pModelDDZ.getObservacao() + "'"
                    + " WHERE "
                    + " ID= '" + pModelDDZ.getId() + "'"
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

    public boolean atualizaAcaoDAO(ModelDDZ pModelDDZ) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE DDZ SET "
                    + " ACAO_TOMADA= '" + pModelDDZ.getAcao_tomada() + "',"
                    + " PRIORIDADE= '" + pModelDDZ.getPrioridade() + "',"
                    + " PARTICIPANTES= '" + pModelDDZ.getParticipantes() + "',"
                    + " RESPONSAVEL= '" + pModelDDZ.getResponsavel() + "',"
                    + " DATA_PLANO= '" + pModelDDZ.getData_plano() + "',"
                    + " STATUS= '" + pModelDDZ.getStatus() + "',"
                    + " AVALIACAO= '" + pModelDDZ.getAvaliacao() + "'"
                    + " WHERE "
                    + " ID= '" + pModelDDZ.getId() + "'"
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

    public boolean excluirDDZDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM DDZ "
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
