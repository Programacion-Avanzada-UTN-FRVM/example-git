package com.example.project.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Reclamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_reclamo_id")
    private TipoReclamo tipoReclamo;

    private String descripcion;

    private boolean esCritico;

    private LocalDateTime creationDatetime;

    @PrePersist //Este metodo se ejecutara antes de crear persistir al objeto en la BD
    public void preCreate() {
        creationDatetime = LocalDateTime.now();
    }

    public Reclamo() {

    }

    public Reclamo(TipoReclamo tipoReclamo, String descripcion, boolean esCritico) {
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.esCritico = esCritico;
    }
}
