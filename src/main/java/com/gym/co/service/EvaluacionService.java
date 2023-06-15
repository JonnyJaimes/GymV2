package com.gym.co.service;

import java.util.List;

import com.gym.co.dto.EvaluacionDTO;

public interface EvaluacionService {
    String addEvaluacion(EvaluacionDTO evaluacionDTO);
    List<EvaluacionDTO> getAllEvaluacionesByUsuarioId(Long usuarioId);
}
