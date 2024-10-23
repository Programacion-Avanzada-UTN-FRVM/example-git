package com.example.project.management.repository;

import com.example.project.management.model.PrioridadProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrioridadProyectoRepository extends JpaRepository<PrioridadProyecto,Integer> {

    Optional<PrioridadProyecto> findByPrioridad(String prioridad);

    Optional<PrioridadProyecto> findByPrioridadAndFechaEliminacionIsNull(String prioridad);

    Optional<PrioridadProyecto> findByPrioridadAndFechaEliminacionIsNotNull(String prioridad);

    Optional<PrioridadProyecto> findById(Integer id);

    Optional<PrioridadProyecto> findByIdAndFechaEliminacionIsNull(Integer id);

    Optional<PrioridadProyecto> findByIdAndFechaEliminacionIsNotNull(Integer id);

    List<PrioridadProyecto> findAllByFechaEliminacionIsNull();

    List<PrioridadProyecto> findAllByFechaEliminacionIsNotNull();

    boolean existsByPrioridad(String prioridad);

    boolean existsByPrioridadAndFechaEliminacionIsNull(String prioridad);

    boolean existsByPrioridadAndFechaEliminacionIsNotNull(String prioridad);

}
