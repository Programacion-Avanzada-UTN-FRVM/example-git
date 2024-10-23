package com.example.project.management.DTO;

import com.example.project.management.model.PrioridadProyecto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrioridadProyectoDTO {

    private Long id;
    private String nombre;
    private LocalDateTime fechaEliminacion;

}
