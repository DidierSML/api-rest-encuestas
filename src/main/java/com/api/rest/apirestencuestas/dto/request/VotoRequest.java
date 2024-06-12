package com.api.rest.apirestencuestas.dto.request;

import lombok.Data;

@Data
public class VotoRequest {

    private Long id;

    //private OpcionRequest opcionRequest;
    private OpcionRequest opcion;
}
