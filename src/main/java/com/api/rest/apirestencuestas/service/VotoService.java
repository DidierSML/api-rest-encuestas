package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.VotoResult;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;

import java.util.List;

public interface VotoService {

    VotoDto saveVoto (Long encuestaId, Long opcionId, VotoRequest votoRequest);

    List <VotoDto> getAllVotosByEncuestaId (Long encuestaId);

    List <VotoResult> voteCountingByEncuestaId (Long encuestaId);


}
