package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.RecursoDTO;
import com.upc.vg.trabajoparcial.entity.Categoria;
import com.upc.vg.trabajoparcial.entity.RecursoEducativo;
import com.upc.vg.trabajoparcial.entity.Usuario;
import com.upc.vg.trabajoparcial.repository.CategoriaRepository;
import com.upc.vg.trabajoparcial.repository.RecursoEducativoRepository;
import com.upc.vg.trabajoparcial.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoServiceImpl implements RecursoService {

    private final RecursoEducativoRepository recursoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public RecursoServiceImpl(RecursoEducativoRepository recursoRepository,
                              UsuarioRepository usuarioRepository,
                              CategoriaRepository categoriaRepository) {
        this.recursoRepository = recursoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public RecursoDTO createRecurso(RecursoDTO recursoDTO) {
        RecursoEducativo recurso = modelMapper.map(recursoDTO, RecursoEducativo.class);

        Usuario usuario = usuarioRepository.findById(recursoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Categoria categoria = categoriaRepository.findById(recursoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        recurso.setUsuario(usuario);
        recurso.setCategoria(categoria);

        RecursoEducativo saved = recursoRepository.save(recurso);
        return modelMapper.map(saved, RecursoDTO.class);
    }

    @Override
    public List<RecursoDTO> getAllRecursos() {
        return recursoRepository.findAll().stream()
                .map(r -> {
                    RecursoDTO dto = modelMapper.map(r, RecursoDTO.class);
                    dto.setUsuarioId(r.getUsuario().getId());
                    dto.setCategoriaId(r.getCategoria().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RecursoDTO updateRecurso(Long id, RecursoDTO recursoDTO) {
        RecursoEducativo recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso no encontrado"));

        recurso.setTitulo(recursoDTO.getTitulo());
        recurso.setDescripcion(recursoDTO.getDescripcion());

        Usuario usuario = usuarioRepository.findById(recursoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Categoria categoria = categoriaRepository.findById(recursoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        recurso.setUsuario(usuario);
        recurso.setCategoria(categoria);

        RecursoEducativo updated = recursoRepository.save(recurso);
        return modelMapper.map(updated, RecursoDTO.class);
    }

    @Override
    public void deleteRecurso(Long id) {
        recursoRepository.deleteById(id);
    }
}