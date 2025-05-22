package com.ok200.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ok200.demo.exceptions.EmailAlreadyExistsException;
import com.ok200.demo.model.Technologies;
import com.ok200.demo.model.User;
import com.ok200.demo.repository.TechnologiesRepository;
import com.ok200.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TechnologiesRepository technologiesRepository;


    public UserService(UserRepository userRepository, TechnologiesRepository technologiesRepository) {
    this.userRepository = userRepository;
    this.technologiesRepository = technologiesRepository;
    }

    public ResponseEntity<Object> createUser(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailAlreadyExistsException("[ERROR]: Ya existe un usuario registrado con ese correo. Intente con otro.");
        }

        Set<Technologies> finalTechs = new HashSet<>();
        for (Technologies tech : user.getTechnologies()) {
            Technologies found = technologiesRepository.findById(tech.getId())
            .orElseThrow(() -> new RuntimeException("Technology not found: " + tech.getId()));
            finalTechs.add(found);
        }

        user.setTechnologies(finalTechs);
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public List<User> getMatchesByUserId(Integer userId) {
    return userRepository.findUsersWithSharedTechnologies(userId);
}

}
