package com.cooperstandard.dao.pontoinsp;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelResultInsp;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOResultInsp extends ConexaoSql {

    public int salvarResultInspDAO(ModelResultInsp pModelResultInsp) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_ResultadoInsp ("
                    + "DATA_REGISTRO,"
                    + "ANALISTA,"
                    + "TIPO,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "STATUS,"
                    + "OBS,"
                    + "ID_ESPECIFICACAO_ID,"
                    + "RECONHECIMENTO,"
                    + "APROVADOR,"
                    + "ID_CONTROLE"
                    + ") VALUES ("
                    + "'" + pModelResultInsp.getData_registro() + "',"
                    + "'" + pModelResultInsp.getAnalista() + "',"
                    + "'" + pModelResultInsp.getTipo() + "',"
                    + "'" + pModelResultInsp.getResultado_texto() + "',"
                    + "'" + pModelResultInsp.getResultado_num() + "',"
                    + "'" + pModelResultInsp.getStatus() + "',"
                    + "'" + pModelResultInsp.getObs() + "',"
                    + "'" + pModelResultInsp.getId_espec_id() + "',"
                    + "'" + pModelResultInsp.getReconhecimento() + "',"
                    + "'" + pModelResultInsp.getAprovador() + "',"
                    + "'" + pModelResultInsp.getId_controle() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelResultInsp getResultInspDAO(int pCodigo) {
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DATA_REGISTRO,"
                    + "SOLICITANTE,"
                    + "ANALISTA,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "TIPO,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "STATUS,"
                    + "OBS,"
                    + "ID_ESPECIFICACAO_ID"
                    + "FROM "
                    + "Cad_ResultadoInsp"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(2));
                modelResultInsp.setSolicitante(this.getResultSet().getString(3));
                modelResultInsp.setAnalista(this.getResultSet().getInt(4));
                modelResultInsp.setData_jet(this.getResultSet().getString(5));
                modelResultInsp.setHora_jet(this.getResultSet().getString(6));
                modelResultInsp.setTipo(this.getResultSet().getString(7));
                modelResultInsp.setResultado_texto(this.getResultSet().getString(8));
                modelResultInsp.setResultado_num(this.getResultSet().getFloat(9));
                modelResultInsp.setStatus(this.getResultSet().getString(10));
                modelResultInsp.setObs(this.getResultSet().getString(11));
                modelResultInsp.setId_espec_id(this.getResultSet().getInt(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelResultInsp;
    }

    public ModelResultInsp getResultInspDAO(String pNome) {
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DATA_REGISTRO,"
                    + "SOLICITANTE,"
                    + "ANALISTA,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "TIPO,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "STATUS,"
                    + "OBS,"
                    + "ID_ESPECIFICACAO_ID"
                    + "FROM "
                    + "Cad_Material"
                    + " WHERE"
                    + " ID= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(2));
                modelResultInsp.setSolicitante(this.getResultSet().getString(3));
                modelResultInsp.setAnalista(this.getResultSet().getInt(4));
                modelResultInsp.setData_jet(this.getResultSet().getString(5));
                modelResultInsp.setHora_jet(this.getResultSet().getString(6));
                modelResultInsp.setTipo(this.getResultSet().getString(7));
                modelResultInsp.setResultado_texto(this.getResultSet().getString(8));
                modelResultInsp.setResultado_num(this.getResultSet().getFloat(9));
                modelResultInsp.setStatus(this.getResultSet().getString(10));
                modelResultInsp.setObs(this.getResultSet().getString(11));
                modelResultInsp.setId_espec_id(this.getResultSet().getInt(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaResultInspDAO() {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DATA_REGISTRO,"
                    + "SOLICITANTE,"
                    + "ANALISTA,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "TIPO,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "STATUS,"
                    + "OBS,"
                    + "ID_ESPECIFICACAO_ID"
                    + " FROM"
                    + " Cad_ResultadoInsp"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(2));
                modelResultInsp.setSolicitante(this.getResultSet().getString(3));
                modelResultInsp.setAnalista(this.getResultSet().getInt(4));
                modelResultInsp.setData_jet(this.getResultSet().getString(5));
                modelResultInsp.setHora_jet(this.getResultSet().getString(6));
                modelResultInsp.setTipo(this.getResultSet().getString(7));
                modelResultInsp.setResultado_texto(this.getResultSet().getString(8));
                modelResultInsp.setResultado_num(this.getResultSet().getFloat(9));
                modelResultInsp.setStatus(this.getResultSet().getString(10));
                modelResultInsp.setObs(this.getResultSet().getString(11));
                modelResultInsp.setId_espec_id(this.getResultSet().getInt(12));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaStatusResultInspDAO() {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    " SELECT DISTINCT TOP (10) "
                    + "PERFIL,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "NOME,"
                    + "DATA_BASE "
                    + " FROM "
                    + "INSP_Controle INNER JOIN Cad_ResultadoInsp ON INSP_Controle.ID = Cad_ResultadoInsp.ID_CONTROLE "
                    + "INNER JOIN Cad_Usuario u ON u.PK_ID= Cad_ResultadoInsp.ANALISTA "
                    + " WHERE INSP_Controle.STATUS = 'Aprovado' or INSP_Controle.STATUS = 'Reprovado' "
                    + " order by CONVERT(DATETIME, DATA_BASE, 103) DESC "
            );
            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId_material_id(this.getResultSet().getInt(1));
                modelResultInsp.setData_jet(this.getResultSet().getString(2));
                modelResultInsp.setHora_jet(this.getResultSet().getString(3));
                modelResultInsp.setUsuario(this.getResultSet().getString(4));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaResultadoInspDataDAO(String dataini, String datafim) {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "i.DATA_JET,"
                    + "i.HORA_JET,"
                    + "ID_MATERIAL_ID,"
                    + "NOME"
                    + " FROM"
                    + " Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID"
                    + " INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = ID_ESPECIFICACAO_ID"
                    + " INNER JOIN INSP_Controle i ON Cad_ResultadoInsp.ID_CONTROLE = i.ID"
                    + " INNER JOIN Cad_Usuario ON ANALISTA = PK_ID"
                    + " WHERE CONVERT(date, DATA_REGISTRO, 101) BETWEEN '" + dataini + "' AND '" + datafim + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelResultInsp.setData_jet(this.getResultSet().getString(1));
                modelResultInsp.setHora_jet(this.getResultSet().getString(2));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(3));
                modelResultInsp.setNome(this.getResultSet().getString(4));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaUltimoRegistroDataDAO(String dataini, String datafim) {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "Cad_ResultadoInsp.ID as ID,"
                    + "ID_MATERIAL_ID,"
                    + "i.DATA_JET,"
                    + "i.HORA_JET,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "STATUS,"
                    + "OBS,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "NOME,"
                    + "DESC_TESTE,"
                    + "Cad_Teste.ORDEM AS ORDEM,"
                    + "ESPEC_COMPLETO"
                    + " FROM"
                    + " Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID"
                    + " INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = ID_ESPECIFICACAO_ID"
                    + " INNER JOIN INSP_Controle i ON Cad_ResultadoInsp.ID_CONTROLE = i.ID"
                    + " INNER JOIN Cad_Usuario ON ANALISTA = PK_ID"
                    + " WHERE CONVERT(date, DATA_REGISTRO, 101) BETWEEN '" + dataini + "' AND '" + datafim + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(2));
                modelResultInsp.setData_jet(this.getResultSet().getString(3));
                modelResultInsp.setHora_jet(this.getResultSet().getString(4));
                modelResultInsp.setResultado_texto(this.getResultSet().getString(5));
                modelResultInsp.setResultado_num(this.getResultSet().getFloat(6));
                modelResultInsp.setStatus(this.getResultSet().getString(7));
                modelResultInsp.setObs(this.getResultSet().getString(8));
                modelResultInsp.setTipo(this.getResultSet().getString(9));
                modelResultInsp.setComplemento(this.getResultSet().getString(10));
                modelResultInsp.setMin(this.getResultSet().getFloat(11));
                modelResultInsp.setMax(this.getResultSet().getFloat(12));
                modelResultInsp.setTexto(this.getResultSet().getString(13));
                modelResultInsp.setReferencia(this.getResultSet().getString(14));
                modelResultInsp.setNome(this.getResultSet().getString(15));
                modelResultInsp.setDesc_teste(this.getResultSet().getString(16));
                modelResultInsp.setOrdem(this.getResultSet().getString(17));
                modelResultInsp.setEspec_completo(this.getResultSet().getString(18));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaUltimoRegistroDAO() {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT TOP (100) "
                    + "Cad_ResultadoInsp.ID_CONTROLE,"
                    + "PERFIL,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "NOME,"
                    + "DATA_BASE"
                    + " FROM "
                    + " INSP_Controle INNER JOIN Cad_ResultadoInsp ON INSP_Controle.ID = Cad_ResultadoInsp.ID_CONTROLE "
                    + " INNER JOIN Cad_Usuario u ON u.PK_ID= Cad_ResultadoInsp.ANALISTA"
                    + " WHERE INSP_Controle.STATUS = 'Aprovado' or INSP_Controle.STATUS = 'Reprovado' "
                    + " order by CONVERT(DATETIME, DATA_BASE, 103) DESC"
            );

            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId_controle(this.getResultSet().getInt(1));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(2));
                modelResultInsp.setData_jet(this.getResultSet().getString(3));
                modelResultInsp.setHora_jet(this.getResultSet().getString(4));
                modelResultInsp.setUsuario(this.getResultSet().getString(5));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(6));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaUltimoRegistroRetesteDAO() {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "Cad_ResultadoInsp.ID_CONTROLE,"
                    + "PERFIL,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "NOME,"
                    + "DATA_BASE"
                    + " FROM "
                    + " INSP_Controle INNER JOIN Cad_ResultadoInsp ON INSP_Controle.ID = Cad_ResultadoInsp.ID_CONTROLE "
                    + " INNER JOIN Cad_Usuario u ON u.PK_ID= Cad_ResultadoInsp.ANALISTA"
                    + " WHERE Cad_ResultadoInsp.TIPO = 'Re-Teste'   order by DATA_JET ASC, HORA_JET DESC "
            );

            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId_controle(this.getResultSet().getInt(1));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(2));
                modelResultInsp.setData_jet(this.getResultSet().getString(3));
                modelResultInsp.setHora_jet(this.getResultSet().getString(4));
                modelResultInsp.setUsuario(this.getResultSet().getString(5));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(6));
                listaResultInsp.add(modelResultInsp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaResultadoLabDAO(String linha, String dataini, String datafim) {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "Cad_ResultadoInsp.ID,"
                    + "DESC_TESTE,"
                    + "Cad_EspecLab.ID_MATERIAL_ID AS ID_MATERIAL_ID,"
                    + "ESPEC_COMPLETO,"
                    + "INSP_Controle.DATA_JET,"
                    + "INSP_Controle.HORA_JET,"
                    + "RESULTADO_TEXTO,"
                    + "RESULTADO_NUM,"
                    + "DESC_MATERIAL,"
                    + "STATUS,"
                    + "DATA_REGISTRO,"
                    + "Cad_ResultadoInsp.TIPO AS TIPO,"
                    + "Cad_EspecLab.TIPO_ESPEC AS TIPO_ESPEC,"
                    + "Cad_EspecLab.OBSERVACAO AS OBSERVACAO,"
                    + "OBS"
                    + " FROM "
                    + "Cad_EspecLab INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = Cad_ResultadoInsp.ID_ESPECIFICACAO_ID "
                    + " INNER JOIN Cad_Teste ON ID_TESTE_ID = COD_TESTE "
                    + " INNER JOIN Cad_Material ON ID_MATERIAL_ID = MATERIAL "
                    + " INNER JOIN INSP_Controle  ON ID_CONTROLE = INSP_Controle.ID"
                    + " AND MAT_LINHA LIKE '%" + linha + "%' and RECONHECIMENTO = ''"
            );
            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setDesc_teste(this.getResultSet().getString(2));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(3));
                modelResultInsp.setEspec_completo(this.getResultSet().getString(4));
                modelResultInsp.setData_jet(this.getResultSet().getString(5));
                modelResultInsp.setHora_jet(this.getResultSet().getString(6));
                modelResultInsp.setResultado_texto(this.getResultSet().getString(7));
                modelResultInsp.setResultado_num(this.getResultSet().getFloat(8));
                modelResultInsp.setDesc_material(this.getResultSet().getString(9));
                modelResultInsp.setStatus(this.getResultSet().getString(10));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(11));
                modelResultInsp.setTipo(this.getResultSet().getString(12));
                modelResultInsp.setTipo_espec(this.getResultSet().getString(13));
                modelResultInsp.setObservacao(this.getResultSet().getString(14));
                modelResultInsp.setObs(this.getResultSet().getString(15));
                listaResultInsp.add(modelResultInsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaResultInsp;
    }

    public ArrayList<ModelResultInsp> getListaEmAbertoDAO() {
        ArrayList<ModelResultInsp> listaResultInsp = new ArrayList();
        ModelResultInsp modelResultInsp = new ModelResultInsp();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "INSP_Controle.ID,"
                    + "PERFIL,"
                    + "SOLICITANTE,"
                    + "DATA_JET,"
                    + "HORA_JET,"
                    + "DATA_BASE,"
                    + "TIPO,"
                    + "INSP_Controle.STATUS"
                    + " FROM "
                    + " INSP_Controle INNER JOIN Cad_ResultadoInsp ON INSP_Controle.ID = Cad_ResultadoInsp.ID_CONTROLE where INSP_Controle.STATUS is null or INSP_Controle.STATUS = 'Pendente' or Cad_ResultadoInsp.STATUS is null or Cad_ResultadoInsp.STATUS = '' ORDER BY DATA_BASE DESC"
            );
            while (this.getResultSet().next()) {
                modelResultInsp = new ModelResultInsp();
                modelResultInsp.setId(this.getResultSet().getInt(1));
                modelResultInsp.setId_material_id(this.getResultSet().getInt(2));
                modelResultInsp.setSolicitante(this.getResultSet().getString(3));
                modelResultInsp.setData_jet(this.getResultSet().getString(4));
                modelResultInsp.setHora_jet(this.getResultSet().getString(5));
                modelResultInsp.setData_registro(this.getResultSet().getTimestamp(6));
                modelResultInsp.setTipo(this.getResultSet().getString(7));
                modelResultInsp.setStatus(this.getResultSet().getString(8));
                listaResultInsp.add(modelResultInsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaResultInsp;
    }

    public boolean atualizarResultInspDAO(ModelResultInsp pModelResultInsp) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_ResultadoInsp SET "
                    + " RESULTADO_TEXTO= '" + pModelResultInsp.getResultado_texto() + "',"
                    + " RESULTADO_NUM= '" + pModelResultInsp.getResultado_num() + "',"
                    + " STATUS= '" + pModelResultInsp.getStatus() + "',"
                    + " OBS= '" + pModelResultInsp.getObs() + "',"
                    + " RECONHECIMENTO= '" + pModelResultInsp.getReconhecimento() + "',"
                    + " APROVADOR= '" + pModelResultInsp.getAprovador() + "'"
                    + " WHERE "
                    + " ID= '" + pModelResultInsp.getId() + "'"
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

    public boolean updateResultadoInspDAO(ModelResultInsp pModelResultInsp) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_ResultadoInsp SET "
                    + " RESULTADO_TEXTO= '" + pModelResultInsp.getResultado_texto() + "',"
                    + " RESULTADO_NUM= '" + pModelResultInsp.getResultado_num() + "',"
                    + " STATUS= '" + pModelResultInsp.getStatus() + "',"
                    + " OBS= '" + pModelResultInsp.getObs() + "'"
                    + " WHERE "
                    + " ID= '" + pModelResultInsp.getId() + "'"
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

    public boolean atualizarResultLabDAO(ModelResultInsp pModelResultInsp) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_ResultadoInsp SET "
                    + " RECONHECIMENTO= '" + pModelResultInsp.getReconhecimento() + "',"
                    + " APROVADOR= '" + pModelResultInsp.getAprovador() + "'"
                    + " WHERE "
                    + " ID= '" + pModelResultInsp.getId() + "'"
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

    public boolean excluirResultInspDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_ResultadoInsp "
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
