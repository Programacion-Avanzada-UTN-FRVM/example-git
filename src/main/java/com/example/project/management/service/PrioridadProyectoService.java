package com.example.project.management.service;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.exception.NotFoundException;
import com.example.project.management.mapper.PrioridadProyectoMapper;
import com.example.project.management.model.PrioridadProyecto;
import com.example.project.management.repository.PrioridadProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PrioridadProyectoService implements IPrioridadProyectoService {

    @Autowired
    private PrioridadProyectoRepository prioridadProyectoRepository;
    @Override
    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNull() {
        List<PrioridadProyecto> prioridades = prioridadProyectoRepository.findAllByFechaEliminacionIsNull();
        return prioridades.stream().map(PrioridadProyectoMapper::toDTO).toList();
    }

    @Override
    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNotNull() {
        List<PrioridadProyecto> prioridades = prioridadProyectoRepository.findAllByFechaEliminacionIsNotNull();
        return prioridades.stream().map(PrioridadProyectoMapper::toDTO).toList();
    }

    @Override
    public PrioridadProyecto findById(Integer id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findById(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByIdAndFechaEliminacionIsNull(Integer id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByIdAndFechaEliminacionIsNull(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada o eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByIdAndFechaEliminacionIsNotNull(Integer id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByIdAndFechaEliminacionIsNotNull(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada o no se encuentra eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByPrioridad(String prioridad) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByPrioridad(prioridad);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + prioridad + "no encontrada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByPrioridadAndFechaEliminacionIsNull(String prioridad) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByPrioridadAndFechaEliminacionIsNull(prioridad);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + prioridad + "no encontrada o eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByPrioridadAndFechaEliminacionIsNotNull(String prioridad) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByPrioridadAndFechaEliminacionIsNotNull(prioridad);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + prioridad + "no encontrada o no se encuentra eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public void save(PrioridadProyecto prioridadProyecto) {
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void deleteById(Integer id) {
        PrioridadProyecto prioridadProyecto = this.findByIdAndFechaEliminacionIsNull(id);
        prioridadProyecto.eliminar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void deleteByPrioridad(String prioridad) {
        PrioridadProyecto prioridadProyecto = this.findByPrioridadAndFechaEliminacionIsNull(prioridad);
        prioridadProyecto.eliminar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void recuperarPorId(Integer id) {
        PrioridadProyecto prioridadProyecto = this.findByIdAndFechaEliminacionIsNotNull(id);
        prioridadProyecto.recuperar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void recuperarPorPrioridad (String prioridad) {
        PrioridadProyecto prioridadProyecto = this.findByPrioridadAndFechaEliminacionIsNotNull(prioridad);
        prioridadProyecto.recuperar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }
}
