package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.repository.OpcionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpcionService {

    private final OpcionRepository opcionRepository;
}
