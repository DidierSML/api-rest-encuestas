package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.VotoResult;
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

    @PostMapping("saveVotoByEncuestaId/{encuestaId}/opcionId/{opcionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VotoResponse saveVoto (@PathVariable (value = "encuestaId") Long encuestaId,
                                  @PathVariable (value = "opcionId") Long opcionId,
                                  @RequestBody VotoRequest votoRequest){

        return mapperVoto.fromDtoToResponse(votoServiceImpl.saveVoto(encuestaId, opcionId, votoRequest));

    }

    @GetMapping("getAllVotosByEncuestaId/{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VotoResponse> getAllVotos (@PathVariable (value = "encuestaId") Long encuestaId){

        return mapperVoto.fromDtoListToResponseList(votoServiceImpl.getAllVotosByEncuestaId(encuestaId));
    }

    @GetMapping("voteCountingByEncuestaId/{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public List <VotoResult> voteCountingByEncuestaId (@PathVariable (value = "encuestaId") Long encuestaId){

        return votoServiceImpl.voteCountingByEncuestaId(encuestaId);
    }


}
