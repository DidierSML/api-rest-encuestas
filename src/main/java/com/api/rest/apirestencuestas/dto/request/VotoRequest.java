package com.api.rest.apirestencuestas.dto.request;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import lombok.Data;

@Data
public class VotoRequest {

    private Long id;

    private OpcionDto opcionDto;
}
