package com.gym.co.service;

import java.util.List;



import com.gym.co.dto.EjercicioDTO;
import com.gym.co.models.Ejercicio;

public interface EjercicioService {
	 Ejercicio addEjercicio(Long rutinaId, Ejercicio ejercicio);
	    Ejercicio updateEjercicio(Long ejercicioId, Ejercicio ejercicio);
	    boolean deleteEjercicio(Long ejercicioId);
	    List<Ejercicio> getEjerciciosByIds(List<Long> ejercicioIds);
}
