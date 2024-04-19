package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EncuestaService {

    private final EncuestaRepository encuestaRepository;

}
