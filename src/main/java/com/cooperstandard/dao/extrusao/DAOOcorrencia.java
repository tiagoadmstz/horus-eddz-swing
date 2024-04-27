package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelOcorrencia;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOOcorrencia extends ConexaoSql {

    public int salvarOcorrenciaDAO(ModelOcorrencia pModelOcorrencia) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Ocorrencia ("
                    + "OCORRENCIA"
                    + ") VALUES ("
                    + "'" + pModelOcorrencia.getDesc() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            this.fecharConexao();
        }

    }

    public ModelOcorrencia getOcorrenciaDAO(long pCodigo) {
        ModelOcorrencia modelOcorrencia = new ModelOcorrencia();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "OCORRENCIA"
                    + "FROM "
                    + "Ocorrencia"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelOcorrencia.setId(this.getResultSet().getLong(1));
                modelOcorrencia.setDesc(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOcorrencia;
    }

    public ModelOcorrencia getOcorrenciaDAO(String pNome) {
        ModelOcorrencia modelOcorrencia = new ModelOcorrencia();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "OCORRENCIA"
                    + " FROM "
                    + "Ocorrencia"
                    + " WHERE"
                    + " OCORRENCIA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelOcorrencia.setId(this.getResultSet().getLong(1));
                modelOcorrencia.setDesc(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOcorrencia;
    }

    public ArrayList<ModelOcorrencia> getListaOcorrenciaDAO() {
        ArrayList<ModelOcorrencia> listaOcorrencia = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "OCORRENCIA"
                    + " FROM"
                    + " Ocorrencia ORDER BY ID"
                    + ";"
            );

            while (this.getResultSet().next()) {
                ModelOcorrencia modelOcorrencia = new ModelOcorrencia();
                modelOcorrencia.setId(this.getResultSet().getLong(1));
                modelOcorrencia.setDesc(this.getResultSet().getString(2));

                listaOcorrencia.add(modelOcorrencia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaOcorrencia;
    }

    public boolean atualizarOcorrenciaDAO(ModelOcorrencia pModelOcorrencia) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Ocorrencia SET "
                    + " OCORRENCIA= '" + pModelOcorrencia.getDesc() + "'"
                    + " WHERE "
                    + "ID = '" + pModelOcorrencia.getId() + "'"
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

    public boolean excluirOcorrenciaDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Ocorrencia "
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
