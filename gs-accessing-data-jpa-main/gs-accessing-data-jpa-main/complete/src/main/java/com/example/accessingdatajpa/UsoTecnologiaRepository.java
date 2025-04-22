/* UsoTecnologiaRepository.java */
package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="usoTecnologias", collectionResourceRel="usoTecnologias")

public interface UsoTecnologiaRepository extends JpaRepository<UsoTecnologia, UsoTecnologiaId> { }
