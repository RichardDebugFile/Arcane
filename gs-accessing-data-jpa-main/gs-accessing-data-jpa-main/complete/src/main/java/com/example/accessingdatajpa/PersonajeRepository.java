/* PersonajeRepository.java */
package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path="personajes", collectionResourceRel="personajes")

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    List<Personaje> findByNombreContainingIgnoreCase(String nombre);
}
