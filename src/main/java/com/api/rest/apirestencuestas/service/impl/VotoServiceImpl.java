package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.mapper.MapperVoto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.model.Voto;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.OpcionRepository;
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
    private final OpcionRepository opcionRepository;
    private final MapperVoto mapperVoto;

    @Override
    public VotoDto saveVoto (Long encuestaId, Long opcionId, VotoRequest votoRequest) {

        Voto voto = mapperVoto.fromRequestToEntity(votoRequest);

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException
                        ("La encuesta con id: " + encuestaId + " no existe en nuestra BD"));

        // Asignar el ID de la encuesta al voto
        voto.setEncuesta(encuesta);

        Opcion opcion = opcionRepository.findById(opcionId).
                orElseThrow(() -> new NotFoundCustomeException
                        ("La opcion con id: " + encuestaId + " no existe en nuestra BD"));

        //Verificamos si la opción pertenece a la encuesta
        if(!opcion.getEncuesta().getId().equals(encuestaId)){
            throw new IllegalArgumentException
                    ("La opción: " + opcionId + " no pertenece a la encuesta : " + encuestaId);
        }

        // Configurar la opción del voto
        voto.setOpcion(opcion);

        Voto newVoto = votoRepository.save(voto);

        return mapperVoto.fromEntityToDto(newVoto);

    }

    @Override
    public List <VotoDto> getAllVotosByEncuestaId (Long encuestaId) {

        List <Voto> content=  votoRepository.findAll();
        return mapperVoto.fromEntityListToDtoList(content);
    }

}
