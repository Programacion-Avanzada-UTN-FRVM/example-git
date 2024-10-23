package com.example.project.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {

    @Id
    private final UUID id = UUID.randomUUID();
    private final LocalDateTime issuedAt = LocalDateTime.now();
    private String httpMethod;
    private String requestURI;
    private String browser;
    private String OS;
    private String device;

}
