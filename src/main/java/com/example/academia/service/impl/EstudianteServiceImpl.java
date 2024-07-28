package com.example.academia.service.impl;

import com.example.academia.model.Estudiante;
import com.example.academia.repo.IEstudianteRepo;
import com.example.academia.repo.IGenericRepo;
import com.example.academia.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {
    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> findByAllAgeOrderDesc() {
        //return repo.findAll(Sort.by(Sort.Direction.DESC, "edad"));
        return repo.findAll()
                .stream()
                //.sorted((e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad())) // ASC
                .sorted((e1, e2) -> Integer.compare(e2.getEdad(), e1.getEdad())) // DESC
                .collect(Collectors.toList());
    }
}
