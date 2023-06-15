package com.gym.co.repository;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Entrenador;
import com.gym.co.models.Evaluacion;
import com.gym.co.models.Usuario;

@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {    

    Entrenador findByEmail(String email);
    List<Entrenador> findAllByEntrenadorId(Long entrenadorId);
    Entrenador save(User entrenador);

    Optional<Entrenador> findOneByEmailAndPassword(String email, String password);
}
