package com.upc.vg.trabajoparcial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionDTO {
    private Long id;
    private String descripcion;
    private boolean leido;
}