package com.api.rest.apirestencuestas.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class EncuestaResponse {

    private Long id;

    private String pregunta;

    private Set <String> opciones;

}
