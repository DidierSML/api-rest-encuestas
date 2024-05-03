package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
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
                orElseThrow(() -> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        return mapperEncuesta.fromEntityToDto(encuesta);
    }

    @Override
    public EncuestaDto updateEncuestaById(Long encuestaId, EncuestaRequest encuestaRequest) {

        Encuesta existingEncuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        existingEncuesta.setPregunta(encuestaRequest.getPregunta());
        //existingEncuesta.setOpciones(encuestaRequest.getOpciones());

        return mapperEncuesta.fromEntityToDto(existingEncuesta);
    }

    @Override
    public void deleteEncuestaById(Long encuestaId) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(()-> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        encuestaRepository.delete(encuesta);

    }
}
