package com.example.project.dto.Reporte;

import java.time.LocalDateTime;

import com.example.project.models.TipoReclamo;

import lombok.Data;

@Data
public class ResponseReporteDTO {
    private Long id;

    private TipoReclamo tipoReclamo;

    private String descripcion;

    private boolean esCritico;

    private LocalDateTime creationDatetime;

    public ResponseReporteDTO(Long id, TipoReclamo tipoReclamo, String descripcion, boolean esCritico, LocalDateTime creationDatetime) {
        this.id = id;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.esCritico = esCritico;
        this.creationDatetime = creationDatetime;
    }
}
