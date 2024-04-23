package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.repository.OpcionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpcionServiceImpl {

    private final OpcionRepository opcionRepository;
}
