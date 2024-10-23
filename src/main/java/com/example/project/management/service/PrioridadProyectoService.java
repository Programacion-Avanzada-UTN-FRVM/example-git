package com.example.project.management.service;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.exception.BadRequestException;
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
    public PrioridadProyecto findById(Long id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findById(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByIdAndFechaEliminacionIsNull(Long id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByIdAndFechaEliminacionIsNull(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada o eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByIdAndFechaEliminacionIsNotNull(Long id) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByIdAndFechaEliminacionIsNotNull(id);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + id + "no encontrada o no se encuentra eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByNombre(String nombre) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByNombre(nombre);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + nombre + "no encontrada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByNombreAndFechaEliminacionIsNull(String nombre) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByNombreAndFechaEliminacionIsNull(nombre);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + nombre + "no encontrada o eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto findByNombreAndFechaEliminacionIsNotNull(String nombre) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findByNombreAndFechaEliminacionIsNotNull(nombre);
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad " + nombre + "no encontrada o no se encuentra eliminada");
        }
        return prioridadProyecto.get();
    }

    @Override
    public PrioridadProyecto crear(PrioridadProyectoDTO prioridadProyectoDTO) {
        this.tieneNombre(prioridadProyectoDTO);
        this.nombreFormato(prioridadProyectoDTO);
        this.longitudNombre(prioridadProyectoDTO);
        if (prioridadExistente(prioridadProyectoDTO)){
            PrioridadProyecto prioridadProyectoRepetido = this.findByNombre(prioridadProyectoDTO.getNombre());
            if (prioridadProyectoRepetido.esEliminado()){
                prioridadProyectoRepetido.recuperar();
                return prioridadProyectoRepetido;
            }else {
                throw new BadRequestException("La prioridad ya existe");
            }
        } else {
            PrioridadProyecto prioridadProyecto = new PrioridadProyecto (prioridadProyectoDTO.getNombre());
            prioridadProyecto.setFechaEliminacion(null);
            prioridadProyectoRepository.save(prioridadProyecto);
            return prioridadProyecto;
        }
    }

    public void tieneNombre (PrioridadProyectoDTO prioridadProyectoDTO){
        if (prioridadProyectoDTO.getNombre() == null){
            throw new BadRequestException("Nombre no puede ser nulo");
        }
    }

    public void nombreFormato (PrioridadProyectoDTO prioridadProyectoDTO){
        if (!prioridadProyectoDTO.getNombre().matches("[a-zA-Z]+")){
            throw new BadRequestException("El nombre no puede contener caracteres especiales");
        }
    }

    public void longitudNombre (PrioridadProyectoDTO prioridadProyectoDTO){
        if (prioridadProyectoDTO.getNombre().length() > 100){
            throw new BadRequestException("Prioridad no puede superar los 100 caracteres");
        }
    }

    public boolean prioridadExistente (PrioridadProyectoDTO prioridadProyectoDTO){
        return prioridadProyectoRepository.existsByNombre(prioridadProyectoDTO.getNombre());
    }

    @Override
    public void deleteById(Long id) {
        PrioridadProyecto prioridadProyecto = this.findByIdAndFechaEliminacionIsNull(id);
        prioridadProyecto.eliminar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void deleteByNombre(String nombre) {
        PrioridadProyecto prioridadProyecto = this.findByNombreAndFechaEliminacionIsNull(nombre);
        prioridadProyecto.eliminar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }


    @Override
    public void recuperarPorId(Long id) {
        PrioridadProyecto prioridadProyecto = this.findByIdAndFechaEliminacionIsNotNull(id);
        prioridadProyecto.recuperar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public void recuperarPorNombre (String prioridad) {
        PrioridadProyecto prioridadProyecto = this.findByNombreAndFechaEliminacionIsNotNull(prioridad);
        prioridadProyecto.recuperar();
        prioridadProyectoRepository.save(prioridadProyecto);
    }

    @Override
    public PrioridadProyecto update (PrioridadProyectoDTO prioridadProyectoDTO) {
        Optional<PrioridadProyecto> prioridadProyecto = prioridadProyectoRepository.findById(prioridadProyectoDTO.getId());
        if (prioridadProyecto.isEmpty()){
            throw new NotFoundException("Prioridad con id: " + prioridadProyectoDTO.getId() + "no encontrada");
        }
        this.tieneNombre(prioridadProyectoDTO);
        this.nombreFormato(prioridadProyectoDTO);
        this.longitudNombre(prioridadProyectoDTO);
        if (prioridadExistente(prioridadProyectoDTO)){
            PrioridadProyecto prioridadProyectoRepetido = this.findByNombre(prioridadProyectoDTO.getNombre());
            if (prioridadProyectoRepetido.esEliminado()){
                prioridadProyectoRepetido.recuperar();
                return prioridadProyectoRepetido;
            }else {
                throw new BadRequestException("La prioridad ya existe");
            }
        }
        prioridadProyecto.get().setNombre(prioridadProyectoDTO.getNombre());
        prioridadProyectoRepository.save(prioridadProyecto.get());
        return prioridadProyecto.get();
    }
}
