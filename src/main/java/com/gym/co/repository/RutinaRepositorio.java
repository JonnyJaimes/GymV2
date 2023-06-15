package com.gym.co.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Rutina;
@EnableJpaRepositories
 @Repository
public interface RutinaRepositorio extends JpaRepository<Rutina, Long> {
	
	
	    List<Rutina> findByEntrenadorId(Long entrenadorId);
	
	    Optional<Rutina> findByIdAndEntrenadorId(Long id, Long entrenadorId);

	

}


