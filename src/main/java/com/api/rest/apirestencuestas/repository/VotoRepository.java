package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository <Voto,Long> {

@Query(value = "SELECT v.* FROM voto v WHERE v.encuesta_id = :encuestaId", nativeQuery = true)
List <Voto> findByEncuestaId (Long encuestaId);

}
