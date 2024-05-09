package com.api.rest.apirestencuestas.controller;

import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.response.OpcionResponse;
import com.api.rest.apirestencuestas.service.impl.OpcionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/opcion")
public class OpcionController {

    private final OpcionServiceImpl opcionServiceImpl;
    private final MapperOpcion mapperOpcion;

    public List<OpcionResponse> getOpcionesByEncuestaId (@PathVariable(value = "encuestaId") Long encuestaId){

        return mapperOpcion.fromDtoListToResponseList(opcionServiceImpl.getOpcionesByEncuestaId(encuestaId));
    }
}
