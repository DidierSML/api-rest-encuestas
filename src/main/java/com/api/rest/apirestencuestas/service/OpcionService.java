package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;

import java.util.Set;

public interface OpcionService {

   Set<OpcionDto> getOpcionesByEncuestaId (Long encuestaId);

   OpcionDto updateOpcion (Long encuestaId, Long opcionId, OpcionRequest opcionRequest);

}
