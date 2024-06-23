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

        //Se crea una nueva Instancia de VotoResult
        VotoResult votoResult = new VotoResult();

        //Se Listan los votos obtenidos por EncuestaId
        List <Voto> votosList = votoRepository.findByEncuestaId(encuestaId);

        //Se inicializa el contador de votos en 0
        int totalVotos = 0;

        //Se crea un Map donde <la clave es el ID de la opción> (Long) y <el valor es una instancia de OpcionCount>.
        Map <Long, OpcionCount> map = new HashMap<>();

        //Se itera sobre la lista de votos y contamos los votos por opción
        for(Voto voto: votosList){

            //Se Incrementa el 'total de votos' por cada voto (Contador General por Encuesta)
            totalVotos++;

            //Se obtiene la (OpcionId) y el valor de la (Opción) por cada -voto- y lo asignamos a la variable (opcionCount)
            OpcionCount opcionCount = map.get(voto.getOpcion().getId());

            /*
                Si opcionCount es null: En la primera Iteración será -Null-
                (Es decir, es la primera vez que se encuentra esta opción; entonces, creará una nueva instancia de
                 OpcionCount, establece su ID y la agrega al map.)
             */
            if(opcionCount == null){
                //Crea una nueva instancia de OpcionCount
                opcionCount = new OpcionCount();
                //Asigna el (Id) para opcionCount y obtiene el (Id) y la opcion votada
                opcionCount.setOpcionId(voto.getOpcion().getId());
                //Finalmente, agrega el (Id) de opcionCount, el (Id) y la opción votada al map
                map.put(voto.getOpcion().getId(),opcionCount);
            }

            //Aumenta la variable (count) ++; Incrementando así el conteo de votos para la opción correspondiente.
            opcionCount.setCount(opcionCount.getCount() + 1);
        }

        //Se Establece el total de votos en el resultado (Contador General)
        votoResult.setTotalVotos(totalVotos);

        //Se Convierte los valores del -map- en una Lista y los establece como resultado
        votoResult.setResults(new ArrayList<>(map.values()));

        /*
            Se Crea una lista -votoResults- y agregamos los valores mapeados anteriormente:
                (Contador General de Votos por Encuesta) y (Contador de votos por opción)
        */
        List <VotoResult> votoResults = new ArrayList<>();
        votoResults.add(votoResult);

        //retornamos la Lista con el -results- que contiene el (total de votos por Encuesta) + (total de votos por Opción)
        return votoResults;

    }
}

