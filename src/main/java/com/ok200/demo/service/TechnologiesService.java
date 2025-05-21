package com.ok200.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import com.ok200.demo.exceptions.TechnologyAlreadyExistsException;
import com.ok200.demo.model.Technologies;
import com.ok200.demo.repository.TechnologiesRepository;

@Service
public class TechnologiesService {
    private final TechnologiesRepository technologiesRepository;

    public TechnologiesService(TechnologiesRepository technologiesRepository) {
        this.technologiesRepository = technologiesRepository;
    }

    public ResponseEntity<Object> createTechnology(Technologies tech) {
        //         if(technologiesRepository.findByName(tech.getName()) != null){
        //     throw new  TechnologyAlreadyExistsException("[ERROR]: Ya existe una technology registrado con ese nombre. Intente con otro.");
        // }
        return new ResponseEntity<>(technologiesRepository.save(tech), HttpStatus.CREATED);
    }
}
