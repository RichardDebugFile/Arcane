/* UsoTecnologiaId.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsoTecnologiaId implements Serializable {
    @Column(name = "id_personaje") private Long personajeId;
    @Column(name = "id_tecnologia") private Long tecnologiaId;

    public UsoTecnologiaId() { }
    public UsoTecnologiaId(Long personajeId, Long tecnologiaId) {
        this.personajeId = personajeId;
        this.tecnologiaId = tecnologiaId;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsoTecnologiaId other)) return false;
        return Objects.equals(personajeId, other.personajeId) &&
                Objects.equals(tecnologiaId, other.tecnologiaId);
    }
    @Override public int hashCode() { return Objects.hash(personajeId, tecnologiaId); }
}
