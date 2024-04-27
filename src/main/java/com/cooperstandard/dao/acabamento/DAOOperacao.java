/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.acabamento;

import com.cooperstandard.dbs.ConexaoSql;

import com.cooperstandard.model.ModelOperacao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOOperacao extends ConexaoSql {

    public int salvarOperacaoAcDAO(ModelOperacao pModelOperacao) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Operacao ("
                    + "ORDEM,"
                    + "OPERACAO,"
                    + "OPE_SETOR,"
                    + "COD_OP,"
                    + "CLIENTE,"
                    + "COD_SIMBOL_OP,"
                    + "FORNECEDOR,"
                    + "PREPARADO_POR,"
                    + "TELEFONE,"
                    + "RESPONSAVEL_PROCESSO,"
                    + "EQUIPE,"
                    + "DATA_CRIACAO"
                    + ") VALUES ("
                    + "'" + pModelOperacao.getOrdem() + "',"
                    + "'" + pModelOperacao.getOperacao() + "',"
                    + "'" + pModelOperacao.getOpe_setor() + "',"
                    + "'" + pModelOperacao.getCod_op() + "',"
                    + "'" + pModelOperacao.getCliente() + "',"
                    + "'" + pModelOperacao.getCod_simbol_op() + "',"
                    + "'" + pModelOperacao.getFornecedor() + "',"
                    + "'" + pModelOperacao.getPreparado_por() + "',"
                    + "'" + pModelOperacao.getTelefone() + "',"
                    + "'" + pModelOperacao.getResponsavel_processo() + "',"
                    + "'" + pModelOperacao.getEquipe() + "',"
                    + "'" + pModelOperacao.getData_criacao() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelOperacao getOperacaoAcDAO(int pCodigo) {
        ModelOperacao modelOperacao = new ModelOperacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OPERACAO,"
                    + "ORDEM,"
                    + "OPERACAO,"
                    + "OPE_SETOR,"
                    + "COD_OP,"
                    + "CLIENTE,"
                    + "COD_SIMBOL_OP,"
                    + "FORNECEDOR,"
                    + "PREPARADO_POR,"
                    + "TELEFONE,"
                    + "RESPONSAVEL_PROCESSO,"
                    + "EQUIPE,"
                    + "DATA_CRIACAO "
                    + "FROM "
                    + "Cad_Operacao"
                    + " WHERE"
                    + " ID_OPERACAO= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelOperacao.setId_operacao(this.getResultSet().getInt(1));
                modelOperacao.setOrdem(this.getResultSet().getInt(2));
                modelOperacao.setOperacao(this.getResultSet().getString(3));
                modelOperacao.setOpe_setor(this.getResultSet().getString(4));
                modelOperacao.setCod_op(this.getResultSet().getInt(5));
                modelOperacao.setCliente(this.getResultSet().getString(6));
                modelOperacao.setCod_simbol_op(this.getResultSet().getString(7));
                modelOperacao.setFornecedor(this.getResultSet().getString(8));
                modelOperacao.setPreparado_por(this.getResultSet().getString(9));
                modelOperacao.setTelefone(this.getResultSet().getString(10));
                modelOperacao.setResponsavel_processo(this.getResultSet().getString(11));
                modelOperacao.setEquipe(this.getResultSet().getString(12));
                modelOperacao.setData_criacao(this.getResultSet().getString(13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOperacao;
    }

    public ModelOperacao getOperacaoAcDAO(String pNome) {
        ModelOperacao modelOperacao = new ModelOperacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OPERACAO,"
                    + "ORDEM,"
                    + "OPERACAO,"
                    + "OPE_SETOR,"
                    + "COD_OP,"
                    + "CLIENTE,"
                    + "COD_SIMBOL_OP,"
                    + "FORNECEDOR,"
                    + "PREPARADO_POR,"
                    + "TELEFONE,"
                    + "RESPONSAVEL_PROCESSO,"
                    + "EQUIPE,"
                    + "DATA_CRIACAO "
                    + "FROM "
                    + "Cad_Operacao"
                    + " WHERE"
                    + " OPERACAO= '" + pNome + "' and OPE_SETOR='Acabamento'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelOperacao.setId_operacao(this.getResultSet().getInt(1));
                modelOperacao.setOrdem(this.getResultSet().getInt(2));
                modelOperacao.setOperacao(this.getResultSet().getString(3));
                modelOperacao.setOpe_setor(this.getResultSet().getString(4));
                modelOperacao.setCod_op(this.getResultSet().getInt(5));
                modelOperacao.setCliente(this.getResultSet().getString(6));
                modelOperacao.setCod_simbol_op(this.getResultSet().getString(7));
                modelOperacao.setFornecedor(this.getResultSet().getString(8));
                modelOperacao.setPreparado_por(this.getResultSet().getString(9));
                modelOperacao.setTelefone(this.getResultSet().getString(10));
                modelOperacao.setResponsavel_processo(this.getResultSet().getString(11));
                modelOperacao.setEquipe(this.getResultSet().getString(12));
                modelOperacao.setData_criacao(this.getResultSet().getString(13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelOperacao;
    }

    public ArrayList<ModelOperacao> getListaOperacaoAcDAO() {
        ArrayList<ModelOperacao> listaOperacao = new ArrayList();
        ModelOperacao modelOperacao = new ModelOperacao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_OPERACAO,"
                    + "ORDEM,"
                    + "OPERACAO,"
                    + "OPE_SETOR,"
                    + "COD_OP,"
                    + "CLIENTE,"
                    + "COD_SIMBOL_OP,"
                    + "FORNECEDOR,"
                    + "PREPARADO_POR,"
                    + "TELEFONE,"
                    + "RESPONSAVEL_PROCESSO,"
                    + "EQUIPE,"
                    + "DATA_CRIACAO"
                    + " FROM"
                    + " Cad_Operacao where  OPE_SETOR= 'Acabamento' ORDER BY ORDEM "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelOperacao = new ModelOperacao();
                modelOperacao.setId_operacao(this.getResultSet().getInt(1));
                modelOperacao.setOrdem(this.getResultSet().getInt(2));
                modelOperacao.setOperacao(this.getResultSet().getString(3));
                modelOperacao.setOpe_setor(this.getResultSet().getString(4));
                modelOperacao.setCod_op(this.getResultSet().getInt(5));
                modelOperacao.setCliente(this.getResultSet().getString(6));
                modelOperacao.setCod_simbol_op(this.getResultSet().getString(7));
                modelOperacao.setFornecedor(this.getResultSet().getString(8));
                modelOperacao.setPreparado_por(this.getResultSet().getString(9));
                modelOperacao.setTelefone(this.getResultSet().getString(10));
                modelOperacao.setResponsavel_processo(this.getResultSet().getString(11));
                modelOperacao.setEquipe(this.getResultSet().getString(12));
                modelOperacao.setData_criacao(this.getResultSet().getString(13));

                listaOperacao.add(modelOperacao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaOperacao;
    }

    public boolean atualizarOperacaoAcDAO(ModelOperacao pModelOperacao) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Operacao SET "
                    + " ORDEM= '" + pModelOperacao.getOrdem() + "',"
                    + " OPERACAO= '" + pModelOperacao.getOperacao() + "',"
                    + " OPE_SETOR= '" + pModelOperacao.getOpe_setor() + "',"
                    + " COD_OP= '" + pModelOperacao.getCod_op() + "',"
                    + " CLIENTE= '" + pModelOperacao.getCliente() + "',"
                    + " COD_SIMBOL_OP= '" + pModelOperacao.getCod_simbol_op() + "',"
                    + " FORNECEDOR= '" + pModelOperacao.getFornecedor() + "',"
                    + " PREPARADO_POR= '" + pModelOperacao.getPreparado_por() + "',"
                    + " TELEFONE= '" + pModelOperacao.getTelefone() + "',"
                    + " RESPONSAVEL_PROCESSO= '" + pModelOperacao.getResponsavel_processo() + "',"
                    + " EQUIPE= '" + pModelOperacao.getEquipe() + "',"
                    + " DATA_CRIACAO= '" + pModelOperacao.getData_criacao() + "'"
                    + " WHERE "
                    + " ID_OPERACAO= '" + pModelOperacao.getId_operacao() + "'"
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

    public boolean excluirOperacaoAcDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Operacao "
                    + "WHERE "
                    + " ID_OPERACAO= '" + pCodigo + "'"
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
