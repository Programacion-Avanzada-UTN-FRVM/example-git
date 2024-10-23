package com.example.project.mapper;

import java.util.List;

import com.example.project.dto.reclamo.CrearReclamoDTO;
import com.example.project.dto.reclamo.ResponseReclamoDTO;
import com.example.project.models.Reclamo;
import com.example.project.models.TipoReclamo;

public class ReclamoMapper {
    
    public static ResponseReclamoDTO toDto(Reclamo reclamo){
        return ResponseReclamoDTO.builder()
        .id(reclamo.getId())
        .tipoReclamo(reclamo.getTipoReclamo())
        .descripcion(reclamo.getDescripcion())
        .critico(reclamo.isCritico())
        .build();
    }

    public static Reclamo toEntity(CrearReclamoDTO reclamoDto, TipoReclamo tipoReclamo){
        return Reclamo.builder()
        .tipoReclamo(tipoReclamo)
        .descripcion(reclamoDto.getDescripcion())
        .critico(reclamoDto.isCritico())
        .build();
    }

    public static List<ResponseReclamoDTO> toDtoList(List<Reclamo> reclamos){
        return reclamos
            .stream()
            .map(ReclamoMapper::toDto)
            .toList();
    }
}
