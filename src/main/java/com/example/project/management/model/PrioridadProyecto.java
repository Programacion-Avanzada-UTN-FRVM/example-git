package com.example.project.management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "prioridad_proyecto")
@Data
public class PrioridadProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prioridad" , nullable = false, unique = true)
    @NonNull
    private String prioridad;

    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;

    public void eliminar() {
        this.fechaEliminacion = LocalDateTime.now();
    }

    public void recuperar() {
        this.setFechaEliminacion(null);
    }

    public boolean esEliminado() { return this.fechaEliminacion != null; }

}
