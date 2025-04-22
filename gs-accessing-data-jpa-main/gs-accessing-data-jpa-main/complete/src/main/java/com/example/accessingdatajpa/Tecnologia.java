/* Tecnologia.java */
package com.example.accessingdatajpa;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnologia")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private Long id;

    private String nombre;
    private String tipo;
    private String descripcion;

    protected Tecnologia() { }
    public Tecnologia(String nombre, String tipo, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
}
