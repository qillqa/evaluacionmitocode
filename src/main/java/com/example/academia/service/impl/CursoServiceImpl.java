package com.example.academia.service.impl;

import com.example.academia.model.Curso;
import com.example.academia.repo.ICursoRepo;
import com.example.academia.repo.IGenericRepo;
import com.example.academia.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl  extends CRUDImpl<Curso, Integer> implements ICursoService {
    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
