package com.api.rest.apirestencuestas.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class OpcionRequest {

    private Long id;

    @Min(value = 1)
    @Max(value = 20, message = "La respuesta o valor debe contener al menos 1 caracter" )
    private String value;
}
