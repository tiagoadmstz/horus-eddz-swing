package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelProblema;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOProblema extends ConexaoSql {

    public int salvarProblemasDAO(ModelProblema pModelModelProblema) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Problemas ("
                    + "DESC_PROBLEMA"
                    + ") VALUES ("
                    + "'" + pModelModelProblema.getDesc_problema() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelProblema getProblemasDAO(int pCodigo) {
        ModelProblema modelProblema = new ModelProblema();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "CAD_CAUSA"
                    + "FROM "
                    + "Problemas"
                    + " WHERE"
                    + " ID= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelProblema.setId(this.getResultSet().getInt(1));
                modelProblema.setDesc_problema(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProblema;
    }

    public ModelProblema getProblemasDAO(String pNome) {
        ModelProblema modelProblema = new ModelProblema();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_PROBLEMA"
                    + "FROM "
                    + "Problemas"
                    + " WHERE"
                    + " DESC_PROBLEMA= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelProblema.setId(this.getResultSet().getInt(1));
                modelProblema.setDesc_problema(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProblema;
    }

    public ArrayList<ModelProblema> getListaProblemasDAO() {
        ArrayList<ModelProblema> listaProblemas = new ArrayList();
        ModelProblema modelProblema = new ModelProblema();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DESC_PROBLEMA"
                    + " FROM"
                    + " Problemas where id != '51' order by DESC_PROBLEMA ASC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProblema = new ModelProblema();
                modelProblema.setId(this.getResultSet().getInt(1));
                modelProblema.setDesc_problema(this.getResultSet().getString(2));

                listaProblemas.add(modelProblema);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProblemas;
    }

    public boolean atualizarProblemasDAO(ModelProblema pModelProblemas) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Problemas SET "
                    + " DESC_PROBLEMA= '" + pModelProblemas.getDesc_problema() + "'"
                    + " WHERE "
                    + " ID= '" + pModelProblemas.getId() + "'"
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

    public boolean excluirProblemasDAO(long pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Problemas "
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
