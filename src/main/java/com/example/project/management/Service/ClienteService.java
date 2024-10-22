package com.example.project.management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.management.Model.Cliente;
import com.example.project.management.Repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


}
