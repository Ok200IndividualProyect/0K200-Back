package com.ok200.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ok200.demo.model.Technologies;


@Repository
public interface TechnologiesRepository extends JpaRepository <Technologies, Integer>{
 Optional<Technologies> findByName(String name);
}
