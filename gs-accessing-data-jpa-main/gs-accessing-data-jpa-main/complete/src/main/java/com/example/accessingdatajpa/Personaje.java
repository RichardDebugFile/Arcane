package com.example.accessingdatajpa;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Long id;

    private String nombre;
    private String origen;
    private String rol;
    private String alineacion;

    @Column(name = "habilidades_especiales")
    private String habilidadesEspeciales;

    /* ================== Relaciones de conveniencia ================== */
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Afiliacion> afiliaciones = new HashSet<>();

    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsoTecnologia> usosTecnologia = new HashSet<>();

    @OneToMany(mappedBy = "personajeA", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacion> relacionesComoA = new HashSet<>();

    @OneToMany(mappedBy = "personajeB", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacion> relacionesComoB = new HashSet<>();

    /* ================== Constructores ================== */
    protected Personaje() { }

    /**
     * Constructor con nuevas habilidades.
     */
    public Personaje(String nombre, String origen, String rol, String alineacion, String habilidadesEspeciales) {
        this.nombre = nombre;
        this.origen = origen;
        this.rol = rol;
        this.alineacion = alineacion;
        this.habilidadesEspeciales = habilidadesEspeciales;
    }

    /**
     * Constructor antiguo para compatibilidad.
     */
    public Personaje(String nombre, String origen, String rol, String alineacion) {
        this(nombre, origen, rol, alineacion, null);
    }




    /* ================== Getters/Setters ================== */
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getOrigen() { return origen; }
    public String getRol() { return rol; }
    public String getAlineacion() { return alineacion; }
    public String getHabilidadesEspeciales() { return habilidadesEspeciales; }
    public void setHabilidadesEspeciales(String habilidades) { this.habilidadesEspeciales = habilidades; }
    public void setRol(String rol) { this.rol = rol; }
    public void setAlineacion(String alineacion) { this.alineacion = alineacion; }

    /* equals/hashCode omitidos por brevedad */
    @Override
    public String toString() {
        return String.format("Personaje[id=%d, nombre='%s', origen='%s', rol='%s', alineacion='%s', habilidades='%s']",
                id, nombre, origen, rol, alineacion, habilidadesEspeciales);
    }
}
