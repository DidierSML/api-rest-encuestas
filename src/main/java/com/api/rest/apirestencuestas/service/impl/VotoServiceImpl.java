package com.api.rest.apirestencuestas.service.impl;

import com.api.rest.apirestencuestas.dto.OpcionCount;
import com.api.rest.apirestencuestas.dto.VotoDto;
import com.api.rest.apirestencuestas.dto.VotoResult;
import com.api.rest.apirestencuestas.dto.mapper.MapperVoto;
import com.api.rest.apirestencuestas.dto.request.VotoRequest;
import com.api.rest.apirestencuestas.exceptions.NotFoundCustomException;
import com.api.rest.apirestencuestas.model.Encuesta;
import com.api.rest.apirestencuestas.model.Opcion;
import com.api.rest.apirestencuestas.model.Voto;
import com.api.rest.apirestencuestas.repository.EncuestaRepository;
import com.api.rest.apirestencuestas.repository.OpcionRepository;
import com.api.rest.apirestencuestas.repository.VotoRepository;
import com.api.rest.apirestencuestas.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final EncuestaRepository encuestaRepository;
    private final OpcionRepository opcionRepository;
    private final MapperVoto mapperVoto;

    @Override
    public VotoDto saveVoto(Long encuestaId, Long opcionId, VotoRequest votoRequest) {

        Voto voto = mapperVoto.fromRequestToEntity(votoRequest);

        Encuesta encuesta = encuestaRepository.findById(encuestaId).
                orElseThrow(() -> new NotFoundCustomException
                        ("La encuesta con id: " + encuestaId + " no existe en nuestra BD"));

        // Asignar el ID de la encuesta al voto
        voto.setEncuesta(encuesta);

        Opcion opcion = opcionRepository.findById(opcionId).
                orElseThrow(() -> new NotFoundCustomException
                        ("La opcion con id: " + encuestaId + " no existe en nuestra BD"));

        // Verificamos si la opción pertenece a la encuesta
        if(!opcion.getEncuesta().getId().equals(encuestaId)){
            throw new IllegalArgumentException
                    ("La opción: " + opcionId + " no pertenece a la encuesta : " + encuestaId);
        }

        // Configurar la opción del voto
        voto.setOpcion(opcion);

        Voto newVoto = votoRepository.save(voto);

        return mapperVoto.fromEntityToDto(newVoto);
    }

    @Override
    public List<VotoDto> getAllVotosByEncuestaId(Long encuestaId) {

        List <Voto> content=  votoRepository.findByEncuestaId(encuestaId);
        return mapperVoto.fromEntityListToDtoList(content);
    }

    @Override
    public List<VotoResult> voteCountingByEncuestaId (Long encuestaId) {

        //Nueva Instancia de VotoResult
        VotoResult votoResult = new VotoResult();

        //Listamos los votos obtenidos por EncuestaId
        List <Voto> votosList = votoRepository.findByEncuestaId(encuestaId);

        //Inicializamos el contador de votos en 0
        int totalVotos = 0;

        //Creamos un Map donde como clave usaremos un Long, y como valor un Objeto OpcionCount
        Map <Long, OpcionCount> map = new HashMap<>();

        //Iteramos sobre la lista de votos obtenidos por encuestaId
        for(Voto voto: votosList){
            //Al estar iterando por cada voto, incrementamos en 1 por cada voto realizado
            totalVotos++;

            //Obtenemos la (OpcionId) y su (Opción) por cada -voto- y lo asignamos a la variable (opcionCount)
            OpcionCount opcionCount = map.get(voto.getOpcion().getId());

            //Si opcionCount es null (En la 1ra Iteración será null)
            if(opcionCount == null){
                //Crea una nueva instancia de OpcionCount
                opcionCount = new OpcionCount();
                //Asigna el (Id) para opcionCount y obtiene el (Id) y la opcion votada
                opcionCount.setOpcionId(voto.getOpcion().getId());
                //Finalmente, agrega el (Id) de opcionCount, el (Id) y la opción votada al map
                map.put(voto.getOpcion().getId(),opcionCount);
            }

            //Incrementamos la var count en 1
            opcionCount.setCount(opcionCount.getCount() + 1);
        }

        //Establece el total de votos en el resultado
        votoResult.setTotalVotos(totalVotos);

        //Mapea los valores guardados en el map y los asigna al Array -results-
        votoResult.setResults(new ArrayList<>(map.values()));

        //Creamos una lista -votoResults- y agregamos los valores mapeados anteriormente
        List <VotoResult> votoResults = new ArrayList<>();
        votoResults.add(votoResult);
        //retornamos la lista con el -resultado de los votos-
        return votoResults;

    }
}

