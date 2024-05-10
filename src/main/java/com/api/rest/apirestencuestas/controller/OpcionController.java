package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.service.impl.OpcionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/opcion")
public class OpcionController {

    private final OpcionServiceImpl opcionServiceImpl;
    private final MapperOpcion mapperOpcion;

    @GetMapping("{encuestaId}")
    @ResponseStatus(HttpStatus.OK)
    public Set <OpcionResponse> getOpcionesByEncuestaId (@PathVariable(value = "encuestaId") Long encuestaId){

        return mapperOpcion.fromDtoListToResponseList(opcionServiceImpl.getOpcionesByEncuestaId(encuestaId));
    }
}
