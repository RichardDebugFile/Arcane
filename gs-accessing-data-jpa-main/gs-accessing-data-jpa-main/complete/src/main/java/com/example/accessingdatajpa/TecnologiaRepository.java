/* TecnologiaRepository.java */
package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path="tecnologias",
        collectionResourceRel="tecnologias"
)
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> { }
