/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

/**
 *
 * @author rsouza10
 */
public class ModelProducao {

    private int id;
    private int ordem;
    private String esp_linha;
    private int esp_material;
    private String esp_teste;
    private String esp_equipamento;
    private float minimo;
    private float maximo;
    private String unid_med;
    private String texto;
    private String referencia;
    private int frequencia;
    private String unid_freq;
    private String produto;
    private String origem;
    private String tipo_espec;
    private String espec_completo;
    private String freq_completo;
    private String lab;
    private String complemento;
    private int esp_composto;
    private String status;
    private String desc_teste;
    private String operacao;
    private String desc_material;
    private String projeto;
    private String oem;
    private String n_desenho;
    private String n_plano;
    private String tipo_linha;
    private String linha_setor;
    private String bpcs;
    private String diariobordo;
    private String composto;
    private String resultado;

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

    public String getUnid_med() {
        return unid_med;
    }

    public void setUnid_med(String unid_med) {
        this.unid_med = unid_med;
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

    public String getUnid_freq() {
        return unid_freq;
    }

    public void setUnid_freq(String unid_freq) {
        this.unid_freq = unid_freq;
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

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getDesc_material() {
        return desc_material;
    }

    public void setDesc_material(String desc_material) {
        this.desc_material = desc_material;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getN_desenho() {
        return n_desenho;
    }

    public void setN_desenho(String n_desenho) {
        this.n_desenho = n_desenho;
    }

    public String getN_plano() {
        return n_plano;
    }

    public void setN_plano(String n_plano) {
        this.n_plano = n_plano;
    }

    public String getTipo_linha() {
        return tipo_linha;
    }

    public void setTipo_linha(String tipo_linha) {
        this.tipo_linha = tipo_linha;
    }

    public String getLinha_setor() {
        return linha_setor;
    }

    public void setLinha_setor(String linha_setor) {
        this.linha_setor = linha_setor;
    }

    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public String getDiariobordo() {
        return diariobordo;
    }

    public void setDiariobordo(String diariobordo) {
        this.diariobordo = diariobordo;
    }

    public String getComposto() {
        return composto;
    }

    public void setComposto(String composto) {
        this.composto = composto;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ModelProducao{" + "id=" + id + ", ordem=" + ordem + ", esp_linha=" + esp_linha + ", esp_material=" + esp_material + ", esp_teste=" + esp_teste + ", esp_equipamento=" + esp_equipamento + ", minimo=" + minimo + ", maximo=" + maximo + ", unid_med=" + unid_med + ", texto=" + texto + ", referencia=" + referencia + ", frequencia=" + frequencia + ", unid_freq=" + unid_freq + ", produto=" + produto + ", origem=" + origem + ", tipo_espec=" + tipo_espec + ", espec_completo=" + espec_completo + ", freq_completo=" + freq_completo + ", lab=" + lab + ", complemento=" + complemento + ", esp_composto=" + esp_composto + ", status=" + status + ", desc_teste=" + desc_teste + ", operacao=" + operacao + ", desc_material=" + desc_material + ", projeto=" + projeto + ", oem=" + oem + ", n_desenho=" + n_desenho + ", n_plano=" + n_plano + ", tipo_linha=" + tipo_linha + ", linha_setor=" + linha_setor + ", bpcs=" + bpcs + ", diariobordo=" + diariobordo + ", composto=" + composto + ", resultado=" + resultado + '}';
    }

}
