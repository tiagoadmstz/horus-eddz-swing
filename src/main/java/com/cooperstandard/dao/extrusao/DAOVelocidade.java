package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelVelocidade;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOVelocidade extends ConexaoSql {

    public int salvarVelocidadeDAO(ModelVelocidade pModelVelocidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Velocidade_Perfil ("
                    + "DATA_CADASTRO,"
                    + "VELOCIDADE,"
                    + "ID_MATERIAL_ID,"
                    + "CUSTO,"
                    + "PESO,"
                    + "META"
                    + ") VALUES ("
                    + "'" + pModelVelocidade.getData_cadastro() + "',"
                    + "'" + pModelVelocidade.getVelocidade() + "',"
                    + "'" + pModelVelocidade.getId_material() + "',"
                    + "'" + pModelVelocidade.getCusto() + "',"
                    + "'" + pModelVelocidade.getPeso() + "',"
                    + "'" + pModelVelocidade.getMeta() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelVelocidade getVelocidadeDAO(long pCodigo) {
        ModelVelocidade modelVelocidade = new ModelVelocidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "DATA_CADASTRO,"
                    + "VELOCIDADE,"
                    + "MATERIAL,"
                    + "MAT_LINHA,"
                    + "CUSTO,"
                    + "PESO,"
                    + "META"
                    + " FROM"
                    + " Velocidade_Perfil INNER JOIN Cad_Material ON ID_MATERIAL_ID = ID_MATERIAL  "
                    + " WHERE"
                    + " ID = '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelVelocidade.setId(this.getResultSet().getLong(1));
                modelVelocidade.setData_cadastro(this.getResultSet().getTimestamp(2));
                modelVelocidade.setVelocidade(this.getResultSet().getFloat(3));
                modelVelocidade.setMaterial(this.getResultSet().getInt(4));
                modelVelocidade.setLinha(this.getResultSet().getString(5));
                modelVelocidade.setCusto(this.getResultSet().getFloat(6));
                modelVelocidade.setPeso(this.getResultSet().getFloat(7));
                modelVelocidade.setMeta(this.getResultSet().getFloat(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVelocidade;
    }

    public ArrayList<ModelVelocidade> getListaVelocidadeDAO() {
        ArrayList<ModelVelocidade> listaVelocidade = new ArrayList();

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MAT_LINHA,"
                    + "MATERIAL,"
                    + "VELOCIDADE,"
                    + "DATA_CADASTRO,"
                    + "CUSTO,"
                    + "PESO,"
                    + "META"
                    + " FROM"
                    + " Velocidade_Perfil INNER JOIN Cad_Material ON ID_MATERIAL_ID = ID_MATERIAL order by MAT_LINHA, MATERIAL"
                    + ";"
            );
            while (this.getResultSet().next()) {
                ModelVelocidade modelVelocidade = new ModelVelocidade();
                modelVelocidade.setId(this.getResultSet().getInt(1));
                modelVelocidade.setLinha(this.getResultSet().getString(2));
                modelVelocidade.setMaterial(this.getResultSet().getInt(3));
                modelVelocidade.setVelocidade(this.getResultSet().getFloat(4));
                modelVelocidade.setData_cadastro(this.getResultSet().getTimestamp(5));
                modelVelocidade.setCusto(this.getResultSet().getFloat(6));
                modelVelocidade.setPeso(this.getResultSet().getFloat(7));
                modelVelocidade.setMeta(this.getResultSet().getFloat(8));
                listaVelocidade.add(modelVelocidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaVelocidade;
    }

    public ArrayList<ModelVelocidade> getListaVelocidadePerfilDAO(int cod_perfil) {
        ArrayList<ModelVelocidade> listaVelocidade = new ArrayList();

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MAT_LINHA,"
                    + "MATERIAL,"
                    + "VELOCIDADE,"
                    + "DATA_CADASTRO,"
                    + "CUSTO,"
                    + "PESO,"
                    + "META"
                    + " FROM"
                    + " Velocidade_Perfil INNER JOIN Cad_Material ON ID_MATERIAL_ID = ID_MATERIAL"
                    + " WHERE"
                    + " ID_MATERIAL = '" + cod_perfil + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                ModelVelocidade modelVelocidade = new ModelVelocidade();
                modelVelocidade.setId(this.getResultSet().getInt(1));
                modelVelocidade.setLinha(this.getResultSet().getString(2));
                modelVelocidade.setMaterial(this.getResultSet().getInt(3));
                modelVelocidade.setVelocidade(this.getResultSet().getFloat(4));
                modelVelocidade.setData_cadastro(this.getResultSet().getTimestamp(5));
                modelVelocidade.setCusto(this.getResultSet().getFloat(6));
                modelVelocidade.setPeso(this.getResultSet().getFloat(7));
                modelVelocidade.setMeta(this.getResultSet().getFloat(8));
                listaVelocidade.add(modelVelocidade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaVelocidade;
    }

    public ArrayList<ModelVelocidade> getListaVelocidadeLinhaDAO(String linha) {
        ArrayList<ModelVelocidade> listaVelocidade = new ArrayList();

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "MAT_LINHA,"
                    + "MATERIAL,"
                    + "VELOCIDADE,"
                    + "DATA_CADASTRO,"
                    + "CUSTO,"
                    + "PESO,"
                    + "META,"
                    + "DESC_MATERIAL,"
                    + "IMAGE,"
                    + "BPCS"
                    + " FROM"
                    + " Velocidade_Perfil INNER JOIN Cad_Material ON ID_MATERIAL_ID = ID_MATERIAL"
                    + " WHERE"
                    + " MAT_LINHA = '" + linha + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                ModelVelocidade modelVelocidade = new ModelVelocidade();
                modelVelocidade.setId(this.getResultSet().getInt(1));
                modelVelocidade.setLinha(this.getResultSet().getString(2));
                modelVelocidade.setMaterial(this.getResultSet().getInt(3));
                modelVelocidade.setVelocidade(this.getResultSet().getFloat(4));
                modelVelocidade.setData_cadastro(this.getResultSet().getTimestamp(5));
                modelVelocidade.setCusto(this.getResultSet().getFloat(6));
                modelVelocidade.setPeso(this.getResultSet().getFloat(7));
                modelVelocidade.setMeta(this.getResultSet().getFloat(8));
                modelVelocidade.setDesc_perfil(this.getResultSet().getString(9));
                modelVelocidade.setImagem(this.getResultSet().getString(10));
                modelVelocidade.setBpcs(this.getResultSet().getString(11));
                listaVelocidade.add(modelVelocidade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaVelocidade;
    }

    public boolean atualizarVelocidadeDAO(ModelVelocidade pModelVelocidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Velocidade_Perfil SET "
                    + " DATA_CADASTRO= '" + pModelVelocidade.getData_cadastro() + "',"
                    + " VELOCIDADE= '" + pModelVelocidade.getVelocidade() + "',"
                    + " CUSTO= '" + pModelVelocidade.getCusto() + "',"
                    + " PESO= '" + pModelVelocidade.getPeso() + "',"
                    + " META= '" + pModelVelocidade.getMeta() + "'"
                    + " WHERE "
                    + " ID= '" + pModelVelocidade.getId() + "'"
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

    public boolean excluirVelocidadeDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Velocidade_Perfil "
                    + "WHERE "
                    + " ID = '" + pCodigo + "'"
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
