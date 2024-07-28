package com.example.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_MATRICULACAB_ESTUDIANTE"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private LocalDateTime fechaMatricula;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<MatriculaDetalle> detalleMatricula;
}
