package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VotoRepository extends JpaRepository <Voto,Long> {

    @Query(value = "select v.* from Opcion o, Voto v where o.ENCUESTA_ID=? and v.OPCION_ID=o.OPCION_ID", nativeQuery = true)
    List <Voto> findByEncuestaId (Long opcionId);

}
