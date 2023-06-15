package com.gym.co.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Ejercicio;
@Repository
public interface EjercicioRepositorio extends JpaRepository<Ejercicio, Long> {
    List<Ejercicio> findByIdIn(List<Long> ids);
}
