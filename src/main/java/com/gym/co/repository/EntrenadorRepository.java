package com.gym.co.repository;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gym.co.models.Entrenador;
import com.gym.co.models.Evaluacion;
import com.gym.co.models.Usuario;
@EnableJpaRepositories
@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador , Long> {    

	Entrenador findByEmail(String email);
    Optional<Entrenador> findById(Long id);
    List<Entrenador> findAllByEntrenadorId(Long entrenadorId);
    Optional<Entrenador> findOneByEmailAndPassword(String email, String password);
}
