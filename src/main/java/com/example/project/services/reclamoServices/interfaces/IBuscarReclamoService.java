package com.example.project.services.reclamoServices.interfaces;

import org.springframework.http.ResponseEntity;

import com.example.project.models.TipoReclamo;

public interface IBuscarReclamoService {
    
    ResponseEntity<?> buscarReclamo(Long id);

    ResponseEntity<?> buscarReclamos();

    ResponseEntity<?> buscarReclamosPorTipo(TipoReclamo tipoReclamo);
}
