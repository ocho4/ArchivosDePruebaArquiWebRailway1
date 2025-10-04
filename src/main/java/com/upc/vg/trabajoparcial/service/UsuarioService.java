package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuarioById(Long id);
    List<UsuarioDTO> getAllUsuarios();
    void deleteUsuario(Long id);
}