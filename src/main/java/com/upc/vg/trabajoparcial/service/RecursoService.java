package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.RecursoDTO;

import java.util.List;

public interface RecursoService {
    RecursoDTO createRecurso(RecursoDTO recursoDTO);
    List<RecursoDTO> getAllRecursos();
    RecursoDTO updateRecurso(Long id, RecursoDTO recursoDTO); // <- este falta implementar
    void deleteRecurso(Long id);
}