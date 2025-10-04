package com.upc.vg.trabajoparcial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "publicaciones_foro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicacionForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String contenido;
    private LocalDateTime fecha;

    @ManyToOne
    private Foro foro;

    @ManyToOne
    private Usuario usuario;
}