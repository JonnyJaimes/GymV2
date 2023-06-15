package com.gym.co.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Evaluacion;

@Repository
public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, Long> {
    
    
    List<Evaluacion> findAllByUsuarioId(Long usuarioId);
}
