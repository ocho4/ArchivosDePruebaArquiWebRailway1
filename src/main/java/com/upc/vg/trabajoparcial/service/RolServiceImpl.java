package com.upc.vg.trabajoparcial.service;


import com.upc.vg.trabajoparcial.dto.RolDTO;
import com.upc.vg.trabajoparcial.entity.Rol;
import com.upc.vg.trabajoparcial.repository.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final ModelMapper modelMapper;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public RolDTO createRol(RolDTO rolDTO) {
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        return modelMapper.map(rolRepository.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO updateRol(Long id, RolDTO rolDTO) {
        Rol rol = rolRepository.findById(id).orElseThrow();
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());
        return modelMapper.map(rolRepository.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO getRolById(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow();
        return modelMapper.map(rol, RolDTO.class);
    }

    @Override
    public List<RolDTO> getAllRoles() {
        return rolRepository.findAll().stream()
                .map(r -> modelMapper.map(r, RolDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
