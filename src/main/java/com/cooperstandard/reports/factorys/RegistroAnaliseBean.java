package com.cooperstandard.reports.factorys;

import java.io.Serializable;

public class RegistroAnaliseBean implements Serializable {

    private static final long serialVersionUID = 4522964550853547505L;
    private int rcperfil, ordem, notafiscal;
    private String dperfil, fornecedor, dteste, especificacao, aprovado, bpcs, rcomplemento, etiqueta
            , responsavel, lote, amostra, validade, quantidade, unid_quantidade, laudo, certificado, datacriacao
            , placa, resultado_fornecedor, resultado, r1, r2, r3;

    public RegistroAnaliseBean() {
    }

    public RegistroAnaliseBean(int rcperfil, int ordem, int notafiscal, String dperfil, String fornecedor, String dteste, String especificacao, String aprovado, String bpcs, String rcomplemento, String etiqueta, String responsavel, String lote, String amostra, String validade, String quantidade, String unid_quantidade, String laudo, String certificado, String datacriacao, String placa, String resultado_fornecedor, String resultado, String r1, String r2, String r3) {
        this.rcperfil = rcperfil;
        this.ordem = ordem;
        this.notafiscal = notafiscal;
        this.dperfil = dperfil;
        this.fornecedor = fornecedor;
        this.dteste = dteste;
        this.especificacao = especificacao;
        this.aprovado = aprovado;
        this.bpcs = bpcs;
        this.rcomplemento = rcomplemento;
        this.etiqueta = etiqueta;
        this.responsavel = responsavel;
        this.lote = lote;
        this.amostra = amostra;
        this.validade = validade;
        this.quantidade = quantidade;
        this.unid_quantidade = unid_quantidade;
        this.laudo = laudo;
        this.certificado = certificado;
        this.datacriacao = datacriacao;
        this.placa = placa;
        this.resultado_fornecedor = resultado_fornecedor;
        this.resultado = resultado;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public RegistroAnaliseBean(RegistroAnaliseBean RegistroAnalisBean) {
        copiar(RegistroAnalisBean);
    }

    private void copiar(RegistroAnaliseBean RegistroAnalisBean) {
        this.rcperfil = RegistroAnalisBean.getRcperfil();
        this.ordem = RegistroAnalisBean.getOrdem();
        this.notafiscal = RegistroAnalisBean.getNotafiscal();
        this.dperfil = RegistroAnalisBean.getDperfil();
        this.fornecedor = RegistroAnalisBean.getFornecedor();
        this.dteste = RegistroAnalisBean.getDteste();
        this.especificacao = RegistroAnalisBean.getEspecificacao();
        this.aprovado = RegistroAnalisBean.getAprovado();
        this.bpcs = RegistroAnalisBean.getBpcs();
        this.rcomplemento = RegistroAnalisBean.getRcomplemento();
        this.etiqueta = RegistroAnalisBean.getEtiqueta();
        this.responsavel = RegistroAnalisBean.getResponsavel();
        this.lote = RegistroAnalisBean.getLote();
        this.amostra = RegistroAnalisBean.getAmostra();
        this.validade = RegistroAnalisBean.getValidade();
        this.quantidade = RegistroAnalisBean.getQuantidade();
        this.unid_quantidade = RegistroAnalisBean.getUnid_quantidade();
        this.laudo = RegistroAnalisBean.getLaudo();
        this.certificado = RegistroAnalisBean.getCertificado();
        this.datacriacao = RegistroAnalisBean.getDatacriacao();
        this.placa = RegistroAnalisBean.getPlaca();
        this.resultado_fornecedor = RegistroAnalisBean.getResultado_fornecedor();
        this.resultado = RegistroAnalisBean.getResultado();
        this.r1 = RegistroAnalisBean.getR1();
        this.r2 = RegistroAnalisBean.getR2();
        this.r3 = RegistroAnalisBean.getR3();
    }

    public int getRcperfil() {
        return rcperfil;
    }

    public void setRcperfil(int rcperfil) {
        this.rcperfil = rcperfil;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(int notafiscal) {
        this.notafiscal = notafiscal;
    }

    public String getDperfil() {
        return dperfil;
    }

    public void setDperfil(String dperfil) {
        this.dperfil = dperfil;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDteste() {
        return dteste;
    }

    public void setDteste(String dteste) {
        this.dteste = dteste;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getAprovado() {
        return aprovado;
    }

    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }

    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public String getRcomplemento() {
        return rcomplemento;
    }

    public void setRcomplemento(String rcomplemento) {
        this.rcomplemento = rcomplemento;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getAmostra() {
        return amostra;
    }

    public void setAmostra(String amostra) {
        this.amostra = amostra;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnid_quantidade() {
        return unid_quantidade;
    }

    public void setUnid_quantidade(String unid_quantidade) {
        this.unid_quantidade = unid_quantidade;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getResultado_fornecedor() {
        return resultado_fornecedor;
    }

    public void setResultado_fornecedor(String resultado_fornecedor) {
        this.resultado_fornecedor = resultado_fornecedor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    @Override
    public String toString() {
        return "RegistroAnaliseBean{" + "rcperfil=" + rcperfil + ", ordem=" + ordem + ", notafiscal=" + notafiscal + ", dperfil=" + dperfil + ", fornecedor=" + fornecedor + ", dteste=" + dteste + ", especificacao=" + especificacao + ", aprovado=" + aprovado + ", bpcs=" + bpcs + ", rcomplemento=" + rcomplemento + ", etiqueta=" + etiqueta + ", responsavel=" + responsavel + ", lote=" + lote + ", amostra=" + amostra + ", validade=" + validade + ", quantidade=" + quantidade + ", unid_quantidade=" + unid_quantidade + ", laudo=" + laudo + ", certificado=" + certificado + ", datacriacao=" + datacriacao + ", placa=" + placa + ", resultado_fornecedor=" + resultado_fornecedor + ", resultado=" + resultado + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + '}';
    }

}
