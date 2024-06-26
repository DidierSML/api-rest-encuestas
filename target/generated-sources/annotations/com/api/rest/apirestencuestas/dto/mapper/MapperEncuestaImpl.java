package com.api.rest.apirestencuestas.dto.mapper;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.OpcionDto;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.request.OpcionRequest;
import com.api.rest.apirestencuestas.dto.response.EncuestaResponse;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-26T11:09:35-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class MapperEncuestaImpl implements MapperEncuesta {

    @Override
    public Encuesta fromRequestToEntity(EncuestaRequest encuestaRequest) {
        if ( encuestaRequest == null ) {
            return null;
        }

        Encuesta encuesta = new Encuesta();

        encuesta.setId( encuestaRequest.getId() );
        encuesta.setPregunta( encuestaRequest.getPregunta() );
        encuesta.setOpciones( opcionRequestSetToOpcionSet( encuestaRequest.getOpciones() ) );

        return encuesta;
    }

    @Override
    public EncuestaDto fromEntityToDto(Encuesta encuesta) {
        if ( encuesta == null ) {
            return null;
        }

        EncuestaDto encuestaDto = new EncuestaDto();

        encuestaDto.setId( encuesta.getId() );
        encuestaDto.setPregunta( encuesta.getPregunta() );
        encuestaDto.setOpciones( opcionSetToOpcionDtoSet( encuesta.getOpciones() ) );

        return encuestaDto;
    }

    @Override
    public List<EncuestaDto> fromEntityListToDtoList(List<Encuesta> encuesta) {
        if ( encuesta == null ) {
            return null;
        }

        List<EncuestaDto> list = new ArrayList<EncuestaDto>( encuesta.size() );
        for ( Encuesta encuesta1 : encuesta ) {
            list.add( fromEntityToDto( encuesta1 ) );
        }

        return list;
    }

    @Override
    public EncuestaResponse fromDtoToResponse(EncuestaDto encuestaDto) {
        if ( encuestaDto == null ) {
            return null;
        }

        EncuestaResponse encuestaResponse = new EncuestaResponse();

        encuestaResponse.setId( encuestaDto.getId() );
        encuestaResponse.setPregunta( encuestaDto.getPregunta() );
        encuestaResponse.setOpciones( opcionDtoSetToOpcionResponseSet( encuestaDto.getOpciones() ) );

        return encuestaResponse;
    }

    @Override
    public List<EncuestaResponse> fromDtoListToResponseList(List<EncuestaDto> encuestaDtoList) {
        if ( encuestaDtoList == null ) {
            return null;
        }

        List<EncuestaResponse> list = new ArrayList<EncuestaResponse>( encuestaDtoList.size() );
        for ( EncuestaDto encuestaDto : encuestaDtoList ) {
            list.add( fromDtoToResponse( encuestaDto ) );
        }

        return list;
    }

    protected Opcion opcionRequestToOpcion(OpcionRequest opcionRequest) {
        if ( opcionRequest == null ) {
            return null;
        }

        Opcion opcion = new Opcion();

        opcion.setId( opcionRequest.getId() );
        opcion.setValue( opcionRequest.getValue() );

        return opcion;
    }

    protected Set<Opcion> opcionRequestSetToOpcionSet(Set<OpcionRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Opcion> set1 = new LinkedHashSet<Opcion>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OpcionRequest opcionRequest : set ) {
            set1.add( opcionRequestToOpcion( opcionRequest ) );
        }

        return set1;
    }

    protected OpcionDto opcionToOpcionDto(Opcion opcion) {
        if ( opcion == null ) {
            return null;
        }

        OpcionDto opcionDto = new OpcionDto();

        opcionDto.setId( opcion.getId() );
        opcionDto.setValue( opcion.getValue() );

        return opcionDto;
    }

    protected Set<OpcionDto> opcionSetToOpcionDtoSet(Set<Opcion> set) {
        if ( set == null ) {
            return null;
        }

        Set<OpcionDto> set1 = new LinkedHashSet<OpcionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Opcion opcion : set ) {
            set1.add( opcionToOpcionDto( opcion ) );
        }

        return set1;
    }

    protected OpcionResponse opcionDtoToOpcionResponse(OpcionDto opcionDto) {
        if ( opcionDto == null ) {
            return null;
        }

        OpcionResponse opcionResponse = new OpcionResponse();

        opcionResponse.setId( opcionDto.getId() );
        opcionResponse.setValue( opcionDto.getValue() );

        return opcionResponse;
    }

    protected Set<OpcionResponse> opcionDtoSetToOpcionResponseSet(Set<OpcionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<OpcionResponse> set1 = new LinkedHashSet<OpcionResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OpcionDto opcionDto : set ) {
            set1.add( opcionDtoToOpcionResponse( opcionDto ) );
        }

        return set1;
    }
}
