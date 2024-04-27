package com.cooperstandard.entitie;

import com.cooperstandard.converters.LocalDateTimeConverter;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Velocidade_Perfil")
@NamedQueries(value = {
    @NamedQuery(name = "velocidade.findAll", query = "SELECT m FROM velocidade AS m")
    ,@NamedQuery(name = "velocidade.findByVelocidade", query = "SELECT m FROM velocidade AS m WHERE m.id = :paramId")
})
public class velocidade implements Serializable {

    private long id;
    private LocalDateTime data_cadastro;
    private float velocidade;
    private material id_material;
    private float peso;

    public velocidade() {
    }

    public velocidade(long id, LocalDateTime data_cadastro, float velocidade, material id_material, float peso) {
        this.id = id;
        this.data_cadastro = data_cadastro;
        this.velocidade = velocidade;
        this.id_material = id_material;
        this.peso = peso;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    public material getId_material() {
        return id_material;
    }

    public void setId_material(material id_material) {
        this.id_material = id_material;
    }

    @Column(name = "DATA_CADASTRO", columnDefinition = "datetime")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    @Column(name = "VELOCIDADE")
    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
    @Column(name = "PESO")
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "velocidade{" + "id=" + id + ", data_cadastro=" + data_cadastro + ", velocidade=" + velocidade + ", id_material=" + id_material + ", peso=" + peso + '}';
    }


}
