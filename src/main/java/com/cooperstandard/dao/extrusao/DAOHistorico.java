/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.extrusao;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelHistorico;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rsouza10
 */
public class DAOHistorico extends ConexaoSql {

    public ArrayList<ModelHistorico> getListaHistoricoDAO() {
        ArrayList<ModelHistorico> listaHistorico = new ArrayList();
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct "
                    + "ID_HISTO_FICHA,"
                    + "HISTO_DATA_HISTO,"
                    + "HISTO_MATERIAL,"
                    + "HISTO_RESPONSAVEL"
                    + " FROM "
                    + "Qry_FichaControleHisto where (ALTER_IDENTIFICACAO='4'or ALTER_IDENTIFICACAO='5' or ALTER_IDENTIFICACAO='6') and SETOR='Extrusão' ORDER BY HISTO_DATA_HISTO asc"
            );

            while (this.getResultSet().next()) {
                modelHistorico = new ModelHistorico();
                modelHistorico.setId(this.getResultSet().getInt(1));
                modelHistorico.setHisto_data_histo(this.getResultSet().getDate(2));
                modelHistorico.setHisto_material(this.getResultSet().getInt(3));
                modelHistorico.setHisto_responsavel(this.getResultSet().getString(4));
                listaHistorico.add(modelHistorico);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaHistorico;
    }

    public ArrayList<ModelHistorico> getLista2HistoricoDAO() {
        ArrayList<ModelHistorico> listaHistorico = new ArrayList();
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct "
                    + "HISTO_DATA_HISTO,"
                    + "HISTO_LINHA,"
                    + "HISTO_MATERIAL,"
                    + "HISTO_HORA "
                    + "FROM"
                    + " Qry_FichaControleHisto where SETOR = 'Extrusão' ORDER BY HISTO_DATA_HISTO DESC,HISTO_HORA DESC"
            );

            while (this.getResultSet().next()) {
                modelHistorico = new ModelHistorico();
                modelHistorico.setHisto_data_histo(this.getResultSet().getDate(1));
                modelHistorico.setHisto_linha(this.getResultSet().getString(2));
                modelHistorico.setHisto_material(this.getResultSet().getInt(3));
                modelHistorico.setHisto_hora(this.getResultSet().getTime(4));
                listaHistorico.add(modelHistorico);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaHistorico;
    }

    public ArrayList<ModelHistorico> getListaMaterialHistoDAO() {
        ArrayList<ModelHistorico> listaHistorico = new ArrayList();
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "Select distinct HISTO_MATERIAL from Qry_FichaControleHisto where SETOR='Extrusão' order by HISTO_MATERIAL asc"
            );

            while (this.getResultSet().next()) {
                modelHistorico = new ModelHistorico();
                modelHistorico.setHisto_material(this.getResultSet().getInt(1));
                listaHistorico.add(modelHistorico);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaHistorico;
    }

    public ArrayList<ModelHistorico> getListaLinhaHistoDAO() {
        ArrayList<ModelHistorico> listaHistorico = new ArrayList();
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "Select distinct HISTO_LINHA from Qry_FichaControleHisto where SETOR='Extrusão' order by HISTO_LINHA asc"
            );

            while (this.getResultSet().next()) {
                modelHistorico = new ModelHistorico();
                modelHistorico.setHisto_linha(this.getResultSet().getString(1));
                listaHistorico.add(modelHistorico);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaHistorico;
    }

    public ModelHistorico getHistoricoDAO(Time pHora) {
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "HISTO_DATA_HISTO,"
                    + "HISTO_LINHA,"
                    + "HISTO_MATERIAL,"
                    + "HISTO_HORA "
                    + "FROM "
                    + "Histo_Ficha_Controle"
                    + " WHERE"
                    + " HISTO_HORA= '" + pHora + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelHistorico.setHisto_data_histo(this.getResultSet().getDate(1));
                modelHistorico.setHisto_linha(this.getResultSet().getString(2));
                modelHistorico.setHisto_material(this.getResultSet().getInt(3));
                modelHistorico.setHisto_hora(this.getResultSet().getTime(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelHistorico;
    }

    public ArrayList<ModelHistorico> getListaVersaoDAO(String perfil, String data, String hora) {
        ArrayList<ModelHistorico> listaHistorico = new ArrayList();
        ModelHistorico modelHistorico = new ModelHistorico();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct "
                    + "ID_HISTO_FICHA,"
                    + "ORDEM,"
                    + "EQU_OPERACAO,"
                    + "HISTO_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "HISTO_COMPLEMENTO,"
                    + "HISTO_REFERENCIA,"
                    + "HISTO_TIPO_ESPEC,"
                    + "HISTO_ESPEC_COMPLEMENTO,"
                    + "HISTO_FREQ_COMPLETO,"
                    + "ALTER_IDENTIFICACAO,"
                    + "HISTO_PRODUTO "
                    + " FROM Qry_Alter_Histo"
                    + " where HISTO_MATERIAL= '" + perfil + "' and HISTO_DATA_HISTO='" + data + "' and HISTO_HORA='" + hora + "' ORDER BY ORDEM asc"
            );

            while (this.getResultSet().next()) {
                modelHistorico = new ModelHistorico();
                modelHistorico.setId(this.getResultSet().getInt(1));
                modelHistorico.setHisto_ordem(this.getResultSet().getInt(2));
                modelHistorico.setEqu_operacao(this.getResultSet().getString(3));
                modelHistorico.setHisto_equipamento(this.getResultSet().getString(4));
                modelHistorico.setDesc_teste(this.getResultSet().getString(5));
                modelHistorico.setHisto_complemento(this.getResultSet().getString(6));
                modelHistorico.setHisto_referencia(this.getResultSet().getString(7));
                modelHistorico.setHisto_tipo_espec(this.getResultSet().getString(8));
                modelHistorico.setHisto_espec_completo(this.getResultSet().getString(9));
                modelHistorico.setHisto_freq_completo(this.getResultSet().getString(10));
                modelHistorico.setAlter_identificacao(this.getResultSet().getInt(11));
                modelHistorico.setHisto_produto(this.getResultSet().getString(12));
                listaHistorico.add(modelHistorico);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaHistorico;
    }
}
