package com.upc.vg.trabajoparcial.dto;

import lombok.Getter;
import lombok.Data;

@Getter
@Data
public class PublicacionForoDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private Long foroId;
    private Long usuarioId;
}