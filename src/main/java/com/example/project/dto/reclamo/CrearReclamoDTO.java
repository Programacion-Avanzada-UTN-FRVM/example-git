package com.example.project.dto.reclamo;

import lombok.Data;

@Data
public class CrearReclamoDTO {

    private Long tipoReclamoId;
    private String descripcion;
    private boolean critico;

    public CrearReclamoDTO(Long tipoReclamoId, String descripcion, boolean critico) {
        this.tipoReclamoId = tipoReclamoId;
        this.descripcion = descripcion;
        this.critico = critico;
    }
}
