package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.mapper.MapperEncuesta;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.dto.response.EncuestaResponse;
import com.api.rest.apirestencuestas.service.impl.EncuestaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List <EncuestaResponse> getAllEncuestas (){

        return mapperEncuesta.fromDtoListToResponseList(encuestaServiceImpl.getAllEncuestas());
    }

    @GetMapping("{encuestaId")
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
