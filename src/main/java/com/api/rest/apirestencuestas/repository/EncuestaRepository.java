package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends JpaRepository <Encuesta,Long> {


}
