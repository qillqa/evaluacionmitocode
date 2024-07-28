package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 10, nullable = false)
    private String siglas;

    @Column(nullable = false)
    private boolean estado;
}
