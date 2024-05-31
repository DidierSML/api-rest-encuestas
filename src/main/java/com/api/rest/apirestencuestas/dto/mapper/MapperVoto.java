package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.dto.response.VotoResponse;
import com.api.rest.apirestencuestas.model.Voto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperVoto {

    MapperVoto MAPPER_VOTO = Mappers.getMapper(MapperVoto.class);

    Voto fromRequestToEntity(VotoRequest votoRequest);

    VotoDto fromEntityToDto (Voto voto);

    VotoResponse fromDtoToResponse (VotoDto votoDto);

    List<VotoDto> fromEntityListToDtoList (List<Voto> votoList);

    List <VotoResponse> fromDtoListToResponseList (List <VotoDto> votoDtoList);



}
