package com.example.project.management.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
/*
* NotFoundException se usa para manejar errores de recursos no encontrados.
* Por ejemplo: Cuando el recurso solicitado no existe.
* */
