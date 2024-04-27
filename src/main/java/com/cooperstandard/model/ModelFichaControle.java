/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author rsouza10
 */
public class ModelFichaControle {

    private int id;
    private int ordem;
    private String esp_linha;
    private int esp_material;
    private String esp_teste;
    private String esp_equipamento;
    private float minimo;
    private float maximo;
    private String unid_medida;
    private String texto;
    private String referencia;
    private int frequencia;
    private String unid_frequencia;
    private String produto;
    private String origem;
    private String tipo_espec;
    private String espec_completo;
    private String freq_completo;
    private String lab;
    private String complemento;
    private String responsavel_alter;
    private String pendencia_alter;
    private Date data_alter;
    private Time hora_alter;
    private String observacao_alter;
    private String date_valid_alter;
    private int alter_indentificacao;
    private int esp_composto;
    private String status;
    private String desc_teste;
    private String oem;
    private String amostra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getEsp_linha() {
        return esp_linha;
    }

    public void setEsp_linha(String esp_linha) {
        this.esp_linha = esp_linha;
    }

    public int getEsp_material() {
        return esp_material;
    }

    public void setEsp_material(int esp_material) {
        this.esp_material = esp_material;
    }

    public String getEsp_teste() {
        return esp_teste;
    }

    public void setEsp_teste(String esp_teste) {
        this.esp_teste = esp_teste;
    }

    public String getEsp_equipamento() {
        return esp_equipamento;
    }

    public void setEsp_equipamento(String esp_equipamento) {
        this.esp_equipamento = esp_equipamento;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public String getUnid_medida() {
        return unid_medida;
    }

    public void setUnid_medida(String unid_medida) {
        this.unid_medida = unid_medida;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getUnid_frequencia() {
        return unid_frequencia;
    }

    public void setUnid_frequencia(String unid_frequencia) {
        this.unid_frequencia = unid_frequencia;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipo_espec() {
        return tipo_espec;
    }

    public void setTipo_espec(String tipo_espec) {
        this.tipo_espec = tipo_espec;
    }

    public String getEspec_completo() {
        return espec_completo;
    }

    public void setEspec_completo(String espec_completo) {
        this.espec_completo = espec_completo;
    }

    public String getFreq_completo() {
        return freq_completo;
    }

    public void setFreq_completo(String freq_completo) {
        this.freq_completo = freq_completo;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getResponsavel_alter() {
        return responsavel_alter;
    }

    public void setResponsavel_alter(String responsavel_alter) {
        this.responsavel_alter = responsavel_alter;
    }

    public String getPendencia_alter() {
        return pendencia_alter;
    }

    public void setPendencia_alter(String pendencia_alter) {
        this.pendencia_alter = pendencia_alter;
    }

    public Date getData_alter() {
        return data_alter;
    }

    public void setData_alter(Date data_alter) {
        this.data_alter = data_alter;
    }

    public Time getHora_alter() {
        return hora_alter;
    }

    public void setHora_alter(Time hora_alter) {
        this.hora_alter = hora_alter;
    }

    public String getObservacao_alter() {
        return observacao_alter;
    }

    public void setObservacao_alter(String observacao_alter) {
        this.observacao_alter = observacao_alter;
    }

    public String getDate_valid_alter() {
        return date_valid_alter;
    }

    public void setDate_valid_alter(String date_valid_alter) {
        this.date_valid_alter = date_valid_alter;
    }

    public int getAlter_indentificacao() {
        return alter_indentificacao;
    }

    public void setAlter_indentificacao(int alter_indentificacao) {
        this.alter_indentificacao = alter_indentificacao;
    }

    public int getEsp_composto() {
        return esp_composto;
    }

    public void setEsp_composto(int esp_composto) {
        this.esp_composto = esp_composto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc_teste() {
        return desc_teste;
    }

    public void setDesc_teste(String desc_teste) {
        this.desc_teste = desc_teste;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getAmostra() {
        return amostra;
    }

    public void setAmostra(String amostra) {
        this.amostra = amostra;
    }

    @Override
    public String toString() {
        return "ModelFichaControle{" + "id=" + id + ", ordem=" + ordem + ", esp_linha=" + esp_linha + ", esp_material=" + esp_material + ", esp_teste=" + esp_teste + ", esp_equipamento=" + esp_equipamento + ", minimo=" + minimo + ", maximo=" + maximo + ", unid_medida=" + unid_medida + ", texto=" + texto + ", referencia=" + referencia + ", frequencia=" + frequencia + ", unid_frequencia=" + unid_frequencia + ", produto=" + produto + ", origem=" + origem + ", tipo_espec=" + tipo_espec + ", espec_completo=" + espec_completo + ", freq_completo=" + freq_completo + ", lab=" + lab + ", complemento=" + complemento + ", responsavel_alter=" + responsavel_alter + ", pendencia_alter=" + pendencia_alter + ", data_alter=" + data_alter + ", hora_alter=" + hora_alter + ", observacao_alter=" + observacao_alter + ", date_valid_alter=" + date_valid_alter + ", alter_indentificacao=" + alter_indentificacao + ", esp_composto=" + esp_composto + ", status=" + status + ", desc_teste=" + desc_teste + ", oem=" + oem + ", amostra=" + amostra + '}';
    }

}
