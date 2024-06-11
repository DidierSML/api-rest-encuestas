package com.api.rest.apirestencuestas.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class EncuestaRequest {

    private Long id;

    @NotEmpty
    @Size(min = 10, message = "Escriba la pregunta que desea ingresar a la Encuesta" )
    private String pregunta;

    //@NotEmpty (message = "La pregunta debe contener al menos una opción")
    private Set <OpcionRequest> opciones;
}
