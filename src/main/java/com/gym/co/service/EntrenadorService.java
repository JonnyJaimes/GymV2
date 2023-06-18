package com.gym.co.service;

import java.util.List;

import com.gym.co.dto.EntrenadorDTO;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.RutinaDTO;
import com.gym.co.models.Entrenador;
import com.gym.co.models.Rutina;
import com.gym.co.util.LoginMesage;

public interface EntrenadorService {
    
	 String addEntrenador(Entrenador usDTO);
	    LoginMesage loginEntrenador(LoginDTO loginDTO);
	    Entrenador getEntrenadorById(Long entrenadorId);
	    Rutina createRutina(Long entrenadorId, Rutina rutina);
	    List<Rutina> getAllRutinas();
	    Rutina updateRutina(Long rutinaId, Rutina rutina);
	    boolean deleteRutina(Long rutinaId);
	    Rutina getRutinaById(Long rutinaId);
	
}
