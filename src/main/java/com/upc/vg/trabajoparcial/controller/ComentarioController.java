package com.upc.vg.trabajoparcial.controller;

import com.upc.vg.trabajoparcial.dto.ComentarioDTO;
import com.upc.vg.trabajoparcial.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> createComentario(@RequestBody ComentarioDTO comentarioDTO) {
        return ResponseEntity.ok(comentarioService.createComentario(comentarioDTO));
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> getAllComentarios() {
        return ResponseEntity.ok(comentarioService.getAllComentarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> getComentarioById(@PathVariable Long id) {
        return ResponseEntity.ok(comentarioService.getComentarioById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> updateComentario(@PathVariable Long id,
                                                          @RequestBody ComentarioDTO comentarioDTO) {
        return ResponseEntity.ok(comentarioService.updateComentario(id, comentarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
        return ResponseEntity.noContent().build();
    }
}