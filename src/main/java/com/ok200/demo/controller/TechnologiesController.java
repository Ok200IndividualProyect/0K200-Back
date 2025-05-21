package com.ok200.demo.controller;

import com.ok200.demo.model.Technologies;
import com.ok200.demo.repository.TechnologiesRepository;
import com.ok200.demo.service.TechnologiesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologiesController {

    private final TechnologiesService technologiesService;


    public TechnologiesController(TechnologiesRepository technologiesRepository, TechnologiesService technologiesService) {
    this.technologiesService = technologiesService;
    }

    @PostMapping
    public ResponseEntity<Object> createTechnology(@Valid @RequestBody Technologies tech) {
        return technologiesService.createTechnology(tech);
    }
}


