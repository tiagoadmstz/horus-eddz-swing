/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.acabamento;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelFichaControle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author rsouza10
 */
public class DAOFichaControleAc extends ConexaoSql {

    public int salvarFichaControleAcDAO(ModelFichaControle pModelFichaControle) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Espec_Teste ("
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
                    + "RESPONSAVEL_ALTER,"
                    + "PENDENCIA_ALTER,"
                    + "DATA_ALTER,"
                    + "OBSERVACAO_ALTER,"
                    + "DATE_VALIDE_ALTER,"
                    + "ALTER_IDENTIFICACAO,"
                    + "ESP_COMPOSTO,"
                    + "STATUS,"
                    + "AMOSTRA"
                    + ") VALUES ("
                    + "'" + pModelFichaControle.getOrdem() + "',"
                    + "'" + pModelFichaControle.getEsp_linha() + "',"
                    + "'" + pModelFichaControle.getEsp_material() + "',"
                    + "'" + pModelFichaControle.getEsp_teste() + "',"
                    + "'" + pModelFichaControle.getEsp_equipamento() + "',"
                    + "'" + pModelFichaControle.getMinimo() + "',"
                    + "'" + pModelFichaControle.getMaximo() + "',"
                    + "'" + pModelFichaControle.getUnid_medida() + "',"
                    + "'" + pModelFichaControle.getTexto() + "',"
                    + "'" + pModelFichaControle.getReferencia() + "',"
                    + "'" + pModelFichaControle.getFrequencia() + "',"
                    + "'" + pModelFichaControle.getUnid_frequencia() + "',"
                    + "'" + pModelFichaControle.getProduto() + "',"
                    + "'" + pModelFichaControle.getOrigem() + "',"
                    + "'" + pModelFichaControle.getTipo_espec() + "',"
                    + "'" + pModelFichaControle.getEspec_completo() + "',"
                    + "'" + pModelFichaControle.getFreq_completo() + "',"
                    + "'" + pModelFichaControle.getLab() + "',"
                    + "'" + pModelFichaControle.getComplemento() + "',"
                    + "'" + pModelFichaControle.getResponsavel_alter() + "',"
                    + "'" + pModelFichaControle.getPendencia_alter() + "',"
                    + "'" + pModelFichaControle.getData_alter() + "',"
                    + "'" + pModelFichaControle.getObservacao_alter() + "',"
                    + "'" + pModelFichaControle.getDate_valid_alter() + "',"
                    + "'" + pModelFichaControle.getAlter_indentificacao() + "',"
                    + "'" + pModelFichaControle.getEsp_composto() + "',"
                    + "'" + pModelFichaControle.getStatus() + "',"
                    + "'" + pModelFichaControle.getAmostra() + "'"
                    + ");"
            );

        } catch (Exception e) {
            if (e.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                JOptionPane.showMessageDialog(null, "Código do teste duplicado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ok");
            }

            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelFichaControle getFichaControleAcDAO(int pCodigo) {
        ModelFichaControle modelFichaControle = new ModelFichaControle();
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
                    + "RESPONSAVEL_ALTER,"
                    + "PENDENCIA_ALTER,"
                    + "DATA_ALTER,"
                    + "HORA_ALTER,"
                    + "OBSERVACAO_ALTER,"
                    + "DATE_VALIDE_ALTER,"
                    + "ALTER_IDENTIFICACAO,"
                    + "ESP_COMPOSTO,"
                    + "DESC_TESTE,"
                    + "AMOSTRA"
                    + " FROM "
                    + " Qry_Cadastro "
                    + " WHERE"
                    + " ID_ESPEC_TESTE= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle.setId(this.getResultSet().getInt(1));
                modelFichaControle.setOrdem(this.getResultSet().getInt(2));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControle.setEsp_teste(this.getResultSet().getString(5));
                modelFichaControle.setEsp_equipamento(this.getResultSet().getString(6));
                modelFichaControle.setMinimo(this.getResultSet().getFloat(7));
                modelFichaControle.setMaximo(this.getResultSet().getFloat(8));
                modelFichaControle.setUnid_medida(this.getResultSet().getString(9));
                modelFichaControle.setTexto(this.getResultSet().getString(10));
                modelFichaControle.setReferencia(this.getResultSet().getString(11));
                modelFichaControle.setFrequencia(this.getResultSet().getInt(12));
                modelFichaControle.setUnid_frequencia(this.getResultSet().getString(13));
                modelFichaControle.setProduto(this.getResultSet().getString(14));
                modelFichaControle.setOrigem(this.getResultSet().getString(15));
                modelFichaControle.setTipo_espec(this.getResultSet().getString(16));
                modelFichaControle.setEspec_completo(this.getResultSet().getString(17));
                modelFichaControle.setFreq_completo(this.getResultSet().getString(18));
                modelFichaControle.setLab(this.getResultSet().getString(19));
                modelFichaControle.setComplemento(this.getResultSet().getString(20));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(21));
                modelFichaControle.setPendencia_alter(this.getResultSet().getString(22));
                modelFichaControle.setData_alter(this.getResultSet().getDate(23));
                modelFichaControle.setHora_alter(this.getResultSet().getTime(24));
                modelFichaControle.setObservacao_alter(this.getResultSet().getString(25));
                modelFichaControle.setDate_valid_alter(this.getResultSet().getString(26));
                modelFichaControle.setAlter_indentificacao(this.getResultSet().getInt(27));
                modelFichaControle.setEsp_composto(this.getResultSet().getInt(28));
                modelFichaControle.setDesc_teste(this.getResultSet().getString(29));
                modelFichaControle.setAmostra(this.getResultSet().getString(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControle;
    }

    public ModelFichaControle getFichaControleAcDAO(String pNome) {
        ModelFichaControle modelFichaControle = new ModelFichaControle();
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
                    + "RESPONSAVEL_ALTER,"
                    + "PENDENCIA_ALTER,"
                    + "DATA_ALTER,"
                    + "HORA_ALTER,"
                    + "OBSERVACAO_ALTER,"
                    + "DATE_VALIDE_ALTER,"
                    + "ALTER_IDENTIFICACAO,"
                    + "ESP_COMPOSTO,"
                    + "STATUS,"
                    + "AMOSTRA"
                    + " FROM "
                    + "Cad_Espec_Teste"
                    + " WHERE"
                    + " ESP_TESTE= '" + pNome + "' and OPE_SETOR='Acabamento'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle.setId(this.getResultSet().getInt(1));
                modelFichaControle.setOrdem(this.getResultSet().getInt(2));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControle.setEsp_teste(this.getResultSet().getString(5));
                modelFichaControle.setEsp_equipamento(this.getResultSet().getString(6));
                modelFichaControle.setMinimo(this.getResultSet().getFloat(7));
                modelFichaControle.setMaximo(this.getResultSet().getFloat(8));
                modelFichaControle.setUnid_medida(this.getResultSet().getString(9));
                modelFichaControle.setTexto(this.getResultSet().getString(10));
                modelFichaControle.setReferencia(this.getResultSet().getString(11));
                modelFichaControle.setFrequencia(this.getResultSet().getInt(12));
                modelFichaControle.setUnid_frequencia(this.getResultSet().getString(13));
                modelFichaControle.setProduto(this.getResultSet().getString(14));
                modelFichaControle.setOrigem(this.getResultSet().getString(15));
                modelFichaControle.setTipo_espec(this.getResultSet().getString(16));
                modelFichaControle.setEspec_completo(this.getResultSet().getString(17));
                modelFichaControle.setFreq_completo(this.getResultSet().getString(18));
                modelFichaControle.setLab(this.getResultSet().getString(19));
                modelFichaControle.setComplemento(this.getResultSet().getString(20));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(21));
                modelFichaControle.setPendencia_alter(this.getResultSet().getString(22));
                modelFichaControle.setData_alter(this.getResultSet().getDate(23));
                modelFichaControle.setHora_alter(this.getResultSet().getTime(24));
                modelFichaControle.setObservacao_alter(this.getResultSet().getString(25));
                modelFichaControle.setDate_valid_alter(this.getResultSet().getString(26));
                modelFichaControle.setAlter_indentificacao(this.getResultSet().getInt(27));
                modelFichaControle.setEsp_composto(this.getResultSet().getInt(28));
                modelFichaControle.setStatus(this.getResultSet().getString(29));
                modelFichaControle.setAmostra(this.getResultSet().getString(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaControleAcDAO(String perfil) {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_ESPEC_TESTE,"
                    + "ORDEM,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "ESP_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "ESP_TESTE,"
                    + "COMPLEMENTO,"
                    + "TIPO_ESPEC,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "FREQUENCIA,"
                    + "UNID_FREQUENCIA,"
                    + "PRODUTO,"
                    + "ORIGEM,"
                    + "LAB,"
                    + "AMOSTRA,"
                    + "PENDENCIA_ALTER,"
                    + "ESP_COMPOSTO "
                    + " FROM Qry_Cadastro where ESP_MATERIAL='" + perfil + "' and (PENDENCIA_ALTER is null or PENDENCIA_ALTER='' or PENDENCIA_ALTER = null or PENDENCIA_ALTER = 'Cópia') ORDER BY ORDEM asc"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setId(this.getResultSet().getInt(1));
                modelFichaControle.setOrdem(this.getResultSet().getInt(2));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControle.setEsp_equipamento(this.getResultSet().getString(5));
                modelFichaControle.setDesc_teste(this.getResultSet().getString(6));
                modelFichaControle.setEsp_teste(this.getResultSet().getString(7));
                modelFichaControle.setComplemento(this.getResultSet().getString(8));
                modelFichaControle.setTipo_espec(this.getResultSet().getString(9));
                modelFichaControle.setMinimo(this.getResultSet().getFloat(10));
                modelFichaControle.setMaximo(this.getResultSet().getFloat(11));
                modelFichaControle.setUnid_medida(this.getResultSet().getString(12));
                modelFichaControle.setTexto(this.getResultSet().getString(13));
                modelFichaControle.setReferencia(this.getResultSet().getString(14));
                modelFichaControle.setFrequencia(this.getResultSet().getInt(15));
                modelFichaControle.setUnid_frequencia(this.getResultSet().getString(16));
                modelFichaControle.setProduto(this.getResultSet().getString(17));
                modelFichaControle.setOrigem(this.getResultSet().getString(18));
                modelFichaControle.setLab(this.getResultSet().getString(19));
                modelFichaControle.setAmostra(this.getResultSet().getString(20));
                modelFichaControle.setPendencia_alter(this.getResultSet().getString(21));
                modelFichaControle.setEsp_composto(this.getResultSet().getInt(22));

                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaControleComboAcDAO() {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "ESP_LINHA "
                    + "FROM Qry_Cadastro"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setEsp_linha(this.getResultSet().getString(1));

                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaControleEditAcDAO(String perfil) {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_ESPEC_TESTE,"
                    + "ORDEM,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "ESP_EQUIPAMENTO,"
                    + "DESC_TESTE,"
                    + "ESP_TESTE,"
                    + "COMPLEMENTO,"
                    + "TIPO_ESPEC,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "FREQUENCIA,"
                    + "UNID_FREQUENCIA,"
                    + "PRODUTO,"
                    + "ORIGEM,"
                    + "LAB,"
                    + "AMOSTRA,"
                    + "PENDENCIA_ALTER,"
                    + "ESP_COMPOSTO,"
                    + "ALTER_IDENTIFICACAO"
                    + " FROM Qry_Cadastro WHERE ESP_MATERIAL='" + perfil + "' ORDER BY ORDEM asc"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setId(this.getResultSet().getInt(1));
                modelFichaControle.setOrdem(this.getResultSet().getInt(2));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControle.setEsp_equipamento(this.getResultSet().getString(5));
                modelFichaControle.setDesc_teste(this.getResultSet().getString(6));
                modelFichaControle.setEsp_teste(this.getResultSet().getString(7));
                modelFichaControle.setComplemento(this.getResultSet().getString(8));
                modelFichaControle.setTipo_espec(this.getResultSet().getString(9));
                modelFichaControle.setMinimo(this.getResultSet().getFloat(10));
                modelFichaControle.setMaximo(this.getResultSet().getFloat(11));
                modelFichaControle.setUnid_medida(this.getResultSet().getString(12));
                modelFichaControle.setTexto(this.getResultSet().getString(13));
                modelFichaControle.setReferencia(this.getResultSet().getString(14));
                modelFichaControle.setFrequencia(this.getResultSet().getInt(15));
                modelFichaControle.setUnid_frequencia(this.getResultSet().getString(16));
                modelFichaControle.setProduto(this.getResultSet().getString(17));
                modelFichaControle.setOrigem(this.getResultSet().getString(18));
                modelFichaControle.setLab(this.getResultSet().getString(19));
                modelFichaControle.setAmostra(this.getResultSet().getString(20));
                modelFichaControle.setPendencia_alter(this.getResultSet().getString(21));
                modelFichaControle.setEsp_composto(this.getResultSet().getInt(22));
                modelFichaControle.setAlter_indentificacao(this.getResultSet().getInt(23));

                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public boolean atualizarFichaControleAcDAO(ModelFichaControle pModelFichaControle) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste SET "
                    + " ORDEM= '" + pModelFichaControle.getOrdem() + "',"
                    + " ESP_LINHA= '" + pModelFichaControle.getEsp_linha() + "',"
                    + " ESP_MATERIAL= '" + pModelFichaControle.getEsp_material() + "',"
                    + " ESP_TESTE= '" + pModelFichaControle.getEsp_teste() + "',"
                    + " ESP_EQUIPAMENTO= '" + pModelFichaControle.getEsp_equipamento() + "',"
                    + " MINIMO= '" + pModelFichaControle.getMinimo() + "',"
                    + " MAXIMO= '" + pModelFichaControle.getMaximo() + "',"
                    + " UNID_MEDIDA= '" + pModelFichaControle.getUnid_medida() + "',"
                    + " TEXTO= '" + pModelFichaControle.getTexto() + "',"
                    + " REFERENCIA= '" + pModelFichaControle.getReferencia() + "',"
                    + " FREQUENCIA= '" + pModelFichaControle.getFrequencia() + "',"
                    + " UNID_FREQUENCIA= '" + pModelFichaControle.getUnid_frequencia() + "',"
                    + " PRODUTO= '" + pModelFichaControle.getProduto() + "',"
                    + " ORIGEM= '" + pModelFichaControle.getOrigem() + "',"
                    + " TIPO_ESPEC= '" + pModelFichaControle.getTipo_espec() + "',"
                    + " ESPEC_COMPLETO= '" + pModelFichaControle.getEspec_completo() + "',"
                    + " FREQ_COMPLETO= '" + pModelFichaControle.getFreq_completo() + "',"
                    + " LAB= '" + pModelFichaControle.getLab() + "',"
                    + " COMPLEMENTO= '" + pModelFichaControle.getComplemento() + "',"
                    + "RESPONSAVEL_ALTER='" + pModelFichaControle.getResponsavel_alter() + "',"
                    + "PENDENCIA_ALTER='" + pModelFichaControle.getPendencia_alter() + "',"
                    + "OBSERVACAO_ALTER='" + pModelFichaControle.getObservacao_alter() + "',"
                    + "DATA_ALTER='" + pModelFichaControle.getData_alter() + "',"
                    + "ALTER_IDENTIFICACAO='" + pModelFichaControle.getAlter_indentificacao() + "',"
                    + "ESP_COMPOSTO='" + pModelFichaControle.getEsp_composto() + "',"
                    + "AMOSTRA='" + pModelFichaControle.getAmostra() + "'"
                    + " WHERE "
                    + " ID_ESPEC_TESTE= '" + pModelFichaControle.getId() + "'"
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

    public boolean excluirFichaControleAcDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Espec_Teste "
                    + "WHERE "
                    + " ID_ESPEC_TESTE= '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean updatStatusAc(String perfilupdat, String pendencia, String responsavel) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set PENDENCIA_ALTER='" + pendencia + "',RESPONSAVEL_ALTER='" + responsavel + "'  where ESP_MATERIAL='" + perfilupdat + "' and (PENDENCIA_ALTER IS NULL or PENDENCIA_ALTER='')"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean updatStatusAlterarAc(ModelFichaControle pModelFichaControle, String perfilupdat) {
        try {
            this.conectar();
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);

            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String values = dateString;
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set PENDENCIA_ALTER='" + pModelFichaControle.getPendencia_alter() + "',RESPONSAVEL_ALTER='" + pModelFichaControle.getResponsavel_alter() + "', DATA_ALTER ='" + values + "'  where ESP_MATERIAL='" + perfilupdat + "' and (PENDENCIA_ALTER = 'Alteração')"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean updatecopiaStatusAc(ModelFichaControle pModelFichaControle, String perfilupdat) {
        try {
            this.conectar();
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);

            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String values = dateString;
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set PENDENCIA_ALTER='" + pModelFichaControle.getPendencia_alter() + "',RESPONSAVEL_ALTER='" + pModelFichaControle.getResponsavel_alter() + "', DATA_ALTER ='" + values + "', HORA_ALTER='" + value0 + "', OBSERVACAO_ALTER = '" + pModelFichaControle.getObservacao_alter() + "',  STATUS= '" + pModelFichaControle.getStatus() + "' where ESP_MATERIAL='" + perfilupdat + "' and (PENDENCIA_ALTER IS NULL or PENDENCIA_ALTER='' or PENDENCIA_ALTER='Cópia')"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoAcDAO() {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "RESPONSAVEL_ALTER,"
                    + "STATUS "
                    + "FROM Qry_Espec_Teste where (PENDENCIA_ALTER is null or PENDENCIA_ALTER='' or PENDENCIA_ALTER = null)and SETOR='Acabamento'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setData_alter(this.getResultSet().getDate(1));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(4));
                modelFichaControle.setStatus(this.getResultSet().getString(5));
                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoAlterAcDAO() {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "RESPONSAVEL_ALTER "
                    + "FROM Qry_Espec_Teste where (PENDENCIA_ALTER ='Alteração') and (RESPONSAVEL_ALTER !=NULL OR RESPONSAVEL_ALTER <> 'NULL' OR RESPONSAVEL_ALTER !='' OR RESPONSAVEL_ALTER <> '') and SETOR='Acabamento' order by DATA_ALTER DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setData_alter(this.getResultSet().getDate(1));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(4));
                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaemAbertoCopiaAcDAO() {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "RESPONSAVEL_ALTER "
                    + "FROM Qry_Espec_Teste where (PENDENCIA_ALTER ='Cópia') and (RESPONSAVEL_ALTER !=NULL OR RESPONSAVEL_ALTER <> 'NULL' OR RESPONSAVEL_ALTER !='' OR RESPONSAVEL_ALTER <> '') and SETOR = 'Acabamento' order by DATA_ALTER DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setData_alter(this.getResultSet().getDate(1));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(4));
                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ModelFichaControle getFichaAcDAO(int pPerfilaberto) {
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "RESPONSAVEL_ALTER,"
                    + "STATUS "
                    + "FROM Cad_Espec_Teste where ESP_MATERIAL = '" + pPerfilaberto + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle.setData_alter(this.getResultSet().getDate(1));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(4));
                modelFichaControle.setStatus(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControle;
    }

    public ArrayList<ModelFichaControle> getListaFichaValidacaoAcDAO() {
        ArrayList<ModelFichaControle> listaFichaControle = new ArrayList();
        ModelFichaControle modelFichaControle = new ModelFichaControle();
        try {
            this.conectar();
            this.executarSQL(
                    "Select Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "OEM,"
                    + "RESPONSAVEL_ALTER,"
                    + "PENDENCIA_ALTER,"
                    + "OBSERVACAO_ALTER"
                    + " from "
                    + "Qry_Espec_Teste "
                    + "WHERE (PENDENCIA_ALTER='Protótipo' or PENDENCIA_ALTER='Pendente' or PENDENCIA_ALTER='Restauração de Versão' or PENDENCIA_ALTER='Produção' or PENDENCIA_ALTER='Cópia de Ficha' or PENDENCIA_ALTER='Pré-Lançamento') and (OBSERVACAO_ALTER !=NULL OR OBSERVACAO_ALTER <> 'NULL' OR OBSERVACAO_ALTER !='' OR OBSERVACAO_ALTER <> '') ORDER BY DATA_ALTER asc"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControle = new ModelFichaControle();
                modelFichaControle.setData_alter(this.getResultSet().getDate(1));
                modelFichaControle.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControle.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControle.setOem(this.getResultSet().getString(4));
                modelFichaControle.setResponsavel_alter(this.getResultSet().getString(5));
                modelFichaControle.setPendencia_alter(this.getResultSet().getString(6));
                modelFichaControle.setObservacao_alter(this.getResultSet().getString(7));
                listaFichaControle.add(modelFichaControle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }
}
