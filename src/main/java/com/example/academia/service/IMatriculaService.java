package com.example.academia.service;

import com.example.academia.model.Matricula;

import java.util.Map;
import java.util.Set;

public interface IMatriculaService extends ICRUD<Matricula, Integer> {
    Map<String, Set<String>> getCursosConEstudiantes();
}
