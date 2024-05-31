package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.mapper.MapperVoto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Voto;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.VotoRepository;
import com.api.rest.apirestencuestas.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final EncuestaRepository encuestaRepository;
    private final MapperVoto mapperVoto;

    @Override
    public VotoDto saveVoto (Long encuestaId, VotoRequest votoRequest) {

        Voto voto = mapperVoto.fromRequestToEntity(votoRequest);

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException
                        ("La encuesta con id: " + encuestaId + " no existe en nuestra BD"));

        voto.setId(encuestaId);

        Voto newVoto = votoRepository.save(voto);

        return mapperVoto.fromEntityToDto(newVoto);

    }

    @Override
    public List <VotoDto> getAllVotosByEncuestaId (Long encuestaId) {

        List <Voto> content=  votoRepository.findAll();
        return mapperVoto.fromEntityListToDtoList(content);
    }

}
