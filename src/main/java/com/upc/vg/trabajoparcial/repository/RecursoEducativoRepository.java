package com.upc.vg.trabajoparcial.repository;

import com.upc.vg.trabajoparcial.entity.RecursoEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoEducativoRepository extends JpaRepository<RecursoEducativo, Long> {
}
