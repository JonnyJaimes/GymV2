package com.gym.co.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.dto.EvaluacionDTO;
import com.gym.co.models.Evaluacion;
import com.gym.co.models.Usuario;
import com.gym.co.repository.EvaluacionRepositorio;
import com.gym.co.repository.UsuarioRepositorio;
import com.gym.co.service.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {
 
    @Autowired
    private EvaluacionRepositorio evaluacionRepo;
    
    @Autowired
    private UsuarioRepositorio usuarioRepo;
    
    @Override
    public String addEvaluacion(EvaluacionDTO evaluacionDTO) {
 
        Optional<Usuario> usuario = usuarioRepo.findById(evaluacionDTO.getUsuarioId());
        if(usuario.isPresent()) {
            Evaluacion evaluacion = new Evaluacion(
                    evaluacionDTO.getId(),
                    evaluacionDTO.getFecha(),
                    evaluacionDTO.getPeso(),
                    evaluacionDTO.getAltura(),
                    evaluacionDTO.getGrasaCorporal(),
                    evaluacionDTO.getMasaMuscular(),
                    usuario.get()
            );

            evaluacionRepo.save(evaluacion);

            return "Evaluación guardada con éxito";
        } else {
            return "El usuario no existe";
        }
    }
    
    @Override
    public List<EvaluacionDTO> getAllEvaluacionesByUsuarioId(Long usuarioId) {
        List<Evaluacion> evaluaciones = evaluacionRepo.findAllByUsuarioId(usuarioId);
        // Aquí necesitarás convertir la lista de evaluaciones a una lista de EvaluacionDTO y devolverla.
		return null;
    }
}
