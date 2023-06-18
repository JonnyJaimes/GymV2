package com.gym.co.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gym.co.models.Evaluacion;
import com.gym.co.models.Usuario;
import com.gym.co.repository.EvaluacionRepository;
import com.gym.co.repository.UsuarioRepository;



@Service
public class EvaluacionService {
    private final EvaluacionRepository evaluacionRepository;
    
    private final UsuarioRepository usuarioRepository; 

    public EvaluacionService(EvaluacionRepository evaluacionRepository, UsuarioRepository usuarioRepository) {
        this.evaluacionRepository = evaluacionRepository;
        this.usuarioRepository=usuarioRepository;
    }

    public Evaluacion addEvaluacion(Long usuarioId, Evaluacion evaluacion) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        evaluacion.setUsuario(usuario);
        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion getEvaluacionById(Long id) {
        return evaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada"));
    }

    public void deleteEvaluacion(Long id) {
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada"));

        evaluacionRepository.delete(evaluacion);
    }
   
    public List<Evaluacion> getAllEvaluaciones() {
        return evaluacionRepository.findAll();
    }
    


}


    // Otros métodos del servicio Evaluacion

