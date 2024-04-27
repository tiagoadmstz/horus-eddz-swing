/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.dao.acabamento;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelFichaControleQualidade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author rsouza10
 */
public class DAOFichaControleQualidadeAc extends ConexaoSql {

    public int salvarFichaControleQualidadeAcDAO(ModelFichaControleQualidade pModelFichaControleQualidade) {
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
                    + "'" + pModelFichaControleQualidade.getOrdem() + "',"
                    + "'" + pModelFichaControleQualidade.getEsp_linha() + "',"
                    + "'" + pModelFichaControleQualidade.getEsp_material() + "',"
                    + "'" + pModelFichaControleQualidade.getEsp_teste() + "',"
                    + "'" + pModelFichaControleQualidade.getEsp_equipamento() + "',"
                    + "'" + pModelFichaControleQualidade.getMinimo() + "',"
                    + "'" + pModelFichaControleQualidade.getMaximo() + "',"
                    + "'" + pModelFichaControleQualidade.getUnid_medida() + "',"
                    + "'" + pModelFichaControleQualidade.getTexto() + "',"
                    + "'" + pModelFichaControleQualidade.getReferencia() + "',"
                    + "'" + pModelFichaControleQualidade.getFrequencia() + "',"
                    + "'" + pModelFichaControleQualidade.getUnid_frequencia() + "',"
                    + "'" + pModelFichaControleQualidade.getProduto() + "',"
                    + "'" + pModelFichaControleQualidade.getOrigem() + "',"
                    + "'" + pModelFichaControleQualidade.getTipo_espec() + "',"
                    + "'" + pModelFichaControleQualidade.getEspec_completo() + "',"
                    + "'" + pModelFichaControleQualidade.getFreq_completo() + "',"
                    + "'" + pModelFichaControleQualidade.getLab() + "',"
                    + "'" + pModelFichaControleQualidade.getComplemento() + "',"
                    + "'" + pModelFichaControleQualidade.getResponsavel_alter() + "',"
                    + "'" + pModelFichaControleQualidade.getPendencia_alter() + "',"
                    + "'" + pModelFichaControleQualidade.getData_alter() + "',"
                    + "'" + pModelFichaControleQualidade.getObservacao_alter() + "',"
                    + "'" + pModelFichaControleQualidade.getDate_valid_alter() + "',"
                    + "'" + pModelFichaControleQualidade.getAlter_indentificacao() + "',"
                    + "'" + pModelFichaControleQualidade.getEsp_composto() + "',"
                    + "'" + pModelFichaControleQualidade.getStatus() + "',"
                    + "'" + pModelFichaControleQualidade.getAmostra() + "'"
                    + ");"
            );

        } catch (Exception e) {
            if (e.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                JOptionPane.showMessageDialog(null, "Código do teste duplicado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
            }
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelFichaControleQualidade getFichaControleQualidadeAcDAO(int pCodigo) {
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
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
                    + "AMOSTRA "
                    + "FROM "
                    + "Qry_Cadastro"
                    + " WHERE"
                    + " ID_ESPEC_TESTE= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControleQualidade.setId(this.getResultSet().getInt(1));
                modelFichaControleQualidade.setOrdem(this.getResultSet().getInt(2));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControleQualidade.setEsp_teste(this.getResultSet().getString(5));
                modelFichaControleQualidade.setEsp_equipamento(this.getResultSet().getString(6));
                modelFichaControleQualidade.setMinimo(this.getResultSet().getFloat(7));
                modelFichaControleQualidade.setMaximo(this.getResultSet().getFloat(8));
                modelFichaControleQualidade.setUnid_medida(this.getResultSet().getString(9));
                modelFichaControleQualidade.setTexto(this.getResultSet().getString(10));
                modelFichaControleQualidade.setReferencia(this.getResultSet().getString(11));
                modelFichaControleQualidade.setFrequencia(this.getResultSet().getInt(12));
                modelFichaControleQualidade.setUnid_frequencia(this.getResultSet().getString(13));
                modelFichaControleQualidade.setProduto(this.getResultSet().getString(14));
                modelFichaControleQualidade.setOrigem(this.getResultSet().getString(15));
                modelFichaControleQualidade.setTipo_espec(this.getResultSet().getString(16));
                modelFichaControleQualidade.setEspec_completo(this.getResultSet().getString(17));
                modelFichaControleQualidade.setFreq_completo(this.getResultSet().getString(18));
                modelFichaControleQualidade.setLab(this.getResultSet().getString(19));
                modelFichaControleQualidade.setComplemento(this.getResultSet().getString(20));
                modelFichaControleQualidade.setResponsavel_alter(this.getResultSet().getString(21));
                modelFichaControleQualidade.setPendencia_alter(this.getResultSet().getString(22));
                modelFichaControleQualidade.setData_alter(this.getResultSet().getDate(23));
                modelFichaControleQualidade.setHora_alter(this.getResultSet().getTime(24));
                modelFichaControleQualidade.setObservacao_alter(this.getResultSet().getString(25));
                modelFichaControleQualidade.setDate_valid_alter(this.getResultSet().getString(26));
                modelFichaControleQualidade.setAlter_indentificacao(this.getResultSet().getInt(27));
                modelFichaControleQualidade.setEsp_composto(this.getResultSet().getInt(28));
                modelFichaControleQualidade.setDesc_teste(this.getResultSet().getString(29));
                modelFichaControleQualidade.setAmostra(this.getResultSet().getString(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControleQualidade;
    }

    public ModelFichaControleQualidade getFichaControleQualidadeAcDAO(String pNome) {
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
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
                    + "AMOSTRA "
                    + "FROM "
                    + "Cad_Espec_Teste"
                    + " WHERE"
                    + " ESP_TESTE= '" + pNome + "' and OPE_SETOR='Acabamento'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControleQualidade.setId(this.getResultSet().getInt(1));
                modelFichaControleQualidade.setOrdem(this.getResultSet().getInt(2));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControleQualidade.setEsp_teste(this.getResultSet().getString(5));
                modelFichaControleQualidade.setEsp_equipamento(this.getResultSet().getString(6));
                modelFichaControleQualidade.setMinimo(this.getResultSet().getFloat(7));
                modelFichaControleQualidade.setMaximo(this.getResultSet().getFloat(8));
                modelFichaControleQualidade.setUnid_medida(this.getResultSet().getString(9));
                modelFichaControleQualidade.setTexto(this.getResultSet().getString(10));
                modelFichaControleQualidade.setReferencia(this.getResultSet().getString(11));
                modelFichaControleQualidade.setFrequencia(this.getResultSet().getInt(12));
                modelFichaControleQualidade.setUnid_frequencia(this.getResultSet().getString(13));
                modelFichaControleQualidade.setProduto(this.getResultSet().getString(14));
                modelFichaControleQualidade.setOrigem(this.getResultSet().getString(15));
                modelFichaControleQualidade.setTipo_espec(this.getResultSet().getString(16));
                modelFichaControleQualidade.setEspec_completo(this.getResultSet().getString(17));
                modelFichaControleQualidade.setFreq_completo(this.getResultSet().getString(18));
                modelFichaControleQualidade.setLab(this.getResultSet().getString(19));
                modelFichaControleQualidade.setComplemento(this.getResultSet().getString(20));
                modelFichaControleQualidade.setResponsavel_alter(this.getResultSet().getString(21));
                modelFichaControleQualidade.setPendencia_alter(this.getResultSet().getString(22));
                modelFichaControleQualidade.setData_alter(this.getResultSet().getDate(23));
                modelFichaControleQualidade.setHora_alter(this.getResultSet().getTime(24));
                modelFichaControleQualidade.setObservacao_alter(this.getResultSet().getString(25));
                modelFichaControleQualidade.setDate_valid_alter(this.getResultSet().getString(26));
                modelFichaControleQualidade.setAlter_indentificacao(this.getResultSet().getInt(27));
                modelFichaControleQualidade.setEsp_composto(this.getResultSet().getInt(28));
                modelFichaControleQualidade.setStatus(this.getResultSet().getString(29));
                modelFichaControleQualidade.setAmostra(this.getResultSet().getString(30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControleQualidade;
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeAcDAO(String perfil) {
        ArrayList<ModelFichaControleQualidade> listaFichaControleQualidade = new ArrayList();
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
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
                    + "FROM Qry_Cadastro where ESP_MATERIAL='" + perfil + "' and (PENDENCIA_ALTER='Protótipo' or PENDENCIA_ALTER='Produção' or PENDENCIA_ALTER='Cópia de Ficha' or PENDENCIA_ALTER='Pré-Lançamento') ORDER BY ORDEM asc"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFichaControleQualidade = new ModelFichaControleQualidade();
                modelFichaControleQualidade.setId(this.getResultSet().getInt(1));
                modelFichaControleQualidade.setOrdem(this.getResultSet().getInt(2));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControleQualidade.setEsp_equipamento(this.getResultSet().getString(5));
                modelFichaControleQualidade.setDesc_teste(this.getResultSet().getString(6));
                modelFichaControleQualidade.setEsp_teste(this.getResultSet().getString(7));
                modelFichaControleQualidade.setComplemento(this.getResultSet().getString(8));
                modelFichaControleQualidade.setTipo_espec(this.getResultSet().getString(9));
                modelFichaControleQualidade.setMinimo(this.getResultSet().getFloat(10));
                modelFichaControleQualidade.setMaximo(this.getResultSet().getFloat(11));
                modelFichaControleQualidade.setUnid_medida(this.getResultSet().getString(12));
                modelFichaControleQualidade.setTexto(this.getResultSet().getString(13));
                modelFichaControleQualidade.setReferencia(this.getResultSet().getString(14));
                modelFichaControleQualidade.setFrequencia(this.getResultSet().getInt(15));
                modelFichaControleQualidade.setUnid_frequencia(this.getResultSet().getString(16));
                modelFichaControleQualidade.setProduto(this.getResultSet().getString(17));
                modelFichaControleQualidade.setOrigem(this.getResultSet().getString(18));
                modelFichaControleQualidade.setLab(this.getResultSet().getString(19));
                modelFichaControleQualidade.setAmostra(this.getResultSet().getString(20));
                modelFichaControleQualidade.setPendencia_alter(this.getResultSet().getString(21));
                modelFichaControleQualidade.setEsp_composto(this.getResultSet().getInt(22));

                listaFichaControleQualidade.add(modelFichaControleQualidade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControleQualidade;
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaControleQualidadeEditAcDAO(String perfil) {
        ArrayList<ModelFichaControleQualidade> listaModelFichaControleQualidade = new ArrayList();
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
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
                    + "ALTER_IDENTIFICACAO "
                    + "FROM Qry_Cadastro WHERE ESP_MATERIAL='" + perfil + "' ORDER BY ORDEM asc"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFichaControleQualidade = new ModelFichaControleQualidade();
                modelFichaControleQualidade.setId(this.getResultSet().getInt(1));
                modelFichaControleQualidade.setOrdem(this.getResultSet().getInt(2));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(3));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(4));
                modelFichaControleQualidade.setEsp_equipamento(this.getResultSet().getString(5));
                modelFichaControleQualidade.setDesc_teste(this.getResultSet().getString(6));
                modelFichaControleQualidade.setEsp_teste(this.getResultSet().getString(7));
                modelFichaControleQualidade.setComplemento(this.getResultSet().getString(8));
                modelFichaControleQualidade.setTipo_espec(this.getResultSet().getString(9));
                modelFichaControleQualidade.setMinimo(this.getResultSet().getFloat(10));
                modelFichaControleQualidade.setMaximo(this.getResultSet().getFloat(11));
                modelFichaControleQualidade.setUnid_medida(this.getResultSet().getString(12));
                modelFichaControleQualidade.setTexto(this.getResultSet().getString(13));
                modelFichaControleQualidade.setReferencia(this.getResultSet().getString(14));
                modelFichaControleQualidade.setFrequencia(this.getResultSet().getInt(15));
                modelFichaControleQualidade.setUnid_frequencia(this.getResultSet().getString(16));
                modelFichaControleQualidade.setProduto(this.getResultSet().getString(17));
                modelFichaControleQualidade.setOrigem(this.getResultSet().getString(18));
                modelFichaControleQualidade.setLab(this.getResultSet().getString(19));
                modelFichaControleQualidade.setAmostra(this.getResultSet().getString(20));
                modelFichaControleQualidade.setPendencia_alter(this.getResultSet().getString(21));
                modelFichaControleQualidade.setEsp_composto(this.getResultSet().getInt(22));
                modelFichaControleQualidade.setAlter_indentificacao(this.getResultSet().getInt(23));

                listaModelFichaControleQualidade.add(modelFichaControleQualidade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaModelFichaControleQualidade;
    }

    public boolean atualizarFichaControleQualidadeAcDAO(ModelFichaControleQualidade pModelFichaControleQualidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste SET "
                    + " ORDEM= '" + pModelFichaControleQualidade.getOrdem() + "',"
                    + " ESP_LINHA= '" + pModelFichaControleQualidade.getEsp_linha() + "',"
                    + " ESP_MATERIAL= '" + pModelFichaControleQualidade.getEsp_material() + "',"
                    + " ESP_TESTE= '" + pModelFichaControleQualidade.getEsp_teste() + "',"
                    + " ESP_EQUIPAMENTO= '" + pModelFichaControleQualidade.getEsp_equipamento() + "',"
                    + " MINIMO= '" + pModelFichaControleQualidade.getMinimo() + "',"
                    + " MAXIMO= '" + pModelFichaControleQualidade.getMaximo() + "',"
                    + " UNID_MEDIDA= '" + pModelFichaControleQualidade.getUnid_medida() + "',"
                    + " TEXTO= '" + pModelFichaControleQualidade.getTexto() + "',"
                    + " REFERENCIA= '" + pModelFichaControleQualidade.getReferencia() + "',"
                    + " FREQUENCIA= '" + pModelFichaControleQualidade.getFrequencia() + "',"
                    + " UNID_FREQUENCIA= '" + pModelFichaControleQualidade.getUnid_frequencia() + "',"
                    + " PRODUTO= '" + pModelFichaControleQualidade.getProduto() + "',"
                    + " ORIGEM= '" + pModelFichaControleQualidade.getOrigem() + "',"
                    + " TIPO_ESPEC= '" + pModelFichaControleQualidade.getTipo_espec() + "',"
                    + " ESPEC_COMPLETO= '" + pModelFichaControleQualidade.getEspec_completo() + "',"
                    + " FREQ_COMPLETO= '" + pModelFichaControleQualidade.getFreq_completo() + "',"
                    + " LAB= '" + pModelFichaControleQualidade.getLab() + "',"
                    + " COMPLEMENTO= '" + pModelFichaControleQualidade.getComplemento() + "',"
                    + "RESPONSAVEL_ALTER='" + pModelFichaControleQualidade.getResponsavel_alter() + "',"
                    + "PENDENCIA_ALTER='" + pModelFichaControleQualidade.getPendencia_alter() + "',"
                    + "OBSERVACAO_ALTER='" + pModelFichaControleQualidade.getObservacao_alter() + "',"
                    + "DATA_ALTER='" + pModelFichaControleQualidade.getData_alter() + "',"
                    + "ALTER_IDENTIFICACAO='" + pModelFichaControleQualidade.getAlter_indentificacao() + "',"
                    + "ESP_COMPOSTO='" + pModelFichaControleQualidade.getEsp_composto() + "',"
                    + "AMOSTRA='" + pModelFichaControleQualidade.getAmostra() + "'"
                    + " WHERE "
                    + " ID_ESPEC_TESTE= '" + pModelFichaControleQualidade.getId() + "'"
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

    public boolean excluirFichaControleQualidadeAcDAO(int pCodigo) {
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

    public boolean updatStatusAc(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set PENDENCIA_ALTER='" + pModelFichaControleQualidade.getPendencia_alter() + "' where ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean updateProducaoStatusAc(ModelFichaControleQualidade pModelFichaControleQualidade, String perfilupdat) {
        try {
            this.conectar();
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String dateString = df.format(currentDate);

            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String values = dateString;
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set PENDENCIA_ALTER='" + pModelFichaControleQualidade.getPendencia_alter() + "',  DATE_VALIDE_ALTER='" + values + "', HORA_ALTER='" + value0 + "' where ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean CopiaHistoricoAc(String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "INSERT INTO Histo_Ficha_Controle (ORDEM,HISTO_LINHA,HISTO_MATERIAL,HISTO_TESTE,HISTO_EQUIPAMENTO,HISTO_MINIMO,HISTO_MAXIMO,HISTO_UNID_MEDIDA,HISTO_TEXTO,HISTO_REFERENCIA,"
                    + "HISTO_FREQUENCIA,HISTO_UNID_FREQUENCIA,HISTO_PRODUTO,HISTO_ORIGEM,HISTO_TIPO_ESPEC,HISTO_ESPEC_COMPLEMENTO,HISTO_FREQ_COMPLETO,HISTO_LAB,HISTO_COMPLEMENTO,HISTO_RESPONSAVEL,HISTO_PENDENCIA,HISTO_DATA_HISTO,HISTO_OBSERVACAO,HISTO_DATE_VALID,ALTER_IDENTIFICACAO,HISTO_HORA,HISTO_COMPOSTO, HISTO_STATUS, HISTO_AMOSTRA) SELECT  ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,RESPONSAVEL_ALTER,PENDENCIA_ALTER,DATA_ALTER,OBSERVACAO_ALTER,DATE_VALIDE_ALTER,ALTER_IDENTIFICACAO,HORA_ALTER,ESP_COMPOSTO,STATUS, AMOSTRA FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean CopiaFichaAc(String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "INSERT INTO Ficha_Controle (ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS, AMOSTRA )"
                    + "SELECT ORDEM ,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,"
                    + "LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS, AMOSTRA FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean DeletaFichaControleAc(String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean DeletaFichaControleProducaoAc(String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Ficha_Controle WHERE ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean DeletaTesteRemovidoAc(String perfilupdat) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    " DELETE FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + perfilupdat + "' and ALTER_IDENTIFICACAO='6'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean DataAlteracaoAc(String perfilupdat) {
        try {
            this.conectar();
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String dateString = df.format(currentDate);

            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String values = dateString;
            return this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Espec_Teste set  DATA_ALTER='" + values + "', HORA_ALTER='" + value0 + "' where ESP_MATERIAL='" + perfilupdat + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelFichaControleQualidade> getListaFichaemAbertoAlterAcDAO() {
        ArrayList<ModelFichaControleQualidade> listaFichaControle = new ArrayList();
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT Distinct "
                    + "DATA_ALTER,"
                    + "ESP_LINHA,"
                    + "ESP_MATERIAL,"
                    + "RESPONSAVEL_ALTER "
                    + "FROM Qry_Espec_Teste where (PENDENCIA_ALTER ='Alteração Qualidade') and (RESPONSAVEL_ALTER !=NULL OR RESPONSAVEL_ALTER <> 'NULL' OR RESPONSAVEL_ALTER !='' OR RESPONSAVEL_ALTER <> '') and Setor  ='Acabamento' order by DATA_ALTER DESC"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelFichaControleQualidade = new ModelFichaControleQualidade();
                modelFichaControleQualidade.setData_alter(this.getResultSet().getDate(1));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControleQualidade.setResponsavel_alter(this.getResultSet().getString(4));
                listaFichaControle.add(modelFichaControleQualidade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaFichaControle;
    }

    public ModelFichaControleQualidade getFichaAcDAO(int pPerfilaberto) {
        ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
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
                modelFichaControleQualidade.setData_alter(this.getResultSet().getDate(1));
                modelFichaControleQualidade.setEsp_linha(this.getResultSet().getString(2));
                modelFichaControleQualidade.setEsp_material(this.getResultSet().getInt(3));
                modelFichaControleQualidade.setResponsavel_alter(this.getResultSet().getString(4));
                modelFichaControleQualidade.setStatus(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFichaControleQualidade;
    }
}
