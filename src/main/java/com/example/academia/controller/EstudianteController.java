package com.example.academia.controller;

import com.example.academia.dto.EstudianteDTO;
import com.example.academia.model.Estudiante;
import com.example.academia.service.IEstudianteService;
import com.example.academia.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception {
        List<EstudianteDTO> list = mapperUtil.mapList(service.readAll(), EstudianteDTO.class);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") int id) throws Exception {
        EstudianteDTO obj = mapperUtil.map(service.readById(id), EstudianteDTO.class);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));

        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @PathVariable("id") int id, @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.update(mapperUtil.map(dto, Estudiante.class), id);

        return ResponseEntity.ok(mapperUtil.map(obj, EstudianteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    /********** queries **********/
    @GetMapping("/get/edad/desc")
    public ResponseEntity<List<EstudianteDTO>> readAllAgeOrderDesc() throws Exception {
        List<EstudianteDTO> list = mapperUtil.mapList(service.findByAllAgeOrderDesc(), EstudianteDTO.class);

        return ResponseEntity.ok(list);
    }

}
