package com.example.academia.service;

import com.example.academia.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante, Integer> {
    List<Estudiante> findByAllAgeOrderDesc();
}
