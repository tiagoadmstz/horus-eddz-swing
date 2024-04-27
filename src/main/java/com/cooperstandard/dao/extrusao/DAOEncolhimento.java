package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelEncolhimento;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOEncolhimento extends ConexaoSql {

    public int salvarEncolhimentoDAO(ModelEncolhimento pModelEncolhimento) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Encolhimento ("
                    + "AMOSTRA_INICIAL,"
                    + "AMOSTRA_24HRS,"
                    + "AMOSTRA_48HRS,"
                    + "AMOSTRA_72HRS,"
                    + "DATA_LANCAMENTO,"
                    + "HORA,"
                    + "ID_MATERIAL_ID,"
                    + "VELOCIDADE,"
                    + "OBSERVACAO,"
                    + "TRENA,"
                    + "DESENHO,"
                    + "DATA_HORA_JET"
                    + ") VALUES ("
                    + "'" + pModelEncolhimento.getAmostrainicial() + "',"
                    + "'" + pModelEncolhimento.getAmostra24hrs() + "',"
                    + "'" + pModelEncolhimento.getAmostra48hrs() + "',"
                    + "'" + pModelEncolhimento.getAmostra72hrs() + "',"
                    + "'" + pModelEncolhimento.getData() + "',"
                    + "'" + pModelEncolhimento.getHora() + "',"
                    + "'" + pModelEncolhimento.getId_material() + "',"
                    + "'" + pModelEncolhimento.getVelocidade() + "',"
                    + "'" + pModelEncolhimento.getObservacao() + "',"
                    + "'" + pModelEncolhimento.getTrena() + "',"
                    + "'" + pModelEncolhimento.getDesenho() + "',"
                    + "'" + pModelEncolhimento.getDhjet() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelEncolhimento getEncolhimentoDAO(int pCodigo) {
        ModelEncolhimento modelEncolhimento = new ModelEncolhimento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "AMOSTRA_INICIAL,"
                    + "AMOSTRA_24HRS,"
                    + "AMOSTRA_48HRS,"
                    + "AMOSTRA_72HRS,"
                    + "DATA_LANCAMENTO,"
                    + "HORA,"
                    + "ID_MATERIAL_ID,"
                    + "VELOCIDADE,"
                    + "OBSERVACAO,"
                    + "TRENA,"
                    + "DESENHO"
                    + "FROM "
                    + "Encolhimento"
                    + " WHERE"
                    + " ID = '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEncolhimento.setId(this.getResultSet().getInt(1));
                modelEncolhimento.setAmostrainicial(this.getResultSet().getInt(2));
                modelEncolhimento.setAmostra24hrs(this.getResultSet().getInt(3));
                modelEncolhimento.setAmostra48hrs(this.getResultSet().getInt(4));
                modelEncolhimento.setAmostra72hrs(this.getResultSet().getInt(5));
                modelEncolhimento.setData(this.getResultSet().getString(6));
                modelEncolhimento.setHora(this.getResultSet().getString(7));
                modelEncolhimento.setId_material(this.getResultSet().getInt(8));
                modelEncolhimento.setVelocidade(this.getResultSet().getFloat(9));
                modelEncolhimento.setObservacao(this.getResultSet().getString(10));
                modelEncolhimento.setTrena(this.getResultSet().getString(11));
                modelEncolhimento.setDesenho(this.getResultSet().getString(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEncolhimento;
    }

    public ArrayList<ModelEncolhimento> getListaEncolhimentoDAO(int cod_perfil, String velocidade) {
        ArrayList<ModelEncolhimento> listaEncolhimento = new ArrayList();
        ModelEncolhimento modelEncolhimento = new ModelEncolhimento();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "AMOSTRA_INICIAL,"
                    + "AMOSTRA_24HRS,"
                    + "AMOSTRA_48HRS,"
                    + "AMOSTRA_72HRS,"
                    + "DATA_LANCAMENTO,"
                    + "HORA,"
                    + "ID_MATERIAL_ID,"
                    + "VELOCIDADE,"
                    + "OBSERVACAO,"
                    + "TRENA,"
                    + "DESENHO"
                    + " FROM"
                    + " Encolhimento where ID_MATERIAL_ID = '" + cod_perfil + "' and VELOCIDADE ='" + velocidade + "' ORDER BY ID"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEncolhimento.setId(this.getResultSet().getInt(1));
                modelEncolhimento.setAmostrainicial(this.getResultSet().getFloat(2));
                modelEncolhimento.setAmostra24hrs(this.getResultSet().getFloat(3));
                modelEncolhimento.setAmostra48hrs(this.getResultSet().getFloat(4));
                modelEncolhimento.setAmostra72hrs(this.getResultSet().getFloat(5));
                modelEncolhimento.setData(this.getResultSet().getString(6));
                modelEncolhimento.setHora(this.getResultSet().getString(7));
                modelEncolhimento.setId_material(this.getResultSet().getInt(8));
                modelEncolhimento.setVelocidade(this.getResultSet().getFloat(9));
                modelEncolhimento.setObservacao(this.getResultSet().getString(10));
                modelEncolhimento.setTrena(this.getResultSet().getString(11));
                modelEncolhimento.setDesenho(this.getResultSet().getString(12));
                listaEncolhimento.add(modelEncolhimento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEncolhimento;
    }

    public boolean atualizarEncolhimentoDAO(ModelEncolhimento pModelEncolhimento) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Encolhimento SET "
                    + " AMOSTRA= '" + pModelEncolhimento.getAmostrainicial() + "',"
                    + " AMOSTRA_24HRS= '" + pModelEncolhimento.getAmostra24hrs() + "',"
                    + " AMOSTRA_48HRS= '" + pModelEncolhimento.getAmostra48hrs() + "',"
                    + " AMOSTRA_72HRS= '" + pModelEncolhimento.getAmostra72hrs() + "',"
                    + " DATA_LANCAMENTO= '" + pModelEncolhimento.getData() + "',"
                    + " HORA= '" + pModelEncolhimento.getHora() + "',"
                    + " ID_MATERIAL_ID= '" + pModelEncolhimento.getId_material() + "',"
                    + " VELOCIDADE= '" + pModelEncolhimento.getVelocidade() + "'"
                    + " OBSERVACAO= '" + pModelEncolhimento.getObservacao() + "'"
                    + " TRENA= '" + pModelEncolhimento.getTrena() + "'"
                    + " DESENHO= '" + pModelEncolhimento.getDesenho() + "'"
                    + " WHERE "
                    + " ID= '" + pModelEncolhimento.getId() + "'"
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

    public boolean excluirEncolhimentoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Encolhimento "
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
