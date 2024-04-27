package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelAtividade;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOAtividade extends ConexaoSql {

    public int salvarAtividadeDAO(ModelAtividade pModelModelAtividade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Atividade ("
                    + "ID_CONTROLE,"
                    + "DATA_A,"
                    + "SOLICITANTE,"
                    + "OCORRENCIA,"
                    + "OBS_SOLICITACAO,"
                    + "FLAG"
                    + ") VALUES ("
                    + "'" + pModelModelAtividade.getId_controle() + "',"
                    + "'" + pModelModelAtividade.getData_a() + "',"
                    + "'" + pModelModelAtividade.getSolicitante() + "',"
                    + "'" + pModelModelAtividade.getOcorrencia() + "',"
                    + "'" + pModelModelAtividade.getObs_solicitacao() + "',"
                    + "'" + pModelModelAtividade.getFlag() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelAtividade getAtividadeDAO(long pCodigo) {
        ModelAtividade modelAtividade = new ModelAtividade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "Atividade.ID,"
                    + "DATA_A,"
                    + "SOLICITANTE,"
                    + "OCORRENCIA,"
                    + "OBS_SOLICITACAO,"
                    + "MATRIZEIRO,"
                    + "OBS_MANUTENCAO,"
                    + "DATA_F,"
                    + "ID_PERFIL,"
                    + "MATRIZ,"
                    + "BPCS,"
                    + "MAT_LINHA"
                    + " FROM"
                    + " Qry_MTZ"
                    + " WHERE Atividade.ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelAtividade.setId(this.getResultSet().getInt(1));
                modelAtividade.setData_a(this.getResultSet().getTimestamp(2));
                modelAtividade.setSolicitante(this.getResultSet().getString(3));
                modelAtividade.setOcorrencia(this.getResultSet().getString(4));
                modelAtividade.setObs_solicitacao(this.getResultSet().getString(5));
                modelAtividade.setMatrizeiro(this.getResultSet().getString(6));
                modelAtividade.setObs_manutencao(this.getResultSet().getString(7));
                modelAtividade.setData_f(this.getResultSet().getTimestamp(8));
                modelAtividade.setPerfil(this.getResultSet().getInt(9));
                modelAtividade.setMatriz(this.getResultSet().getString(10));
                modelAtividade.setBpcs(this.getResultSet().getString(11));
                modelAtividade.setLinha(this.getResultSet().getString(12));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelAtividade;
    }

    public ModelAtividade getAtividadeDAO(String pNome) {
        ModelAtividade modelAtividade = new ModelAtividade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "Atividade.ID,"
                    + "DATA_A,"
                    + "SOLICITANTE,"
                    + "OCORRENCIA,"
                    + "OBS_SOLICITACAO,"
                    + "MATRIZEIRO,"
                    + "OBS_MANUTENCAO,"
                    + "DATA_F,"
                    + "ID_PERFIL,"
                    + "MATRIZ,"
                    + "BPCS,"
                    + "MAT_LINHA"
                    + " FROM"
                    + " Qry_MTZ"
                    + " WHERE MATRIZ= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelAtividade.setId(this.getResultSet().getInt(1));
                modelAtividade.setData_a(this.getResultSet().getTimestamp(2));
                modelAtividade.setSolicitante(this.getResultSet().getString(3));
                modelAtividade.setOcorrencia(this.getResultSet().getString(4));
                modelAtividade.setObs_solicitacao(this.getResultSet().getString(5));
                modelAtividade.setMatrizeiro(this.getResultSet().getString(6));
                modelAtividade.setObs_manutencao(this.getResultSet().getString(7));
                modelAtividade.setData_f(this.getResultSet().getTimestamp(8));
                modelAtividade.setPerfil(this.getResultSet().getInt(9));
                modelAtividade.setMatriz(this.getResultSet().getString(10));
                modelAtividade.setBpcs(this.getResultSet().getString(11));
                modelAtividade.setLinha(this.getResultSet().getString(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelAtividade;
    }

    public ArrayList<ModelAtividade> getListaAtividadeDAO() {
        ArrayList<ModelAtividade> listaAtividade = new ArrayList();
        ModelAtividade modelAtividade = new ModelAtividade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "Atividade.ID,"
                    + "DATA_A,"
                    + "SOLICITANTE,"
                    + "OCORRENCIA,"
                    + "OBS_SOLICITACAO,"
                    + "MATRIZEIRO,"
                    + "OBS_MANUTENCAO,"
                    + "DATA_F,"
                    + "ID_PERFIL,"
                    + "MATRIZ,"
                    + "BPCS,"
                    + "MAT_LINHA"
                    + " FROM"
                    + " Qry_MTZ"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelAtividade = new ModelAtividade();
                modelAtividade.setId(this.getResultSet().getInt(1));
                modelAtividade.setData_a(this.getResultSet().getTimestamp(2));
                modelAtividade.setSolicitante(this.getResultSet().getString(3));
                modelAtividade.setOcorrencia(this.getResultSet().getString(4));
                modelAtividade.setObs_solicitacao(this.getResultSet().getString(5));
                modelAtividade.setMatrizeiro(this.getResultSet().getString(6));
                modelAtividade.setObs_manutencao(this.getResultSet().getString(7));
                modelAtividade.setData_f(this.getResultSet().getTimestamp(8));
                modelAtividade.setPerfil(this.getResultSet().getInt(9));
                modelAtividade.setMatriz(this.getResultSet().getString(10));
                modelAtividade.setBpcs(this.getResultSet().getString(11));
                modelAtividade.setLinha(this.getResultSet().getString(12));

                listaAtividade.add(modelAtividade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaAtividade;
    }

    public boolean atualizarAtividadeDAO(ModelAtividade pModelAtividade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Atividade SET "
                    + " MATRIZEIRO= '" + pModelAtividade.getMatrizeiro() + "',"
                    + " OBS_MANUTENCAO= '" + pModelAtividade.getObs_manutencao() + "',"
                    + " DATA_F= '" + pModelAtividade.getData_f() + "'"
                    + " WHERE "
                    + " ID= '" + pModelAtividade.getId() + "'"
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

    public boolean excluirAtividadeDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Atividade "
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
