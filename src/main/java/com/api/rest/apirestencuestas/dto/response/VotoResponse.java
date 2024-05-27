package com.api.rest.apirestencuestas.dto.response;

import com.api.rest.apirestencuestas.dto.OpcionDto;
import lombok.Data;

@Data
public class VotoResponse {

    private Long id;

    private OpcionDto opcionDto;
}
