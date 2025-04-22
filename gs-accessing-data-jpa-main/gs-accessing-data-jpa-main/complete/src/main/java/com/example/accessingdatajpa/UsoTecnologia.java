/* UsoTecnologia.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;

// UsoTecnologia.java
@Entity
@Table(name="uso_tecnologia")
public class UsoTecnologia {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="id_personaje")
    private Personaje personaje;

    @ManyToOne @JoinColumn(name="id_tecnologia")
    private Tecnologia tecnologia;

    protected UsoTecnologia() {}
    public UsoTecnologia(Personaje p, Tecnologia t) {
        this.personaje = p;
        this.tecnologia = t;
    }
    // getters…

    public Long getId() {
        return id;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }
}

