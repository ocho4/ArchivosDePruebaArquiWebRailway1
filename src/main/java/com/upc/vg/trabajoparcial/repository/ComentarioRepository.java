package com.upc.vg.trabajoparcial.repository;

import com.upc.vg.trabajoparcial.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}