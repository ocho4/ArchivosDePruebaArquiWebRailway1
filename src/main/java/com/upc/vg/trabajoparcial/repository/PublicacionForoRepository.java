package com.upc.vg.trabajoparcial.repository;

import com.upc.vg.trabajoparcial.entity.PublicacionForo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PublicacionForoRepository extends JpaRepository<PublicacionForo, Long> {
    Collection<Object> findByForoId(Long foroId);
}