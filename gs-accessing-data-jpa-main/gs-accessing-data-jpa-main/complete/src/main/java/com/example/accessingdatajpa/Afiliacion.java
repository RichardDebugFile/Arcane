/* Afiliacion.java */
package com.example.accessingdatajpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "afiliacion")
public class Afiliacion {

    @EmbeddedId
    @JsonIgnore // Evita serializar el ID compuesto
    private AfiliacionId id;

    @ManyToOne
    @MapsId("personajeId")
    @JoinColumn(name = "id_personaje")
    private Personaje personaje;

    @ManyToOne
    @MapsId("organizacionId")
    @JoinColumn(name = "id_organizacion")
    private Organizacion organizacion;

    private String rol;
    private LocalDate fechaIngreso;

    protected Afiliacion() { }
    public Afiliacion(Personaje personaje, Organizacion organizacion,
                      String rol, LocalDate fechaIngreso) {
        this.personaje = personaje;
        this.organizacion = organizacion;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
        this.id = new AfiliacionId(personaje.getId(), organizacion.getId());
    }

    public AfiliacionId getId() { return id; }
    public String getRol() { return rol; }
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public Personaje getPersonaje()     { return personaje;     }
    public Organizacion getOrganizacion(){ return organizacion; }

}
