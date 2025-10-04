package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.ComentarioDTO;
import com.upc.vg.trabajoparcial.entity.Comentario;
import com.upc.vg.trabajoparcial.repository.ComentarioRepository;
import com.upc.vg.trabajoparcial.repository.PublicacionForoRepository;
import com.upc.vg.trabajoparcial.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final PublicacionForoRepository publicacionRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository,
                                 UsuarioRepository usuarioRepository,
                                 PublicacionForoRepository publicacionRepository) {
        this.comentarioRepository = comentarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
    }

    @Override
    public ComentarioDTO createComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = modelMapper.map(comentarioDTO, Comentario.class);
        comentario.setUsuario(usuarioRepository.findById(comentarioDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        comentario.setPublicacion(publicacionRepository.findById(comentarioDTO.getPublicacionId())
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada")));
        return modelMapper.map(comentarioRepository.save(comentario), ComentarioDTO.class);
    }

    @Override
    public List<ComentarioDTO> getAllComentarios() {
        return comentarioRepository.findAll().stream()
                .map(c -> {
                    ComentarioDTO dto = modelMapper.map(c, ComentarioDTO.class);
                    dto.setUsuarioId(c.getUsuario().getId());
                    dto.setPublicacionId(c.getPublicacion().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO getComentarioById(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        ComentarioDTO dto = modelMapper.map(comentario, ComentarioDTO.class);
        dto.setUsuarioId(comentario.getUsuario().getId());
        dto.setPublicacionId(comentario.getPublicacion().getId());
        return dto;
    }

    @Override
    public ComentarioDTO updateComentario(Long id, ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        comentario.setContenido(comentarioDTO.getContenido());
        comentario.setUsuario(usuarioRepository.findById(comentarioDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        comentario.setPublicacion(publicacionRepository.findById(comentarioDTO.getPublicacionId())
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada")));
        return modelMapper.map(comentarioRepository.save(comentario), ComentarioDTO.class);
    }

    @Override
    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
