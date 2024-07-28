package com.example.academia.service.impl;

import com.example.academia.model.Matricula;
import com.example.academia.repo.IGenericRepo;
import com.example.academia.repo.IMatriculaRepo;
import com.example.academia.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {
    private final IMatriculaRepo repo;
    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
