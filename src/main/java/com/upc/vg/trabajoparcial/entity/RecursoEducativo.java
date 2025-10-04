package com.upc.vg.trabajoparcial.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecursoEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Categoria categoria;
}