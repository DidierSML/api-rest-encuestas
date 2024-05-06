package com.api.rest.apirestencuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="encuesta")
public class Encuesta {

    @Id
    @GeneratedValue //Para este caso
    @Column(name = "encuesta_id")
    private Long id;

    @Column(name ="pregunta")
    private String pregunta;

    //Una -Encuesta- va a tener -Muchas- Opciones
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "encuesta_id")
    @OrderBy
    private Set <Opcion> opciones = new HashSet<>();
    //A través de este Set<Opcion> podemos enviar nuestras Opciones en el "saveEncuesta" desde -Postman-


}
/*
    "saveEncuesta" -> lógica
    {
        "pregunta": "¿Cual es el lenguaje de programación más popular en 2024?",
        "opciones":
            [
                {"value": "Java"},
                {"value": "Phyton"},
                {"value": "Go"},
                {"value": "Javascript"}
            ]

    }
    ---------------------------------------------------------------------------------

    "saveEncuesta" <- lógica------------------------------Status(201)Created

     {
        "id": 1,
        "pregunta": "¿Cual es el lenguaje de programación más popular en 2024?",
        "opciones": [
            {
                "id": 1,
                "value": "Phyton"
            },
            {
                "id": 2,
                "value": "Java"
            },
            {
                "id": 3,
                "value": "Go"
            },
            {
                "id": 4,
                "value": "Javascript"
            }
        ]
    }
 */
