package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface OpcionRepository extends JpaRepository<Opcion,Long> {

    Set <Opcion> findByEncuestaId (Long encuestaId);
}
