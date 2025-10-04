package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.PublicacionForoDTO;
import com.upc.vg.trabajoparcial.entity.Foro;
import com.upc.vg.trabajoparcial.entity.PublicacionForo;
import com.upc.vg.trabajoparcial.entity.Usuario;
import com.upc.vg.trabajoparcial.repository.ForoRepository;
import com.upc.vg.trabajoparcial.repository.PublicacionForoRepository;
import com.upc.vg.trabajoparcial.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionForoServiceImpl implements PublicacionForoService {

    private final PublicacionForoRepository publicacionRepo;
    private final ForoRepository foroRepo;
    private final UsuarioRepository usuarioRepo;
    private final ModelMapper modelMapper = new ModelMapper();

    public PublicacionForoServiceImpl(PublicacionForoRepository publicacionRepo,
                                      ForoRepository foroRepo,
                                      UsuarioRepository usuarioRepo) {
        this.publicacionRepo = publicacionRepo;
        this.foroRepo = foroRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public PublicacionForoDTO createPublicacion(PublicacionForoDTO dto) {
        Foro foro = foroRepo.findById(dto.getForoId())
                .orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        PublicacionForo publicacion = new PublicacionForo();
        publicacion.setTitulo(dto.getTitulo());
        publicacion.setContenido(dto.getContenido());
        publicacion.setForo(foro);
        publicacion.setUsuario(usuario);

        return modelMapper.map(publicacionRepo.save(publicacion), PublicacionForoDTO.class);
    }

    @Override
    public List<PublicacionForoDTO> getAllPublicaciones() {
        return publicacionRepo.findAll().stream()
                .map(p -> modelMapper.map(p, PublicacionForoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicacionForoDTO> getPublicacionesByForo(Long foroId) {
        return publicacionRepo.findByForoId(foroId).stream()
                .map(p -> modelMapper.map(p, PublicacionForoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePublicacion(Long id) {
        publicacionRepo.deleteById(id);
    }
}
