package com.example.project.management.controller;

import com.example.project.management.DTO.PrioridadProyectoDTO;
import com.example.project.management.exception.BadRequestException;
import com.example.project.management.exception.ResponseService;
import com.example.project.management.mapper.PrioridadProyectoMapper;
import com.example.project.management.model.PrioridadProyecto;
import com.example.project.management.service.PrioridadProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioridad-proyecto")
@CrossOrigin (origins = "*")
public class PrioridadProyectoController {
    @Autowired
    private PrioridadProyectoService modelService;

    @Autowired
    private ResponseService responseService;

    @GetMapping({"/"})
    public ResponseEntity<?> getAll() {
        List<PrioridadProyectoDTO> prioridades = modelService.findAllByFechaEliminacionIsNull();
        if (prioridades.isEmpty()) {
            throw new BadRequestException("No hay roles creados");
        }
        return responseService.successResponse(prioridades, "OK");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getPorId(@PathVariable Long id){
        PrioridadProyecto model = modelService.findByIdAndFechaEliminacionIsNull(id);
        PrioridadProyectoDTO modelDTO = PrioridadProyectoMapper.toDTO(model);
        return responseService.successResponse(modelDTO, "OK");
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getPorNombre(@PathVariable String nombre){
        PrioridadProyecto model = modelService.findByNombreAndFechaEliminacionIsNull(nombre);
        PrioridadProyectoDTO modelDTO = PrioridadProyectoMapper.toDTO(model);
        return responseService.successResponse(modelDTO, "OK");
    }


    @PostMapping({"/"})
    public ResponseEntity<?> crear(@RequestBody PrioridadProyectoDTO prioridadProyectoDTO) {
        return responseService.successResponse(modelService.crear(prioridadProyectoDTO), "Prioridad creada");
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        modelService.deleteById(id);
        return responseService.successResponse(null, "Prioridad eliminada");
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<?> deleteByNombre(@PathVariable String nombre) {
        modelService.deleteByNombre(nombre);
        return responseService.successResponse(null, "Prioridad eliminada");
    }

    @PostMapping("/recuperar/id/{id}")
    public ResponseEntity<?> recuperarPorId(@PathVariable Long id) {
        modelService.recuperarPorId(id);
        return responseService.successResponse(null, "Prioridad recuperada");
    }

    @PostMapping("/recuperar/nombre/{nombre}")
    public ResponseEntity<?> recuperarPorNombre(@PathVariable String nombre) {
        modelService.recuperarPorNombre(nombre);
        return responseService.successResponse(null, "Prioridad recuperada");
    }

    @PutMapping ("/")
    public ResponseEntity<?> update( @RequestBody PrioridadProyectoDTO prioridadProyectoDTO) {
        return responseService.successResponse(modelService.update(prioridadProyectoDTO), "Prioridad actualizada");
    }

}
