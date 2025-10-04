package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.PublicacionForoDTO;
import java.util.List;

public interface PublicacionForoService {
    PublicacionForoDTO createPublicacion(PublicacionForoDTO publicacionDTO);
    List<PublicacionForoDTO> getAllPublicaciones();
    List<PublicacionForoDTO> getPublicacionesByForo(Long foroId);
    void deletePublicacion(Long id);
}