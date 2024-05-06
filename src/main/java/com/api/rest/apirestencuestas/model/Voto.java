package com.api.rest.apirestencuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @Column (name = "voto_id")
    private Long id;

    //Muchos -Votos- va a tener una -opción-
    @ManyToOne
    @JoinColumn(name = "opcion_id")
    private Opcion opcion;
}
