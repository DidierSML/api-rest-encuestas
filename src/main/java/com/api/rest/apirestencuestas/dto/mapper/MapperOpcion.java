package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.model.Opcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperOpcion {

    MapperOpcion MAPPER_OPCION = Mappers.getMapper(MapperOpcion.class);

    Opcion fromRequestToEntity (OpcionRequest opcionRequest);

    OpcionDto fromEntityToDto (Opcion opcion);

    List<OpcionDto> fromEntityListToDtoList (List <Opcion> opcion);

    OpcionResponse fromDtoToResponse (OpcionDto opcionDto);

    List <OpcionResponse> fromDtoListToResponseList (List <OpcionDto> opcionDtoList);

}
