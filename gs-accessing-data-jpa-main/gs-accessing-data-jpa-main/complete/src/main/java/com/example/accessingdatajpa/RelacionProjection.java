// RelacionProjection.java
package com.example.accessingdatajpa;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="withDetails", types= { Relacion.class })
public interface RelacionProjection {
    Long getId();
    Personaje getPersonajeA();
    Personaje getPersonajeB();
    String getTipoRelacion();
}
