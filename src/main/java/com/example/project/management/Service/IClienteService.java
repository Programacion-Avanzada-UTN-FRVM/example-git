package com.example.project.management.Service;

import java.util.List;

import com.example.project.management.Model.Cliente;

public interface IClienteService {
    
    public List<Cliente> getAll();

    public Cliente getById(Integer id);

    public Cliente save(Cliente cliente);

}
