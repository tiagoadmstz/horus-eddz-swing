package com.cooperstandard.entitie;

import com.cooperstandard.converters.LocalDateTimeConverter;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "L03")
@NamedQueries(value = {
    @NamedQuery(name = "l03.findAll", query = "SELECT aa FROM L03 AS aa")
})
@SequenceGenerator(name = "seq_l03", allocationSize = 1, initialValue = 1)
public class L03 implements Serializable {

    private static final long serialVersionUID = -7009408827314104371L;

    private LocalDateTime e3timestamp;
    private float exta_indinv1;

    public L03() {
    }

    public L03(LocalDateTime e3timestamp, float exta_indinv1) {
        this.e3timestamp = e3timestamp;
        this.exta_indinv1 = exta_indinv1;
    }

    @Id
    @Column(name = "E3TimeStamp", columnDefinition = "timestamp")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime getE3timestamp() {
        return e3timestamp;
    }

    public void setE3timestamp(LocalDateTime e3timestamp) {
        this.e3timestamp = e3timestamp;
    }

    @Column(name = "ExtA_IndInv1")
    public float getExta_indinv1() {
        return exta_indinv1;
    }

    public void setExta_indinv1(float exta_indinv1) {
        this.exta_indinv1 = exta_indinv1;
    }

    @Override
    public String toString() {
        return "L03{" + "e3timestamp=" + e3timestamp + ", exta_indinv1=" + exta_indinv1 + '}';
    }

}
