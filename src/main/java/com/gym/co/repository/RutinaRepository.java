package com.gym.co.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gym.co.models.*;
@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {
	
	Optional<Rutina> findByIdAndEntrenador_EntrenadorId(Long id, Long entrenadorId);
    @Query("SELECT r FROM Rutina r WHERE r.id = :rutinaId AND r.entrenador.id = :entrenadorId")
    Optional<Rutina> findByIdAndEntrenadorId(@Param("rutinaId") Long rutinaId, @Param("entrenadorId") Long entrenadorId);
}
