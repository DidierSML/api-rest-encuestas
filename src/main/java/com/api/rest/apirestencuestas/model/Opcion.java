package com.api.rest.apirestencuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opcion")
public class Opcion {

    @Id
    @GeneratedValue
    @Column (name = "opcion_id")
    private Long id;

    private String value;
}
