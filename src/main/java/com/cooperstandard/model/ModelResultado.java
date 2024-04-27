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
public class ModelResultado {

    private int id;
    private int ordem;
    private String data;
    private String hora;
    private int registro;
    private int material;
    private String desc_material;
    private String cod_teste;
    private String desc_teste;
    private String operacao;
    private String equipamento;
    private float minimo;
    private float maximo;
    private String unid_medida;
    private String texto;
    private String espec_completo;
    private String referencia;
    private int frequencia;
    private String freq_completo;
    private String unid_frequencia;
    private String produto;
    private String linha;
    private String projeto;
    private String oem;
    private String n_desenho;
    private String n_plano;
    private String tipo_linha;
    private String linha_setor;
    private float encontrado_numerico;
    private String encontrado_obs;
    private String status;
    private String encontrado_texto;
    private Date datam;
    private String usuario;
    private String origem;
    private String tipo_espec;
    private String lab;
    private String bpcs;
    private String complemento;
    private int composto;
    private String diariobordo;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public String getDesc_material() {
        return desc_material;
    }

    public void setDesc_material(String desc_material) {
        this.desc_material = desc_material;
    }

    public String getCod_teste() {
        return cod_teste;
    }

    public void setCod_teste(String cod_teste) {
        this.cod_teste = cod_teste;
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

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
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

    public String getEspec_completo() {
        return espec_completo;
    }

    public void setEspec_completo(String espec_completo) {
        this.espec_completo = espec_completo;
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

    public String getFreq_completo() {
        return freq_completo;
    }

    public void setFreq_completo(String freq_completo) {
        this.freq_completo = freq_completo;
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

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
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

    public float getEncontrado_numerico() {
        return encontrado_numerico;
    }

    public void setEncontrado_numerico(float encontrado_numerico) {
        this.encontrado_numerico = encontrado_numerico;
    }

    public String getEncontrado_obs() {
        return encontrado_obs;
    }

    public void setEncontrado_obs(String encontrado_obs) {
        this.encontrado_obs = encontrado_obs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEncontrado_texto() {
        return encontrado_texto;
    }

    public void setEncontrado_texto(String encontrado_texto) {
        this.encontrado_texto = encontrado_texto;
    }

    public Date getDatam() {
        return datam;
    }

    public void setDatam(Date datam) {
        this.datam = datam;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getComposto() {
        return composto;
    }

    public void setComposto(int composto) {
        this.composto = composto;
    }

    public String getDiariobordo() {
        return diariobordo;
    }

    public void setDiariobordo(String diariobordo) {
        this.diariobordo = diariobordo;
    }

    @Override
    public String toString() {
        return "ModelResultado{" + "id=" + id + ", ordem=" + ordem + ", data=" + data + ", hora=" + hora + ", registro=" + registro + ", material=" + material + ", desc_material=" + desc_material + ", cod_teste=" + cod_teste + ", desc_teste=" + desc_teste + ", operacao=" + operacao + ", equipamento=" + equipamento + ", minimo=" + minimo + ", maximo=" + maximo + ", unid_medida=" + unid_medida + ", texto=" + texto + ", espec_completo=" + espec_completo + ", referencia=" + referencia + ", frequencia=" + frequencia + ", freq_completo=" + freq_completo + ", unid_frequencia=" + unid_frequencia + ", produto=" + produto + ", linha=" + linha + ", projeto=" + projeto + ", oem=" + oem + ", n_desenho=" + n_desenho + ", n_plano=" + n_plano + ", tipo_linha=" + tipo_linha + ", linha_setor=" + linha_setor + ", encontrado_numerico=" + encontrado_numerico + ", encontrado_obs=" + encontrado_obs + ", status=" + status + ", encontrado_texto=" + encontrado_texto + ", datam=" + datam + ", usuario=" + usuario + ", origem=" + origem + ", tipo_espec=" + tipo_espec + ", lab=" + lab + ", bpcs=" + bpcs + ", complemento=" + complemento + ", composto=" + composto + ", diariobordo=" + diariobordo + '}';
    }

}
