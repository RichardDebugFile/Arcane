/* AfiliacionId.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AfiliacionId implements Serializable {

    @Column(name = "id_personaje")
    private Long personajeId;

    @Column(name = "id_organizacion")
    private Long organizacionId;

    /* constructores, equals & hashCode */
    public AfiliacionId() { }
    public AfiliacionId(Long personajeId, Long organizacionId) {
        this.personajeId = personajeId;
        this.organizacionId = organizacionId;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AfiliacionId that)) return false;
        return Objects.equals(personajeId, that.personajeId) &&
                Objects.equals(organizacionId, that.organizacionId);
    }
    @Override public int hashCode() { return Objects.hash(personajeId, organizacionId); }
}
