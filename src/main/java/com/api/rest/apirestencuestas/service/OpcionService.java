package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.OpcionDto;

import java.util.List;

public interface OpcionService {

   List<OpcionDto> getOpcionesByEncuestaId (Long encuestaId);

}
