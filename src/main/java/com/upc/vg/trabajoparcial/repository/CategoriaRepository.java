package com.upc.vg.trabajoparcial.repository;

import com.upc.vg.trabajoparcial.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}