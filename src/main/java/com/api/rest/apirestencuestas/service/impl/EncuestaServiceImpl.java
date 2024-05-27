package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomeException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.service.EncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
                orElseThrow(() -> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));


        return mapperEncuesta.fromEntityToDto(encuesta);
    }

    @Override
    public EncuestaDto updateEncuestaById(Long encuestaId, EncuestaRequest encuestaRequest) {
        Encuesta existingEncuesta = encuestaRepository.findById(encuestaId)
                .orElseThrow(() -> new NotFoundCustomeException("Esta Encuesta no existe en nuestro Sistema"));

        existingEncuesta.setPregunta(encuestaRequest.getPregunta());

        // Obtener las opciones existentes de la encuesta
        Set<Opcion> existingOpciones = existingEncuesta.getOpciones();

        // Limpiar las opciones existentes, ya que vamos a actualizarlas
        existingOpciones.clear();

        // Recorrer las nuevas opciones proporcionadas en la solicitud
        for (OpcionRequest opcionRequest : encuestaRequest.getOpciones()) {
            Opcion opcion = new Opcion();
            opcion.setValue(opcionRequest.getValue());
            opcion.setEncuesta(existingEncuesta); // Establecer la relación con la encuesta
            existingOpciones.add(opcion); // Agregar la nueva opción a la lista de opciones de la encuesta
        }

        // Guardar la encuesta actualizada en la base de datos
        existingEncuesta = encuestaRepository.save(existingEncuesta);

        // Convertir la encuesta actualizada a un DTO y devolverla
        return mapperEncuesta.fromEntityToDto(existingEncuesta);
    }

    @Override
    public void deleteEncuestaById(Long encuestaId) {

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(()-> new NotFoundCustomeException("Esta -Encuesta- no existe en nuestro Sistema"));

        encuestaRepository.delete(encuesta);

    }
}




