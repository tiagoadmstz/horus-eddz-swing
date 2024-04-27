package com.cooperstandard.entitie;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Cad_Material")
@NamedQueries(value = {
    @NamedQuery(name = "material.findAll", query = "SELECT m FROM material AS m")
    ,@NamedQuery(name = "material.findByMaterial", query = "SELECT m FROM material AS m WHERE m.id_material = :paramId")
})
public class material implements Serializable {

    private static final long serialVersionUID = 5665477236496962874L;
    private int id_material, material;
    private String desc_material, mat_linha, mat_projeto, n_desenho, n_plano, bpcs, observacao, image, imagerod;
    private float custo, meta_limite, meta_intermediaria, meta_ideal;
    private List<encolhimento> c_id;
    private List<velocidade> v_id;
    private List<ddz> d_id;

    public material() {
    }

    public material(int id_material, int material, String desc_material, String mat_linha, String mat_projeto, String n_desenho, String n_plano, String bpcs, String observacao, String image, String imagerod, float custo, float meta_limite, float meta_intermediaria, float meta_ideal, List<encolhimento> c_id, List<velocidade> v_id, List<ddz> d_id) {
        this.id_material = id_material;
        this.material = material;
        this.desc_material = desc_material;
        this.mat_linha = mat_linha;
        this.mat_projeto = mat_projeto;
        this.n_desenho = n_desenho;
        this.n_plano = n_plano;
        this.bpcs = bpcs;
        this.observacao = observacao;
        this.image = image;
        this.imagerod = imagerod;
        this.custo = custo;
        this.meta_limite = meta_limite;
        this.meta_intermediaria = meta_intermediaria;
        this.meta_ideal = meta_ideal;
        this.c_id = c_id;
        this.v_id = v_id;
        this.d_id = d_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
    @Id
    @Column(name = "MATERIAL")
    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    @Column(name = "DESC_MATERIAL", length = 255)
    public String getDesc_material() {
        return desc_material;
    }

    public void setDesc_material(String desc_material) {
        this.desc_material = desc_material;
    }

    @Column(name = "MAT_LINHA", length = 50)
    public String getMat_linha() {
        return mat_linha;
    }

    public void setMat_linha(String mat_linha) {
        this.mat_linha = mat_linha;
    }

    @Column(name = "MAT_PROJETO", length = 50)
    public String getMat_projeto() {
        return mat_projeto;
    }

    public void setMat_projeto(String mat_projeto) {
        this.mat_projeto = mat_projeto;
    }

    @Column(name = "N_DESENHO", length = 100)
    public String getN_desenho() {
        return n_desenho;
    }

    public void setN_desenho(String n_desenho) {
        this.n_desenho = n_desenho;
    }

    @Column(name = "N_PLANO", length = 50)
    public String getN_plano() {
        return n_plano;
    }

    public void setN_plano(String n_plano) {
        this.n_plano = n_plano;
    }

    @Column(name = "BPCS", length = 10)
    public String getBpcs() {
        return bpcs;
    }

    public void setBpcs(String bpcs) {
        this.bpcs = bpcs;
    }

    @Column(name = "OBSERVACAO", length = 500)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Column(name = "IMAGE", length = 150)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "IMAGEROD", length = 255)
    public String getImagerod() {
        return imagerod;
    }

    public void setImagerod(String imagerod) {
        this.imagerod = imagerod;
    }

    @OneToMany(mappedBy = "id_material")
    public List<encolhimento> getC_id() {
        return c_id;
    }

    public void setC_id(List<encolhimento> c_id) {
        this.c_id = c_id;
    }

    @OneToMany(mappedBy = "id_material")
    public List<velocidade> getV_id() {
        return v_id;
    }

    public void setV_id(List<velocidade> v_id) {
        this.v_id = v_id;
    }

    @Column(name = "CUSTO")
    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    @Column(name = "META_LIMITE")
    public float getMeta_limite() {
        return meta_limite;
    }

    public void setMeta_limite(float meta_limite) {
        this.meta_limite = meta_limite;
    }

    @Column(name = "META_INTERMEDIARIA")
    public float getMeta_intermediaria() {
        return meta_intermediaria;
    }

    public void setMeta_intermediaria(float meta_intermediaria) {
        this.meta_intermediaria = meta_intermediaria;
    }

    @Column(name = "META_IDEAL")
    public float getMeta_ideal() {
        return meta_ideal;
    }

    public void setMeta_ideal(float meta_ideal) {
        this.meta_ideal = meta_ideal;
    }

    @OneToMany(mappedBy = "id_m")
    public List<ddz> getD_id() {
        return d_id;
    }

    public void setD_id(List<ddz> d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "material{" + "id_material=" + id_material + ", material=" + material + ", desc_material=" + desc_material + ", mat_linha=" + mat_linha + ", mat_projeto=" + mat_projeto + ", n_desenho=" + n_desenho + ", n_plano=" + n_plano + ", bpcs=" + bpcs + ", observacao=" + observacao + ", image=" + image + ", imagerod=" + imagerod + ", custo=" + custo + ", meta_limite=" + meta_limite + ", meta_intermediaria=" + meta_intermediaria + ", meta_ideal=" + meta_ideal + ", c_id=" + c_id + ", v_id=" + v_id + ", d_id=" + d_id + '}';
    }

}
