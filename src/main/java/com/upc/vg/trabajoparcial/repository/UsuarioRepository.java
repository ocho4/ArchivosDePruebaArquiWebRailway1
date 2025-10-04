package com.upc.vg.trabajoparcial.repository;

import com.upc.vg.trabajoparcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
