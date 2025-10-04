package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.RolDTO;
import java.util.List;

public interface RolService {
    RolDTO createRol(RolDTO rolDTO);
    RolDTO updateRol(Long id, RolDTO rolDTO);
    RolDTO getRolById(Long id);
    List<RolDTO> getAllRoles();
    void deleteRol(Long id);
}