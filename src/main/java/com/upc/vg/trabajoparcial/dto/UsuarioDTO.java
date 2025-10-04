package com.upc.vg.trabajoparcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String contrasena;
    private Long rolId; // referencia al Rol si lo necesitas
}