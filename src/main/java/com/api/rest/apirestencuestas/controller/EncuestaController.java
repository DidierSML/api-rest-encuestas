package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.response.EncuestaResponse;
import com.api.rest.apirestencuestas.service.impl.EncuestaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/encuesta")
public class EncuestaController {


    private final EncuestaServiceImpl encuestaServiceImpl;
    private final MapperEncuesta mapperEncuesta;

    @PostMapping("saveEncuesta")
    @ResponseStatus(HttpStatus.CREATED)
    public EncuestaResponse createEncuesta (@Valid @RequestBody EncuestaRequest encuestaRequest){

        return mapperEncuesta.fromDtoToResponse(encuestaServiceImpl.createEncuesta(encuestaRequest));
    }

    @GetMapping("getAllEncuestas")
    @ResponseStatus(HttpStatus.OK)
    public Page <EncuestaResponse> getAllEncuestas (@RequestParam (defaultValue = "0") int page,
                                                   @RequestParam (defaultValue = "10") int size){

        Page <EncuestaDto> encuestaDtoPage = encuestaServiceImpl.getAllEncuestas(page,size);

        // Convertir la lista de EncuestaDto a EncuestaResponse usando el método del mapper pasando el contenido de page
        List<EncuestaResponse> encuestaResponses = mapperEncuesta.fromDtoListToResponseList(encuestaDtoPage.getContent());

        return new PageImpl<>(encuestaResponses, encuestaDtoPage.getPageable(), encuestaDtoPage.getTotalElements());
    }

    @GetMapping("{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public EncuestaResponse getEncuestaById (@PathVariable (value = "encuestaId") Long encuestaId){

        return mapperEncuesta.fromDtoToResponse(encuestaServiceImpl.getEncuestaById(encuestaId));
    }

    @PutMapping("{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public EncuestaResponse updateEncuestaById (@PathVariable (value = "encuestaId") Long encuestaId,
                                                @Valid @RequestBody EncuestaRequest encuestaRequest){

        return mapperEncuesta.fromDtoToResponse(encuestaServiceImpl.updateEncuestaById(encuestaId, encuestaRequest));
    }

    @DeleteMapping ("{encuestaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEncuesta (@PathVariable (value = "encuestaId") Long encuestaId){

        encuestaServiceImpl.deleteEncuestaById(encuestaId);
    }


}

/*
    -Forma alternativa de Convertir la listaDto a Response usando Stream.Collectors-

         List <EncuestaResponse> encuestaResponses = encuestaDtoPage.getContent().stream()
             .map(mapperEncuesta::fromDtoToResponse)
             .toList();
 */