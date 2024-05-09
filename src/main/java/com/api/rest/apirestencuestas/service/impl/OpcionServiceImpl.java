package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.OpcionRepository;
import com.api.rest.apirestencuestas.service.OpcionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OpcionServiceImpl  implements OpcionService {

    private final OpcionRepository opcionRepository;
    private final EncuestaRepository encuestaRepository;
    private final MapperOpcion mapperOpcion;

    @Override
    public List <OpcionDto> getOpcionesByEncuestaId(Long encuestaId) {

        encuestaRepository.findById(encuestaId).orElseThrow(() -> new NotFoundCustomeException("User non-existent in our System"));

        List <Opcion> animalList = (List<Opcion>) opcionRepository.findByEncuestaId(encuestaId);

        return mapperOpcion.fromEntityListToDtoList(animalList);
    }
}
