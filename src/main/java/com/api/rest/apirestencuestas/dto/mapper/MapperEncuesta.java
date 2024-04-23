package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.response.EncuestaResponse;
import com.api.rest.apirestencuestas.model.Encuesta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper(componentModel = "spring")
public interface MapperEncuesta {

    MapperEncuesta MAPPER_ENCUESTA = Mappers.getMapper(MapperEncuesta.class);

    Encuesta fromRequestToEntity (EncuestaRequest encuestaRequest);

    EncuestaDto fromEntityToDto (Encuesta encuesta);

    List <EncuestaDto> fromEncuestaDtoToResponse (List <Encuesta> encuesta);

    EncuestaResponse fromDtoToResponse (EncuestaDto encuestaDto);

    List <EncuestaResponse> fromListDtoToListResponse (List <EncuestaDto> encuestaDtoList);


}
