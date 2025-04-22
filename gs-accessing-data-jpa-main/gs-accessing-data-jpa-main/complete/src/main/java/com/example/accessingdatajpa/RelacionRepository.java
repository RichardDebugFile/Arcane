/* RelacionRepository.java */
package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="relaciones", collectionResourceRel="relaciones")


public interface RelacionRepository extends JpaRepository<Relacion, RelacionId> {
    List<Relacion> findByPersonajeA_Id(Long personajeId);
    List<Relacion> findByPersonajeB_Id(Long personajeId);
}
