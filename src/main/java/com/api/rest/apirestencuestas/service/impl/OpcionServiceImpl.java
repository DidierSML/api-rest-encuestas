package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.OpcionRepository;
import com.api.rest.apirestencuestas.service.OpcionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class OpcionServiceImpl  implements OpcionService {

    private final OpcionRepository opcionRepository;
    private final EncuestaRepository encuestaRepository;
    private final MapperOpcion mapperOpcion;

    @Override
    public Set <OpcionDto> getOpcionesByEncuestaId(Long encuestaId) {

        encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException("Esta Encuesta no existe en nuestra BD"));

        Set<Opcion> opcionesList = opcionRepository.findByEncuestaId(encuestaId);

        return mapperOpcion.fromEntityListToDtoList(opcionesList);
    }

    @Override
    public OpcionDto updateOpcionByEncuestaId(Long encuestaId, Long opcionId, OpcionRequest opcionRequest) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException("Esta Encuesta no existe en nuestra BD"));

        Opcion opcion = opcionRepository.findById(opcionId).
                orElseThrow(() -> new NotFoundCustomeException("Esta Opción no existe en nuestra BD"));

        if(!opcion.getEncuesta().getId().equals(encuesta.getId())){
            throw new NotFoundCustomeException("Esta Opción no existe en la encuesta id: " + encuestaId);
        }

        if(opcionRequest.getValue() != null && !opcionRequest.getValue().isEmpty()){
            opcion.setValue(opcionRequest.getValue());
        }

        opcionRepository.save(opcion);

        return mapperOpcion.fromEntityToDto(opcion);
    }
}
