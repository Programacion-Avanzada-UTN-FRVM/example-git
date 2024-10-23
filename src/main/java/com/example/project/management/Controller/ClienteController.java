package com.example.project.management.Controller;
import com.example.project.management.Model.Cliente;
import com.example.project.management.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    // Obtener un cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(Integer id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

//    // Actualizar un cliente
//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> update(Integer id, Cliente cliente) {
//        return ResponseEntity.ok(clienteService.update(id, cliente));
//    }
//
//    // Eliminar un cliente
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(Integer id) {
//        clienteService.delete(id);
//        return ResponseEntity.ok().build();
//    }
}
