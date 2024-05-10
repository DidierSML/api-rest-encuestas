package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface OpcionRepository extends JpaRepository<Opcion,Long> {

    //@Query("SELECT o FROM Opcion o WHERE o.encuestaId = :encuestaId")
    Set<Opcion> findByEncuestaId (Long encuestaId);

}
