package com.gym.co.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.dto.EntrenadorDTO;
import com.gym.co.dto.EvaluacionDTO;
import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.RutinaDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.models.Entrenador;
import com.gym.co.models.Rutina;
import com.gym.co.models.Usuario;
import com.gym.co.repository.EjercicioRepositorio;
import com.gym.co.repository.EntrenadorRepositorio;
import com.gym.co.repository.RutinaRepositorio;
import com.gym.co.repository.UsuarioRepositorio;
import com.gym.co.service.EjercicioService;
import com.gym.co.service.EntrenadorService;
import com.gym.co.util.LoginMesage;
import com.gym.co.models.*;

@Service
public class EntrenadorServiceImpl  implements EntrenadorService {

	 @Autowired
	    private EntrenadorRepositorio entreRep;
	    EntrenadorDTO usuEntDTO;
	    
	    @Autowired
	    private UsuarioRepositorio usuarioRepository;

	    @Autowired
	    private RutinaRepositorio rutinaRepository;
	    
	    @Autowired
	    private EjercicioService ejercicioService;
	    
	    @Override
	    public Entrenador getEntrenadorById(Long entrenadorId) {
	        return entreRep.findById(entrenadorId).orElse(null);
	    }




	@Override
	public LoginMesage loginEntrenador(LoginDTO loginDTO) {
		String msg = "";
        Entrenador usu1 = entreRep.findByEmail(loginDTO.getEmail());
        if (usu1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = usu1.getPassword();
           
            if (1<2) {
                Optional<Entrenador> employee = entreRep.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
 
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
	}
	@Override
    public String addEntrenador(EntrenadorDTO usuEntDTO) {
 
        Entrenador usu = new Entrenador(
 
                usuEntDTO.getId(),
                usuEntDTO.getUsername(),
                usuEntDTO.getEmail(),
 
           usuEntDTO.getPassword()
        );
 
        entreRep.save(usu);
 
        return usu.getUsername();
    }
	
	public Rutina createRutina(Long entrenadorId, RutinaDTO rutinaDTO) {
		Entrenador entrenador = getEntrenadorById(entrenadorId);
	    if (entrenador == null) {
	        return null;
	    }
	    Rutina rutina = new Rutina();
	    rutina.setNombre(rutinaDTO.getNombre());
	    rutina.setDescripcion(rutinaDTO.getDescripcion());
	    rutina.setTiempo(rutinaDTO.getTiempo());
	    rutina.setSeries(rutinaDTO.getSeries());
	    rutina.setRepeticiones(rutinaDTO.getRepeticiones());
	    rutina.setTipoRutina(rutinaDTO.getTipoRutina());
	    rutina.setVideoUrl(rutinaDTO.getVideoUrl());
	    rutina.setCategoria(rutinaDTO.getCategoria());
	    // Aquí puedes añadir la lógica para asociar los ejercicios a la rutina
	    List<Ejercicio> ejercicios = ejercicioService.getEjerciciosByIds(rutinaDTO.getEjerciciosId());
	    rutina.setEjercicios(ejercicios);
	    rutina.setEjercicios(ejercicios);
	    rutina.setEntrenador(entrenador);
	    return rutinaRepository.save(rutina);
    }

    public List<Rutina> getRutinas(Long entrenadorId) {
        return rutinaRepository.findByEntrenadorId(entrenadorId);
    }

    @Override
    public Rutina updateRutina(Long entrenadorId, Long rutinaId, RutinaDTO rutinaDTO) {
        Optional<Rutina> rutinaOpt = rutinaRepository.findByIdAndEntrenadorId(rutinaId, entrenadorId);
        if (!rutinaOpt.isPresent()) {
            return null;
        }
        Rutina rutina = rutinaOpt.get();
        rutina.setNombre(rutinaDTO.getNombre());
        rutina.setDescripcion(rutinaDTO.getDescripcion());
        rutina.setTiempo(rutinaDTO.getTiempo());
        rutina.setSeries(rutinaDTO.getSeries());
        rutina.setRepeticiones(rutinaDTO.getRepeticiones());
        rutina.setTipoRutina(rutinaDTO.getTipoRutina());
        rutina.setVideoUrl(rutinaDTO.getVideoUrl());
        rutina.setCategoria(rutinaDTO.getCategoria());
        // Aquí puedes añadir la lógica para actualizar los ejercicios de la rutina
        List<Ejercicio> ejercicios = ejercicioService.getEjerciciosByIds(rutinaDTO.getEjerciciosId());
        rutina.setEjercicios(ejercicios);
        return rutinaRepository.save(rutina);
    }

    public boolean deleteRutina(Long entrenadorId, Long rutinaId) {
        Optional<Rutina> rutina = rutinaRepository.findByIdAndEntrenadorId(rutinaId, entrenadorId);

        if (rutina.isPresent()) {
            rutinaRepository.delete(rutina.get());
            return true;
        }

        return false;
    }
   
	
}




