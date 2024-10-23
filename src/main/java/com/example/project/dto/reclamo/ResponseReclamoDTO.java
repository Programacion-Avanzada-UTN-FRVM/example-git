package com.example.project.dto.reclamo;



import com.example.project.models.TipoReclamo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseReclamoDTO {
    private Long id;

    private TipoReclamo tipoReclamo;

    private String descripcion;

    private boolean critico;



    public ResponseReclamoDTO(Long id, TipoReclamo tipoReclamo, String descripcion, boolean critico) {
        this.id = id;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.critico = critico;

    }
}