package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.OpcionRepository;
import com.api.rest.apirestencuestas.service.EncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<OpcionRequest> opcionesRequestList = encuestaRequest.getOpciones();

        Set<Opcion> opcionesList = new HashSet<>();

        Set<Opcion> existingOpciones = existingEncuesta.getOpciones();

        for(OpcionRequest opcionRequest: opcionesRequestList){

            Opcion opcion = null;

            for(Opcion existingOpcion : existingOpciones){
                if(existingOpcion.getValue().equals(opcionRequest.getValue())) {
                    opcion = existingOpcion;
                    break;
                }
            }

            if(opcion == null){
                opcion = new Opcion();
                opcion.setValue(opcionRequest.getValue());
            }

            opcionesList.add(opcion);
        }

        existingEncuesta.setOpciones(opcionesList);

        existingEncuesta = encuestaRepository.save(existingEncuesta);


        return mapperEncuesta.fromEntityToDto(existingEncuesta);
    }

    @Override
    public void deleteEncuestaById(Long encuestaId) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(()-> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        encuestaRepository.delete(encuesta);

    }
}

/*

    @Override
    public EncuestaDto updateEncuestaById(Long encuestaId, EncuestaRequest encuestaRequest) {

        Encuesta existingEncuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        existingEncuesta.setPregunta(encuestaRequest.getPregunta());

        Set<OpcionRequest> opcionesRequestList = encuestaRequest.getOpciones();
        Set<Opcion> opcionesList = new HashSet<>();

        Set<Opcion> existingOpciones = existingEncuesta.getOpciones();

        for(OpcionRequest opcionRequest: opcionesRequestList){

            Opcion opcion = null;

            for(Opcion existingOpcion : existingOpciones){
                if(existingOpcion.getValue().equals(opcionRequest.getValue())) {
                    opcion = existingOpcion;
                    break;
                }
            }

            if(opcion == null){
                opcion = new Opcion();
                opcion.setValue(opcionRequest.getValue());
            }

            opcionesList.add(opcion);
        }

        existingEncuesta.setOpciones(opcionesList);

        existingEncuesta = encuestaRepository.save(existingEncuesta);


        return mapperEncuesta.fromEntityToDto(existingEncuesta);
    }

 */


