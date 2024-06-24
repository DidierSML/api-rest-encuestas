package com.api.rest.apirestencuestas.service;


import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EncuestaService {

    EncuestaDto createEncuesta (EncuestaRequest encuestaRequest);

    //EncuestaDto getAllEncuestas (int pageNo, int pageSize, String sortBy, String sortDir);
    Page <EncuestaDto> getAllEncuestas (int page, int size);

    EncuestaDto getEncuestaById (Long encuestaId);

    EncuestaDto updateEncuestaById (Long encuestaId, EncuestaRequest encuestaRequest);

    void deleteEncuestaById (Long encuestaId);
}
