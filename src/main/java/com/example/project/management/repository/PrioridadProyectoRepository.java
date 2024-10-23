package com.example.project.management.repository;

import com.example.project.management.model.PrioridadProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrioridadProyectoRepository extends JpaRepository<PrioridadProyecto,Integer> {

    Optional<PrioridadProyecto> findByNombre(String nombre);

    Optional<PrioridadProyecto> findByNombreAndFechaEliminacionIsNull(String nombre);

    Optional<PrioridadProyecto> findByNombreAndFechaEliminacionIsNotNull(String nombre);

    Optional<PrioridadProyecto> findById(Long id);

    Optional<PrioridadProyecto> findByIdAndFechaEliminacionIsNull(Long id);

    Optional<PrioridadProyecto> findByIdAndFechaEliminacionIsNotNull(Long id);

    List<PrioridadProyecto> findAllByFechaEliminacionIsNull();

    List<PrioridadProyecto> findAllByFechaEliminacionIsNotNull();

    boolean existsByNombre(String nombre);

    boolean existsByNombreAndFechaEliminacionIsNull(String nombre);

    boolean existsByNombreAndFechaEliminacionIsNotNull(String nombre);

}
