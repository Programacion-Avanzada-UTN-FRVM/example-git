package com.example.project.management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/demo")
@RestController
public class DemoController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}