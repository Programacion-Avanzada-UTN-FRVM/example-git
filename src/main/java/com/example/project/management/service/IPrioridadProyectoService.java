package com.example.project.management.service;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.model.PrioridadProyecto;

import java.util.List;

public interface IPrioridadProyectoService {

    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNull();

    public List<PrioridadProyectoDTO> findAllByFechaEliminacionIsNotNull();

    public PrioridadProyecto findById(Integer id);

    public PrioridadProyecto findByIdAndFechaEliminacionIsNull(Integer id);

    public PrioridadProyecto findByIdAndFechaEliminacionIsNotNull(Integer id);

    public PrioridadProyecto findByPrioridad(String prioridad);

    public PrioridadProyecto findByPrioridadAndFechaEliminacionIsNull(String prioridad);

    public PrioridadProyecto findByPrioridadAndFechaEliminacionIsNotNull(String prioridad);

    public void save(PrioridadProyecto prioridadProyecto);

    public void deleteById(Integer id);

    public void deleteByPrioridad(String prioridad);

    public void recuperarPorId(Integer id);

    public void recuperarPorPrioridad(String prioridad);
}
