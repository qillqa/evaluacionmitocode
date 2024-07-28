package com.example.academia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {
    private Integer idEstudiante;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String nombres;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String apellidos;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    @Size(min = 8, max = 8)
    private String dni;

    @NotNull
    @Min(value = 6)
    @Max(value = 99)
    private int edad;
}
