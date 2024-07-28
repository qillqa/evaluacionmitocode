package com.example.academia.controller;

import com.example.academia.dto.CursoDTO;
import com.example.academia.model.Curso;
import com.example.academia.service.ICursoService;
import com.example.academia.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception {
        List<CursoDTO> list = mapperUtil.mapList(service.readAll(), CursoDTO.class);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") int id) throws Exception {
        CursoDTO obj = mapperUtil.map(service.readById(id), CursoDTO.class);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.save(mapperUtil.map(dto, Curso.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable("id") int id, @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.update(mapperUtil.map(dto, Curso.class), id);

        return ResponseEntity.ok(mapperUtil.map(obj, CursoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
