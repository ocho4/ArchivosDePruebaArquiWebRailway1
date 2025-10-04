package com.upc.vg.trabajoparcial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "foros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Categoria categoria;
}