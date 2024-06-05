package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.dto.response.VotoResponse;
import com.api.rest.apirestencuestas.model.Voto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
    Al usar: (uses = MapperOpcion.class) en la Interfaz MapperVoto,
    le estás diciendo a MapStruct que también considere las reglas
    de mapeo definidas en -MapperOpcion- al realizar mapeos en MapperVoto.
    Esto permite reutilizar la lógica de mapeo definida en -MapperOpcion-
    dentro de -MapperVoto-.
 */
@Mapper(componentModel = "spring",uses = MapperOpcion.class)
public interface MapperVoto {

    MapperVoto MAPPER_VOTO = Mappers.getMapper(MapperVoto.class);

    Voto fromRequestToEntity(VotoRequest votoRequest);

    //@Mapping(target = "opcionResponse", source = "opcion")
    VotoDto fromEntityToDto (Voto voto);

    @Mapping(target = "opcionResponse", source = "opcionDto")
    VotoResponse fromDtoToResponse (VotoDto votoDto);

    List<VotoDto> fromEntityListToDtoList (List<Voto> votoList);

    List <VotoResponse> fromDtoListToResponseList (List <VotoDto> votoDtoList);


}
