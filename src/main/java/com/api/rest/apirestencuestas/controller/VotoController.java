package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperVoto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.dto.response.VotoResponse;
import com.api.rest.apirestencuestas.service.impl.VotoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/voto")
public class VotoController {

    private final VotoServiceImpl votoServiceImpl;

    private final MapperVoto mapperVoto;

    @PostMapping("saveVotoEncuestaId/{encuestaId}/opcion/{opcionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VotoResponse saveVoto (@PathVariable (value = "encuestaId") Long encuestaId,
                                  @PathVariable (value = "opcionId") Long opcionId,
                                  @RequestBody VotoRequest votoRequest){

        VotoDto savedVotoDto = votoServiceImpl.saveVoto(encuestaId, opcionId, votoRequest);
        //return mapperVoto.fromDtoToResponse(votoServiceImpl.saveVoto(encuestaId, opcionId, votoRequest));
        return mapperVoto.fromDtoToResponse(savedVotoDto);
    }

    @GetMapping("getVotosByEncuestaId/{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<VotoResponse> getVotosByEncuestaId (@PathVariable Long encuestaId){

        return mapperVoto.fromDtoListToResponseList(votoServiceImpl.getAllVotosByEncuestaId(encuestaId));
    }

}
