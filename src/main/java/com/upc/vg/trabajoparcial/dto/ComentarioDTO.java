package com.upc.vg.trabajoparcial.dto;

import lombok.Getter;
import lombok.Data;

@Getter
@Data
public class ComentarioDTO {
    private Long id;
    private String contenido;
    private Long usuarioId;
    private Long publicacionId;
}