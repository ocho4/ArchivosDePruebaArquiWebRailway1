package com.upc.vg.trabajoparcial.controller;

import com.upc.vg.trabajoparcial.dto.ForoDTO;
import com.upc.vg.trabajoparcial.service.ForoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foros")
public class ForoController {

    private final ForoService foroService;

    public ForoController(ForoService foroService) {
        this.foroService = foroService;
    }

    @PostMapping
    public ResponseEntity<ForoDTO> createForo(@RequestBody ForoDTO foroDTO) {
        return ResponseEntity.ok(foroService.createForo(foroDTO));
    }

    @GetMapping
    public ResponseEntity<List<ForoDTO>> getAllForos() {
        return ResponseEntity.ok(foroService.getAllForos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForoDTO> getForoById(@PathVariable Long id) {
        return ResponseEntity.ok(foroService.getForoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForoDTO> updateForo(@PathVariable Long id, @RequestBody ForoDTO foroDTO) {
        return ResponseEntity.ok(foroService.updateForo(id, foroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForo(@PathVariable Long id) {
        foroService.deleteForo(id);
        return ResponseEntity.noContent().build();
    }
}