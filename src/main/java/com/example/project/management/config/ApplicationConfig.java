package com.example.project.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua_parser.Parser;

@Configuration
public class ApplicationConfig {

    @Bean
    public Parser getParser() {
        return new Parser();
    }

}