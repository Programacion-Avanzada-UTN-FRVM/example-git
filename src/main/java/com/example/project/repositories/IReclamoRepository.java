package com.example.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.project.models.Reclamo;

public interface IReclamoRepository extends CrudRepository<Reclamo , Long>{
    
}
