package com.api.rest.apirestencuestas.dto.request;

import lombok.Data;

@Data
public class OpcionRequest {

    private Long id;

    //@Min(value = 1, message = "La respuesta o valor debe contener al menos 1 caracter")
    private String value;
}
