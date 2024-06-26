package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.dto.response.VotoResponse;
import com.api.rest.apirestencuestas.model.Voto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T11:09:35-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class MapperVotoImpl implements MapperVoto {

    @Autowired
    private MapperOpcion mapperOpcion;

    @Override
    public Voto fromRequestToEntity(VotoRequest votoRequest) {
        if ( votoRequest == null ) {
            return null;
        }

        Voto voto = new Voto();

        voto.setId( votoRequest.getId() );
        voto.setOpcion( mapperOpcion.fromRequestToEntity( votoRequest.getOpcion() ) );

        return voto;
    }

    @Override
    public VotoDto fromEntityToDto(Voto voto) {
        if ( voto == null ) {
            return null;
        }

        VotoDto votoDto = new VotoDto();

        votoDto.setId( voto.getId() );
        votoDto.setOpcion( mapperOpcion.fromEntityToDto( voto.getOpcion() ) );

        return votoDto;
    }

    @Override
    public VotoResponse fromDtoToResponse(VotoDto votoDto) {
        if ( votoDto == null ) {
            return null;
        }

        VotoResponse votoResponse = new VotoResponse();

        votoResponse.setId( votoDto.getId() );
        votoResponse.setOpcion( mapperOpcion.fromDtoToResponse( votoDto.getOpcion() ) );

        return votoResponse;
    }

    @Override
    public List<VotoDto> fromEntityListToDtoList(List<Voto> votoList) {
        if ( votoList == null ) {
            return null;
        }

        List<VotoDto> list = new ArrayList<VotoDto>( votoList.size() );
        for ( Voto voto : votoList ) {
            list.add( fromEntityToDto( voto ) );
        }

        return list;
    }

    @Override
    public List<VotoResponse> fromDtoListToResponseList(List<VotoDto> votoDtoList) {
        if ( votoDtoList == null ) {
            return null;
        }

        List<VotoResponse> list = new ArrayList<VotoResponse>( votoDtoList.size() );
        for ( VotoDto votoDto : votoDtoList ) {
            list.add( fromDtoToResponse( votoDto ) );
        }

        return list;
    }
}
