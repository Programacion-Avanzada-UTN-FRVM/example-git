package com.example.project.management.mapper;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.model.PrioridadProyecto;

public class PrioridadProyectoMapper {
    public static PrioridadProyectoDTO toDTO(PrioridadProyecto model) {
        PrioridadProyectoDTO dto = new PrioridadProyectoDTO();
        dto.setId(model.getId());
        dto.setPrioridad(model.getPrioridad());
        dto.setFechaEliminacion(model.getFechaEliminacion());
        return dto;
    }

    public static PrioridadProyecto toEntity(PrioridadProyectoDTO dto) {
        PrioridadProyecto model = new PrioridadProyecto(dto.getPrioridad());
        model.setId(dto.getId());
        model.setFechaEliminacion(dto.getFechaEliminacion());
        return model;
    }
}
