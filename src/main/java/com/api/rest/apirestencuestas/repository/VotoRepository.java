package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository <Voto,Long> {
}
