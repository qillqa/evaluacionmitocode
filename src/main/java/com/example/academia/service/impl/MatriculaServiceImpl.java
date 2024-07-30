package com.example.academia.service.impl;

import com.example.academia.model.Matricula;
import com.example.academia.repo.IGenericRepo;
import com.example.academia.repo.IMatriculaRepo;
import com.example.academia.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {
    private final IMatriculaRepo repo;
    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, Set<String>> getCursosConEstudiantes() {
        Map<String, Set<String>> cursosConEstudiantes = repo.findAll().stream()
                .flatMap(matricula -> matricula.getDetalleMatricula().stream()
                        .map(detalle -> new AbstractMap.SimpleEntry<>(
                                detalle.getCurso().getNombre()
                                , matricula.getEstudiante().getNombres() +" "+ matricula.getEstudiante().getApellidos()
                        )))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));

        /*
        cursosConEstudiantes.forEach((curso, estudiantes) -> {
            System.out.println(curso + ": " + estudiantes);
        });
        */

        return cursosConEstudiantes;
    }
}
