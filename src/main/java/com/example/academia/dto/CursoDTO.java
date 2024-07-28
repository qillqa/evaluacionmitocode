package com.example.academia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {
    private Integer idCurso;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 200)
    private String nombre;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 10)
    private String siglas;

    @NotNull
    private boolean estado;
}
