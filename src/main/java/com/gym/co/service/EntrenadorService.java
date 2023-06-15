package com.gym.co.service;

import java.util.List;

import com.gym.co.dto.EntrenadorDTO;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.RutinaDTO;
import com.gym.co.models.Entrenador;
import com.gym.co.models.Rutina;
import com.gym.co.util.LoginMesage;

public interface EntrenadorService {
    
	 String addEntrenador(EntrenadorDTO EntrenadorDTO);
	 
	LoginMesage loginEntrenador(LoginDTO loginDTO);

	Entrenador getEntrenadorById(Long entrenadorId);

	List<Rutina> getRutinas(Long entrenadorId);

	Rutina updateRutina(Long entrenadorId, Long rutinaId, RutinaDTO rutinaDTO);

	Rutina createRutina(Long entrenadorId, RutinaDTO rutinaDTO);
	   boolean deleteRutina (Long entrenadorId, Long rutinaId);
	   
	
}
