/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.model;

/**
 * @author rsouza10
 */
public class ModelMaterial {

    private int id_material;
    private int material;
    private String bpcs;
    private String desc_material;
    private String mat_linha;
    private String mat_projeto;
    private String n_desenho;
    private String n_plano;
    private String imagem;
    private String imagemr;
    private String dupla_cavidade;

    public ModelMaterial() {
    }

    public int getId_material() {
        return this.id_material;
    }

    public int getMaterial() {
        return this.material;
    }

    public String getBpcs() {
        return this.bpcs;
    }

    public String getDesc_material() {
        return this.desc_material;
    }

    public String getMat_linha() {
        return this.mat_linha;
    }

    public String getMat_projeto() {
        return this.mat_projeto;
    }

    public String getN_desenho() {
        return this.n_desenho;
    }

    public String getN_plano() {
        return this.n_plano;
    }

    public String getImagem() {
        return this.imagem;
    }

    public String getImagemr() {
        return this.imagemr;
    }

    public String getDupla_cavidade() {
        return this.dupla_cavidade;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    public void setDesc_material(String desc_material) {
        this.desc_material = desc_material;
    }

    public void setMat_linha(String mat_linha) {
        this.mat_linha = mat_linha;
    }

    public void setMat_projeto(String mat_projeto) {
        this.mat_projeto = mat_projeto;
    }

    public void setN_desenho(String n_desenho) {
        this.n_desenho = n_desenho;
    }

    public void setN_plano(String n_plano) {
        this.n_plano = n_plano;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setImagemr(String imagemr) {
        this.imagemr = imagemr;
    }

    public void setDupla_cavidade(String dupla_cavidade) {
        this.dupla_cavidade = dupla_cavidade;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ModelMaterial)) return false;
        final ModelMaterial other = (ModelMaterial) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId_material() != other.getId_material()) return false;
        if (this.getMaterial() != other.getMaterial()) return false;
        final Object this$bpcs = this.getBpcs();
        final Object other$bpcs = other.getBpcs();
        if (this$bpcs == null ? other$bpcs != null : !this$bpcs.equals(other$bpcs)) return false;
        final Object this$desc_material = this.getDesc_material();
        final Object other$desc_material = other.getDesc_material();
        if (this$desc_material == null ? other$desc_material != null : !this$desc_material.equals(other$desc_material))
            return false;
        final Object this$mat_linha = this.getMat_linha();
        final Object other$mat_linha = other.getMat_linha();
        if (this$mat_linha == null ? other$mat_linha != null : !this$mat_linha.equals(other$mat_linha)) return false;
        final Object this$mat_projeto = this.getMat_projeto();
        final Object other$mat_projeto = other.getMat_projeto();
        if (this$mat_projeto == null ? other$mat_projeto != null : !this$mat_projeto.equals(other$mat_projeto))
            return false;
        final Object this$n_desenho = this.getN_desenho();
        final Object other$n_desenho = other.getN_desenho();
        if (this$n_desenho == null ? other$n_desenho != null : !this$n_desenho.equals(other$n_desenho)) return false;
        final Object this$n_plano = this.getN_plano();
        final Object other$n_plano = other.getN_plano();
        if (this$n_plano == null ? other$n_plano != null : !this$n_plano.equals(other$n_plano)) return false;
        final Object this$imagem = this.getImagem();
        final Object other$imagem = other.getImagem();
        if (this$imagem == null ? other$imagem != null : !this$imagem.equals(other$imagem)) return false;
        final Object this$imagemr = this.getImagemr();
        final Object other$imagemr = other.getImagemr();
        if (this$imagemr == null ? other$imagemr != null : !this$imagemr.equals(other$imagemr)) return false;
        final Object this$dupla_cavidade = this.getDupla_cavidade();
        final Object other$dupla_cavidade = other.getDupla_cavidade();
        if (this$dupla_cavidade == null ? other$dupla_cavidade != null : !this$dupla_cavidade.equals(other$dupla_cavidade))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ModelMaterial;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId_material();
        result = result * PRIME + this.getMaterial();
        final Object $bpcs = this.getBpcs();
        result = result * PRIME + ($bpcs == null ? 43 : $bpcs.hashCode());
        final Object $desc_material = this.getDesc_material();
        result = result * PRIME + ($desc_material == null ? 43 : $desc_material.hashCode());
        final Object $mat_linha = this.getMat_linha();
        result = result * PRIME + ($mat_linha == null ? 43 : $mat_linha.hashCode());
        final Object $mat_projeto = this.getMat_projeto();
        result = result * PRIME + ($mat_projeto == null ? 43 : $mat_projeto.hashCode());
        final Object $n_desenho = this.getN_desenho();
        result = result * PRIME + ($n_desenho == null ? 43 : $n_desenho.hashCode());
        final Object $n_plano = this.getN_plano();
        result = result * PRIME + ($n_plano == null ? 43 : $n_plano.hashCode());
        final Object $imagem = this.getImagem();
        result = result * PRIME + ($imagem == null ? 43 : $imagem.hashCode());
        final Object $imagemr = this.getImagemr();
        result = result * PRIME + ($imagemr == null ? 43 : $imagemr.hashCode());
        final Object $dupla_cavidade = this.getDupla_cavidade();
        result = result * PRIME + ($dupla_cavidade == null ? 43 : $dupla_cavidade.hashCode());
        return result;
    }

    public String toString() {
        return "ModelMaterial(id_material=" + this.getId_material() + ", material=" + this.getMaterial() + ", bpcs=" + this.getBpcs() + ", desc_material=" + this.getDesc_material() + ", mat_linha=" + this.getMat_linha() + ", mat_projeto=" + this.getMat_projeto() + ", n_desenho=" + this.getN_desenho() + ", n_plano=" + this.getN_plano() + ", imagem=" + this.getImagem() + ", imagemr=" + this.getImagemr() + ", dupla_cavidade=" + this.getDupla_cavidade() + ")";
    }
}
