package com.example.project.dto;

import lombok.Data;

@Data
public class TipoReclamoDTO {
    private Long id;
    private String nombre;

    public TipoReclamoDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
