package com.api.rest.apirestencuestas.repository;

import com.api.rest.apirestencuestas.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpcionRepository extends JpaRepository<Opcion,Long> {

}
