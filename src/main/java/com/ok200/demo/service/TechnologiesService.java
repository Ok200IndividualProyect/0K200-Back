package com.ok200.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ok200.demo.model.Technologies;
import com.ok200.demo.repository.TechnologiesRepository;

@Service
public class TechnologiesService {
    private final TechnologiesRepository technologiesRepository;

    public TechnologiesService(TechnologiesRepository technologiesRepository) {
        this.technologiesRepository = technologiesRepository;
    }

    public ResponseEntity<Object> createTechnology(Technologies tech) {
        return new ResponseEntity<>(technologiesRepository.save(tech), HttpStatus.CREATED);
    }

        public ResponseEntity<Object> getTechnologyById(Integer id) {
        Optional<Technologies> technologiesOptional = technologiesRepository.findById(id);
        if (!technologiesOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Technologies tech = technologiesOptional.get();
        return ResponseEntity.ok(tech);

    }

    public List<Technologies> getAllTechnologies() {
        return this.technologiesRepository.findAll();
    }
}
