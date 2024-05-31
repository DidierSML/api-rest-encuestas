package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;

import java.util.List;
import java.util.Set;

public interface VotoService {

    VotoDto saveVoto (VotoRequest votoRequest);

    List <VotoDto> getAllVotos ();

    Set<VotoDto> getAllVotosByOpcionId(Long opcionId);

    VotoDto updateByVotoId (Long votoId, VotoRequest votoRequest);

    void deleteVotoById (Long votoId);

}
