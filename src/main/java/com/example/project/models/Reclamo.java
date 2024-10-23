package com.example.project.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Reclamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_reclamo_id")
    private TipoReclamo tipoReclamo;

    private String descripcion;

    private boolean critico;

    public Reclamo() {

    }

    public Reclamo(Long id, TipoReclamo tipoReclamo, String descripcion, boolean critico) {
        this.id = id;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.critico = critico;
    }

    
}
