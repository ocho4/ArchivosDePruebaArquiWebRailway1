package com.upc.vg.trabajoparcial.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCreateDTO {
    private String nombre;
    private String username;
    private String email;
    private String contrasena;
    private Long rolId;
}