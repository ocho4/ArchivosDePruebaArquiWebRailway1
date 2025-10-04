package com.upc.vg.trabajoparcial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias_recursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaRecursoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RecursoEducativo recurso;

    @ManyToOne
    private Categoria categoria;
}