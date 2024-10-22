package com.example.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TipoReclamoDTO {
    private Long id;
    private String nombre;

    private LocalDateTime creationDatetime;

    public TipoReclamoDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoReclamoDTO(Long id, String nombre, LocalDateTime creationDatetime) {
        this.id = id;
        this.nombre = nombre;
        this.creationDatetime = creationDatetime;
    }
}
