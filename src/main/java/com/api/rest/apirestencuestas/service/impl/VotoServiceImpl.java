package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.repository.VotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotoServiceImpl {

    private final VotoRepository votoRepository;
}
