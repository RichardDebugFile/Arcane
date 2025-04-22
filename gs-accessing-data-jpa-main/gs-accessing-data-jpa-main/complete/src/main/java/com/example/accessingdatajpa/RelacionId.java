/* RelacionId.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelacionId implements Serializable {

    @Column(name = "id_personaje_a") private Long personajeAId;
    @Column(name = "id_personaje_b") private Long personajeBId;

    public RelacionId() { }
    public RelacionId(Long personajeAId, Long personajeBId) {
        this.personajeAId = personajeAId;
        this.personajeBId = personajeBId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelacionId that)) return false;
        return Objects.equals(personajeAId, that.personajeAId) &&
                Objects.equals(personajeBId, that.personajeBId);
    }
    @Override public int hashCode() { return Objects.hash(personajeAId, personajeBId); }
}
