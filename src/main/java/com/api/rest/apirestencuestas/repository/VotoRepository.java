package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VotoRepository extends JpaRepository <Voto,Long> {

    Set <Voto> findByOpcionId (Long opcionId);

}
