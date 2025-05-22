package com.ok200.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ok200.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    @Query("SELECT DISTINCT u FROM User u JOIN u.technologies t WHERE t IN (SELECT t2 FROM User u2 JOIN u2.technologies t2 WHERE u2.id = :userId) AND u.id <> :userId")
List<User> findUsersWithSharedTechnologies(@Param("userId") Integer userId);

}
