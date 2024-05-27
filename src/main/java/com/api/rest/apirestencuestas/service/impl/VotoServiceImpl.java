package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.mapper.MapperOpcion;
import com.api.rest.apirestencuestas.dto.mapper.MapperVoto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.model.Voto;
import com.api.rest.apirestencuestas.repository.VotoRepository;
import com.api.rest.apirestencuestas.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final MapperOpcion mapperOpcion;
    private final MapperVoto mapperVoto;

    @Override
    public VotoDto saveVoto(VotoRequest votoRequest) {

        Voto voto = mapperVoto.fromRequestToEntity(votoRequest);
        Voto newVoto = votoRepository.save(voto);

        return mapperVoto.fromEntityToDto(newVoto);

    }

    @Override
    public Set <VotoDto> getAllVotos() {

        Set <Voto> votoSet= (Set<Voto>) votoRepository.findAll();
        return mapperVoto.fromEntityListToDtoList(votoSet);
    }

    @Override
    public Set<VotoDto> getAllVotosByOpcionId(Long opcionId) {
        return null;
    }

    @Override
    public VotoDto updateByVotoId(Long votoId, VotoRequest votoRequest) {
        return null;
    }

    @Override
    public void deleteVotoById(Long votoId) {

    }
}
