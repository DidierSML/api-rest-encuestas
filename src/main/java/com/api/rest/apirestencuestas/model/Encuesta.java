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




}
