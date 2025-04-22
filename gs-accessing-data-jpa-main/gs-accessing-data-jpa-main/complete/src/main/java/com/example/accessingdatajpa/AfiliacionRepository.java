package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryRestResource(
        path="afiliaciones",
        collectionResourceRel="afiliaciones"
)
public interface AfiliacionRepository
        extends JpaRepository<Afiliacion, AfiliacionId> {

    // Exponemos una búsqueda bajo /afiliaciones/search/byPersonaje
    @RestResource(path="byPersonaje", rel="byPersonaje")
    List<Afiliacion> findByPersonajeId(@Param("personajeId") Long personajeId);
}
