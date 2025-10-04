package com.upc.vg.trabajoparcial.controller;


import com.upc.vg.trabajoparcial.dto.PublicacionForoDTO;
import com.upc.vg.trabajoparcial.service.PublicacionForoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionForoController {

    private final PublicacionForoService publicacionService;

    public PublicacionForoController(PublicacionForoService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<PublicacionForoDTO> createPublicacion(@RequestBody PublicacionForoDTO dto) {
        return ResponseEntity.ok(publicacionService.createPublicacion(dto));
    }

    @GetMapping
    public ResponseEntity<List<PublicacionForoDTO>> getAllPublicaciones() {
        return ResponseEntity.ok(publicacionService.getAllPublicaciones());
    }

    @GetMapping("/foro/{foroId}")
    public ResponseEntity<List<PublicacionForoDTO>> getPublicacionesByForo(@PathVariable Long foroId) {
        return ResponseEntity.ok(publicacionService.getPublicacionesByForo(foroId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable Long id) {
        publicacionService.deletePublicacion(id);
        return ResponseEntity.noContent().build();
    }
}
