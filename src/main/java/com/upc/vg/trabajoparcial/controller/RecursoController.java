package com.upc.vg.trabajoparcial.controller;

import com.upc.vg.trabajoparcial.dto.RecursoDTO;
import com.upc.vg.trabajoparcial.service.RecursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostMapping
    public RecursoDTO createRecurso(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.createRecurso(recursoDTO);
    }

    @GetMapping
    public List<RecursoDTO> getAllRecursos() {
        return recursoService.getAllRecursos();
    }

    @PutMapping("/{id}")
    public RecursoDTO updateRecurso(@PathVariable Long id, @RequestBody RecursoDTO recursoDTO) {
        return recursoService.updateRecurso(id, recursoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRecurso(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
    }
}