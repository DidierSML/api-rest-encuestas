package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.model.Opcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface MapperOpcion {

    MapperOpcion MAPPER_OPCION = Mappers.getMapper(MapperOpcion.class);

    Opcion fromRequestToEntity (OpcionRequest opcionRequest);

    OpcionDto fromEntityToDto (Opcion opcion);

    Set <OpcionDto> fromEntityListToDtoList (Set <Opcion> opcion);

    // @Mapping(target = "value", source = "value")
    OpcionResponse fromDtoToResponse (OpcionDto opcionDto);

    Set <OpcionResponse> fromDtoListToResponseList (Set <OpcionDto> opcionDtoList);

}
