package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.service.EncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EncuestaServiceImpl  implements EncuestaService {


    private final EncuestaRepository encuestaRepository;

    private final MapperEncuesta mapperEncuesta;


    @Override
    public EncuestaDto createEncuesta (EncuestaRequest encuestaRequest) {

        Encuesta encuesta = mapperEncuesta.fromRequestToEntity(encuestaRequest);

        if(encuesta.getOpciones() != null){
            for(Opcion opcion: encuesta.getOpciones()){
                opcion.setEncuesta(encuesta);
            }
        }

        Encuesta newEncuesta = encuestaRepository.save(encuesta);

        return mapperEncuesta.fromEntityToDto(newEncuesta);

    }

    @Override
    public List <EncuestaDto> getAllEncuestas () {

        List <Encuesta> content = encuestaRepository.findAll();

        return mapperEncuesta.fromEntityListToDtoList(content);

    }

    @Override
    public EncuestaDto getEncuestaById(Long encuestaId) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomException("Esta -Encuesta- no existe en nuestro Sistema"));


        return mapperEncuesta.fromEntityToDto(encuesta);
    }

    @Override
    public EncuestaDto updateEncuestaById(Long encuestaId, EncuestaRequest encuestaRequest) {

        Encuesta existingEncuesta = encuestaRepository.findById(encuestaId)
                .orElseThrow(() -> new NotFoundCustomException("Esta Encuesta no existe en nuestro Sistema"));

        existingEncuesta.setPregunta(encuestaRequest.getPregunta());

        return mapperEncuesta.fromEntityToDto(existingEncuesta);
    }

    @Override
    public void deleteEncuestaById(Long encuestaId) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(()-> new NotFoundCustomException("Esta -Encuesta- no existe en nuestro Sistema"));

        encuestaRepository.delete(encuesta);

    }
}




