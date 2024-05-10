package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.OpcionDto;

import java.util.Set;

public interface OpcionService {

   Set<OpcionDto> getOpcionesByEncuestaId (Long encuestaId);

}
