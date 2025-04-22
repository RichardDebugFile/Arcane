/* Relacion.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;

// Relacion.java
@Entity
@Table(name="relacion")
public class Relacion {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="id_personaje_a")
    private Personaje personajeA;

    @ManyToOne @JoinColumn(name="id_personaje_b")
    private Personaje personajeB;

    private String tipoRelacion;

    protected Relacion() {}
    public Relacion(Personaje a, Personaje b, String tipo) {
        this.personajeA = a;
        this.personajeB = b;
        this.tipoRelacion = tipo;
    }
    // getters…

    public Long getId() {
        return id;
    }

    public Personaje getPersonajeA() {
        return personajeA;
    }

    public Personaje getPersonajeB() {
        return personajeB;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }
}

