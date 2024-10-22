package com.example.project.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class TipoReclamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private LocalDateTime creationDatetime;

    @PrePersist
    public void preCreate() {
        creationDatetime = LocalDateTime.now();
    }

    public TipoReclamo() {

    }

    public TipoReclamo(String nombre) {
        this.nombre = nombre;
    }
}
