package com.api.rest.apirestencuestas.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EncuestaDto {

    private Long id;

    private String pregunta;

    private Set <String> opciones;
}
