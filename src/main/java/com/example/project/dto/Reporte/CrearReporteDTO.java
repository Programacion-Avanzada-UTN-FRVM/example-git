package com.example.project.dto.Reporte;

import lombok.Data;

@Data
public class CrearReporteDTO {
    private Long reclamoId;
    private boolean esCritico;

    public CrearReporteDTO(Long reclamoId, boolean esCritico) {
        this.reclamoId = reclamoId;
        this.esCritico = esCritico;
    }
}
