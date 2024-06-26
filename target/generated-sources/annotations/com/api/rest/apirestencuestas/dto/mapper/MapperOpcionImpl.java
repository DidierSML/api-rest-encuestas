package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.model.Opcion;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T11:09:35-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class MapperOpcionImpl implements MapperOpcion {

    @Override
    public Opcion fromRequestToEntity(OpcionRequest opcionRequest) {
        if ( opcionRequest == null ) {
            return null;
        }

        Opcion opcion = new Opcion();

        opcion.setId( opcionRequest.getId() );
        opcion.setValue( opcionRequest.getValue() );

        return opcion;
    }

    @Override
    public OpcionDto fromEntityToDto(Opcion opcion) {
        if ( opcion == null ) {
            return null;
        }

        OpcionDto opcionDto = new OpcionDto();

        opcionDto.setId( opcion.getId() );
        opcionDto.setValue( opcion.getValue() );

        return opcionDto;
    }

    @Override
    public Set<OpcionDto> fromEntityListToDtoList(Set<Opcion> opcion) {
        if ( opcion == null ) {
            return null;
        }

        Set<OpcionDto> set = new LinkedHashSet<OpcionDto>( Math.max( (int) ( opcion.size() / .75f ) + 1, 16 ) );
        for ( Opcion opcion1 : opcion ) {
            set.add( fromEntityToDto( opcion1 ) );
        }

        return set;
    }

    @Override
    public OpcionResponse fromDtoToResponse(OpcionDto opcionDto) {
        if ( opcionDto == null ) {
            return null;
        }

        OpcionResponse opcionResponse = new OpcionResponse();

        opcionResponse.setId( opcionDto.getId() );
        opcionResponse.setValue( opcionDto.getValue() );

        return opcionResponse;
    }

    @Override
    public Set<OpcionResponse> fromDtoListToResponseList(Set<OpcionDto> opcionDtoList) {
        if ( opcionDtoList == null ) {
            return null;
        }

        Set<OpcionResponse> set = new LinkedHashSet<OpcionResponse>( Math.max( (int) ( opcionDtoList.size() / .75f ) + 1, 16 ) );
        for ( OpcionDto opcionDto : opcionDtoList ) {
            set.add( fromDtoToResponse( opcionDto ) );
        }

        return set;
    }
}
