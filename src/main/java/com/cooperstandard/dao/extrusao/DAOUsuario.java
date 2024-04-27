package com.cooperstandard.dao.extrusao;

import java.util.ArrayList;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelUsuario;

/**
 *
 * @author Rafael
 */
public class DAOUsuario extends ConexaoSql {

    /**
     * grava Usuario
     *
     * @param pModelUsuario return int
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Usuario ("
                    + "NOME,"
                    + "LOGIN,"
                    + "SENHA,"
                    + "SETOR,"
                    + "SOBRE_NOME,"
                    + "PLANTA,"
                    + "EMAIL"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getNome() + "',"
                    + "'" + pModelUsuario.getLogin() + "',"
                    + "'" + pModelUsuario.getSenha() + "',"
                    + "'" + pModelUsuario.getSetor() + "',"
                    + "'" + pModelUsuario.getSobrenome() + "',"
                    + "'" + pModelUsuario.getPlanta() + "',"
                    + "'" + pModelUsuario.getEmail() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Usuario
     *
     * @param pCodigo return ModelUsuario
     */
    public ModelUsuario getUsuarioDAO(int pCodigo) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "PK_ID,"
                    + "NOME,"
                    + "LOGIN,"
                    + "SENHA,"
                    + "SETOR,"
                    + "SOBRE_NOME,"
                    + "PLANTA,"
                    + "EMAIL"
                    + " FROM"
                    + " Cad_Usuario"
                    + " WHERE"
                    + "  PK_ID= '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                modelUsuario.setSetor(this.getResultSet().getString(5));
                modelUsuario.setSobrenome(this.getResultSet().getString(6));
                modelUsuario.setPlanta(this.getResultSet().getString(7));
                modelUsuario.setEmail(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera Usuario
     *
     * @param pLogin return ModelUsuario
     */
    public ModelUsuario getUsuarioDAO(String pLogin) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "PK_ID,"
                    + "NOME,"
                    + "LOGIN,"
                    + "SENHA,"
                    + "SETOR,"
                    + "SOBRE_NOME,"
                    + "PLANTA,"
                    + "EMAIL"
                    + " FROM"
                    + " Cad_Usuario"
                    + " WHERE"
                    + "  LOGIN= '" + pLogin + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                modelUsuario.setSetor(this.getResultSet().getString(5));
                modelUsuario.setSobrenome(this.getResultSet().getString(6));
                modelUsuario.setPlanta(this.getResultSet().getString(7));
                modelUsuario.setEmail(this.getResultSet().getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera Usuario
     *
     * @param pCodigo return ModelUsuario
     */
    public boolean getUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "PK_ID,"
                    + "NOME,"
                    + "LOGIN,"
                    + "SENHA,"
                    + "SETOR,"
                    + "SOBRE_NOME,"
                    + "PLANTA,"
                    + "EMAIL"
                    + " FROM"
                    + " Cad_Usuario"
                    + " WHERE"
                    + "  LOGIN= '" + pModelUsuario.getLogin() + "' AND  SENHA= '" + pModelUsuario.getSenha() + "' "
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera uma lista de Usuario return ArrayList
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "PK_ID,"
                    + "NOME,"
                    + "LOGIN,"
                    + "SENHA,"
                    + "SETOR,"
                    + "SOBRE_NOME,"
                    + "PLANTA,"
                    + "EMAIL"
                    + " FROM"
                    + " Cad_Usuario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                modelUsuario.setSetor(this.getResultSet().getString(5));
                modelUsuario.setSobrenome(this.getResultSet().getString(6));
                modelUsuario.setPlanta(this.getResultSet().getString(7));
                modelUsuario.setEmail(this.getResultSet().getString(8));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario return boolean
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Usuario SET "
                    + " NOME= '" + pModelUsuario.getNome() + "',"
                    + "LOGIN = '" + pModelUsuario.getLogin() + "',"
                    + "SENHA = '" + pModelUsuario.getSenha() + "',"
                    + "SETOR = '" + pModelUsuario.getSetor() + "',"
                    + "SOBRE_NOME = '" + pModelUsuario.getSobrenome() + "',"
                    + "PLANTA = '" + pModelUsuario.getPlanta() + "',"
                    + "EMAIL = '" + pModelUsuario.getEmail() + "'"
                    + " WHERE "
                    + "PK_ID = '" + pModelUsuario.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Usuario
     *
     * @param pCodigo return boolean
     */
    public boolean excluirUsuarioDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM  Cad_Usuario"
                    + " WHERE "
                    + "PK_ID = '" + pCodigo + "'"
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
