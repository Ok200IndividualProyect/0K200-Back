package com.ok200.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ok200.demo.exceptions.EmailAlreadyExistsException;
import com.ok200.demo.model.User;
import com.ok200.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    }

    public ResponseEntity<Object> createUser(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailAlreadyExistsException("[ERROR]: Ya existe un usuario cadastrado con ese correo. Intente con otro.");
        }
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
}
