package com.api.rest.apirestencuestas.dto;

import lombok.Data;

import java.util.List;

@Data
public class VotoResult {

    private int totalVotos;

    private List<OpcionCount> results;
}
