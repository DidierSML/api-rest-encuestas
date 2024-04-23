package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.EncuestaDto;
import com.api.rest.apirestencuestas.dto.request.EncuestaRequest;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.service.EncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EncuestaServiceImpl  implements EncuestaService {

    private final EncuestaRepository encuestaRepository;

    @Override
    public EncuestaDto createUser(EncuestaRequest encuestaRequest) {
        return null;
    }

    @Override
    public List<EncuestaDto> getAllEncuestas(List<EncuestaRequest> encuestaRequestList) {
        return null;
    }

    @Override
    public EncuestaDto getEncuestaById(Long encuestaId) {
        return null;
    }

    @Override
    public EncuestaDto updateEncuestaById(Long encuestaId, EncuestaRequest encuestaRequest) {
        return null;
    }

    @Override
    public void deleteEncuestaById(Long encuestaId) {

    }
}
