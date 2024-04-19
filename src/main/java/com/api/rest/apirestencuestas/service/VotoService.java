package com.api.rest.apirestencuestas.service;

import com.api.rest.apirestencuestas.repository.VotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
}
