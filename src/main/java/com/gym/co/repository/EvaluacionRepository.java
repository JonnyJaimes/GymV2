package com.gym.co.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Evaluacion;
@EnableJpaRepositories
@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    
    List<Evaluacion> findAllByUsuarioId(Long usuarioId);
}
