package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.ComentarioDTO;
import java.util.List;

public interface ComentarioService {
    ComentarioDTO createComentario(ComentarioDTO comentarioDTO);
    List<ComentarioDTO> getAllComentarios();
    ComentarioDTO getComentarioById(Long id);
    ComentarioDTO updateComentario(Long id, ComentarioDTO comentarioDTO);
    void deleteComentario(Long id);
}
