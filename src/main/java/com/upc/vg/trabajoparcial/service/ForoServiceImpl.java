package com.upc.vg.trabajoparcial.service;

import com.upc.vg.trabajoparcial.dto.ForoDTO;
import com.upc.vg.trabajoparcial.entity.Foro;
import com.upc.vg.trabajoparcial.repository.ForoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForoServiceImpl implements ForoService {

    private final ForoRepository foroRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ForoServiceImpl(ForoRepository foroRepository) {
        this.foroRepository = foroRepository;
    }

    @Override
    public ForoDTO createForo(ForoDTO foroDTO) {
        Foro foro = modelMapper.map(foroDTO, Foro.class);
        return modelMapper.map(foroRepository.save(foro), ForoDTO.class);
    }

    @Override
    public List<ForoDTO> getAllForos() {
        return foroRepository.findAll().stream()
                .map(f -> modelMapper.map(f, ForoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ForoDTO getForoById(Long id) {
        Foro foro = foroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        return modelMapper.map(foro, ForoDTO.class);
    }

    @Override
    public ForoDTO updateForo(Long id, ForoDTO foroDTO) {
        Foro foro = foroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        foro.setTitulo(foroDTO.getTitulo());
        foro.setDescripcion(foroDTO.getDescripcion());
        return modelMapper.map(foroRepository.save(foro), ForoDTO.class);
    }

    @Override
    public void deleteForo(Long id) {
        foroRepository.deleteById(id);
    }
}
