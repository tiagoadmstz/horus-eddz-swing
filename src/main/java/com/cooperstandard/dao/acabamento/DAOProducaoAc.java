/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.acabamento;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelProducao;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOProducaoAc extends ConexaoSql {

    public ArrayList<ModelProducao> getListaProducaoAcDAO() {
        ArrayList<ModelProducao> listaProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_ESPEC_TESTE,"
                    + "ORDEM,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "ESP_TESTE,"
                    + "ESP_EQUIPAMENTO,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "FREQUENCIA,"
                    + "UNID_FREQUENCIA,"
                    + "PRODUTO,"
                    + "ORIGEM,"
                    + "TIPO_ESPEC,"
                    + "ESPEC_COMPLETO,"
                    + "FREQ_COMPLETO,"
                    + "LAB,"
                    + "COMPLEMENTO,"
                    + "ESP_COMPOSTO,"
                    + "STATUS"
                    + " FROM"
                    + " Cad_Linha where SETOR = 'Acabamento' ORDER BY LINHA "
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProducao = new ModelProducao();
                modelProducao.setId(this.getResultSet().getInt(1));
                modelProducao.setOrdem(this.getResultSet().getInt(2));
                modelProducao.setEsp_linha(this.getResultSet().getString(3));
                modelProducao.setEsp_material(this.getResultSet().getInt(4));
                modelProducao.setEsp_teste(this.getResultSet().getString(5));
                modelProducao.setEsp_equipamento(this.getResultSet().getString(6));
                modelProducao.setMinimo(this.getResultSet().getFloat(7));
                modelProducao.setMaximo(this.getResultSet().getFloat(8));
                modelProducao.setUnid_med(this.getResultSet().getString(9));
                modelProducao.setTexto(this.getResultSet().getString(10));
                modelProducao.setReferencia(this.getResultSet().getString(11));
                modelProducao.setFrequencia(this.getResultSet().getInt(12));
                modelProducao.setUnid_freq(this.getResultSet().getString(13));
                modelProducao.setProduto(this.getResultSet().getString(14));
                modelProducao.setOrigem(this.getResultSet().getString(15));
                modelProducao.setTipo_espec(this.getResultSet().getString(16));
                modelProducao.setEspec_completo(this.getResultSet().getString(17));
                modelProducao.setFreq_completo(this.getResultSet().getString(18));
                modelProducao.setLab(this.getResultSet().getString(19));
                modelProducao.setComplemento(this.getResultSet().getString(20));
                modelProducao.setEsp_composto(this.getResultSet().getInt(21));
                modelProducao.setStatus(this.getResultSet().getString(22));

                listaProducao.add(modelProducao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProducao;
    }

    public ArrayList<ModelProducao> getListaLinhaAcDAO() {
        ArrayList<ModelProducao> listaProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct ESP_LINHA from Qry_FichaControle where SETOR='Acabamento' order by ESP_LINHA asc"
            );

            while (this.getResultSet().next()) {
                modelProducao = new ModelProducao();
                modelProducao.setEsp_linha(this.getResultSet().getString(1));
                listaProducao.add(modelProducao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProducao;
    }

    public ArrayList<ModelProducao> getListaPerfilAcDAO() {
        ArrayList<ModelProducao> listaProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct ESP_MATERIAL from Qry_FichaControle where SETOR='Acabamento' order by ESP_MATERIAL asc"
            );

            while (this.getResultSet().next()) {
                modelProducao = new ModelProducao();
                modelProducao.setEsp_material(this.getResultSet().getInt(1));
                listaProducao.add(modelProducao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProducao;
    }

    public ArrayList<ModelProducao> getListaProducaoAcDAO(String perfil) {
        ArrayList<ModelProducao> listaProducao = new ArrayList();
        ModelProducao modelProducao = new ModelProducao();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_ESPEC_TESTE,"
                    + "ORDEM,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "ESP_EQUIPAMENTO,"
                    + "DESC_MATERIAL,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "FREQUENCIA,"
                    + "UNID_FREQUENCIA,"
                    + "ORIGEM,"
                    + "TIPO_ESPEC,"
                    + "PRODUTO,"
                    + "ESPEC_COMPLETO,"
                    + "FREQ_COMPLETO,"
                    + "LAB,"
                    + "COMPLEMENTO,"
                    + "ESP_COMPOSTO,"
                    + "STATUS"
                    + " FROM"
                    + " Qry_Result where SETOR = 'Acabamento' and ESP_MATERIAL ='" + perfil + "' ORDER BY ORDEM "
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelProducao = new ModelProducao();
                modelProducao.setId(this.getResultSet().getInt(1));
                modelProducao.setOrdem(this.getResultSet().getInt(2));
                modelProducao.setEsp_linha(this.getResultSet().getString(3));
                modelProducao.setEsp_material(this.getResultSet().getInt(4));
                modelProducao.setEsp_equipamento(this.getResultSet().getString(5));
                modelProducao.setDesc_teste(this.getResultSet().getString(6));
                modelProducao.setMinimo(this.getResultSet().getFloat(7));
                modelProducao.setMaximo(this.getResultSet().getFloat(8));
                modelProducao.setUnid_med(this.getResultSet().getString(9));
                modelProducao.setTexto(this.getResultSet().getString(10));
                modelProducao.setReferencia(this.getResultSet().getString(11));
                modelProducao.setFrequencia(this.getResultSet().getInt(12));
                modelProducao.setUnid_freq(this.getResultSet().getString(13));
                modelProducao.setOrigem(this.getResultSet().getString(14));
                modelProducao.setTipo_espec(this.getResultSet().getString(15));
                modelProducao.setProduto(this.getResultSet().getString(16));
                modelProducao.setEspec_completo(this.getResultSet().getString(17));
                modelProducao.setFreq_completo(this.getResultSet().getString(18));
                modelProducao.setLab(this.getResultSet().getString(19));
                modelProducao.setComplemento(this.getResultSet().getString(20));
                modelProducao.setEsp_composto(this.getResultSet().getInt(21));
                modelProducao.setStatus(this.getResultSet().getString(22));

                listaProducao.add(modelProducao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaProducao;
    }

}
