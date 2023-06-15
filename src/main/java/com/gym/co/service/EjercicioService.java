package com.gym.co.service;

import java.util.List;



import com.gym.co.dto.EjercicioDTO;
import com.gym.co.models.Ejercicio;

public interface EjercicioService {
    Ejercicio addEjercicio(Long entrenadorId, Long rutinaId, EjercicioDTO ejercicioDTO);
    Ejercicio updateEjercicio(Long entrenadorId, Long rutinaId, Long ejercicioId, EjercicioDTO ejercicioDTO);
    boolean deleteEjercicio(Long entrenadorId, Long rutinaId, Long ejercicioId);

	List<Ejercicio> getEjerciciosByIds1(List<Long> ejercicioIds);
	List<Ejercicio> getEjerciciosByIds(List<Long> ejercicioIds);
}
