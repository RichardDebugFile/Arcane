/* Organizacion.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;

@Entity
@Table(name = "organizacion")
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizacion")
    private Long id;

    private String nombre;
    private String ciudadBase;
    private String tipo;

    protected Organizacion() { }
    public Organizacion(String nombre, String ciudadBase, String tipo) {
        this.nombre = nombre;
        this.ciudadBase = ciudadBase;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCiudadBase() { return ciudadBase; }
    public String getTipo() { return tipo; }
}
