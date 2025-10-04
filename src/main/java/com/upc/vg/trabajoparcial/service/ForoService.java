package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.ForoDTO;
import java.util.List;

public interface ForoService {
    ForoDTO createForo(ForoDTO foroDTO);
    List<ForoDTO> getAllForos();
    ForoDTO getForoById(Long id);
    ForoDTO updateForo(Long id, ForoDTO foroDTO);
    void deleteForo(Long id);
}