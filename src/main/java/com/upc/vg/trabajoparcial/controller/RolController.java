package com.upc.vg.trabajoparcial.controller;

import com.upc.vg.trabajoparcial.dto.RolDTO;
import com.upc.vg.trabajoparcial.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public RolDTO createRol(@RequestBody RolDTO rolDTO) {
        return rolService.createRol(rolDTO);
    }

    @PutMapping("/{id}")
    public RolDTO updateRol(@PathVariable Long id, @RequestBody RolDTO rolDTO) {
        return rolService.updateRol(id, rolDTO);
    }

    @GetMapping("/{id}")
    public RolDTO getRolById(@PathVariable Long id) {
        return rolService.getRolById(id);
    }

    @GetMapping
    public List<RolDTO> getAllRoles() {
        return rolService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
    }
}