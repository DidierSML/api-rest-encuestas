package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.dto.VotoDto;

import java.util.List;
import java.util.Set;

public interface VotoService {

    List <VotoDto> getAllVotos ();

    Set<VotoDto> getAllVotosByOpcionId(Long OpcionId);

}
