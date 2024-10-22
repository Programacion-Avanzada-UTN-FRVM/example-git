package com.example.project.services.reclamoServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.project.mapper.ReclamoMapper;
import com.example.project.models.Reclamo;
import com.example.project.models.TipoReclamo;
import com.example.project.repositories.IReclamoRepository;
import com.example.project.services.reclamoServices.interfaces.IBuscarReclamoService;

public class BuscarReclamoService implements IBuscarReclamoService{

    @Autowired
    private IReclamoRepository repository;

    @Override
    public ResponseEntity<?> buscarReclamo(Long id) {

        Optional<Reclamo> optionalReclamo = repository.findById(id);
        if (optionalReclamo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ReclamoMapper.toDto(optionalReclamo.get()));

    }

    @Override
    public ResponseEntity<?> buscarReclamos() {
        return ResponseEntity
            .ok()
            .body(
                ReclamoMapper.toDtoList((List<Reclamo>) repository.findAll())
            );
    }

    @Override
    public ResponseEntity<?> buscarReclamosPorTipo(TipoReclamo tipoReclamo) {
        //Metodo no implementado
        return null;
    }
    
}
