package com.gym.co.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.co.models.Rutina;

public interface RutinaRepositorio extends JpaRepository<Rutina, Long> {
	
	
	    List<Rutina> findByEntrenadorId(Long entrenadorId);
	    Optional<Rutina> findByIdAndEntrenadorId(Long id, Long entrenadorId);
	

}


