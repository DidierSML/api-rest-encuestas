package com.api.rest.apirestencuestas.dto;

import lombok.Data;

@Data
public class OpcionCount {

    private Long opcionId;

    private String value;

    private int numberOfVotes;

}
