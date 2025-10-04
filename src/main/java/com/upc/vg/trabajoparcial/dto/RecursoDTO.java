package com.upc.vg.trabajoparcial.dto;

import lombok.Data;

@Data
public class RecursoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long usuarioId;
    private Long categoriaId;
}