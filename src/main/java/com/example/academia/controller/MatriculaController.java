package com.example.academia.controller;

import com.example.academia.dto.MatriculaDTO;
import com.example.academia.model.Matricula;
import com.example.academia.service.IMatriculaService;
import com.example.academia.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception {
        List<MatriculaDTO> list = mapperUtil.mapList(service.readAll(), MatriculaDTO.class);

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/coursesStudents")
    public ResponseEntity<Map<String, Set<String>>> listCoursesStudents(){
        Map<String, Set<String>> coursesStudents = service.getCursosConEstudiantes();

        return ResponseEntity.ok(coursesStudents);
    }
}
