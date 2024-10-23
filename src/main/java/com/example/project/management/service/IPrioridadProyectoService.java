package com.example.project.management.service;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.model.PrioridadProyecto;

import java.util.List;

public interface IPrioridadProyectoService {

    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNull();

    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNotNull();

    public PrioridadProyecto findById(Long id);

    public PrioridadProyecto findByIdAndFechaEliminacionIsNull(Long id);

    public PrioridadProyecto findByIdAndFechaEliminacionIsNotNull(Long id);

    public PrioridadProyecto findByNombre(String nombre);

    public PrioridadProyecto findByNombreAndFechaEliminacionIsNull(String nombre);

    public PrioridadProyecto findByNombreAndFechaEliminacionIsNotNull(String nombre);

    public PrioridadProyecto crear(PrioridadProyectoDTO prioridadProyectoDTO);

    public void deleteById(Long id);

    public void deleteByNombre(String nombre);

    public void recuperarPorId(Long id);

    public void recuperarPorNombre(String nombre);

    public PrioridadProyecto update(PrioridadProyectoDTO prioridadProyectoDTO);

}
