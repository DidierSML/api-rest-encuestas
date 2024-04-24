package com.api.rest.apirestencuestas.service;


import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;

import java.util.List;

public interface EncuestaService {

    EncuestaDto createUser (EncuestaRequest encuestaRequest);

    List <EncuestaDto> getAllEncuestas ();

    EncuestaDto getEncuestaById (Long encuestaId);

    EncuestaDto updateEncuestaById (Long encuestaId, EncuestaRequest encuestaRequest);

    void deleteEncuestaById (Long encuestaId);
}
