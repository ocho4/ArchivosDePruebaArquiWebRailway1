package com.upc.vg.trabajoparcial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private LocalDateTime fecha;

    @ManyToOne
    private PublicacionForo publicacion;

    @ManyToOne
    private Usuario usuario;

    @PrePersist
    public void prePersist() {
        fecha = LocalDateTime.now();
    }
}