package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaService {
    CategoriaDTO createCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO);
    CategoriaDTO getCategoriaById(Long id);
    List<CategoriaDTO> getAllCategorias();
    void deleteCategoria(Long id);
}