package com.gym.co.service.impl;

import java.lang.reflect.Type;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;


import com.gym.co.dto.LoginDTO;


import com.gym.co.models.Entrenador;
import com.gym.co.models.Rutina;


import com.gym.co.repository.EntrenadorRepository;
import com.gym.co.repository.RutinaRepository;
import com.gym.co.repository.UsuarioRepository;
import com.gym.co.service.EjercicioService;
import com.gym.co.service.EntrenadorService;
import com.gym.co.util.LoginMesage;


@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private EjercicioService ejercicioService;

    private ModelMapper modelMapper;

    @Override
    public Rutina createRutina(Long entrenadorId, Rutina rutina) {
        Entrenador entrenador = entrenadorRepository.findById(entrenadorId)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        rutina.setEntrenador(entrenador);
        return rutinaRepository.save(rutina);
    }

    @Override
    public Entrenador getEntrenadorById(Long entrenadorId) {
        return entrenadorRepository.findById(entrenadorId).orElse(null);
    }

    @Override
    public LoginMesage loginEntrenador(LoginDTO loginDTO) {
        String msg = "";
        Entrenador entrenador = entrenadorRepository.findByEmail(loginDTO.getEmail());
        if (entrenador != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = entrenador.getPassword();
            if (password.equals(encodedPassword)) {
                return new LoginMesage("Login Success", true);
            } else {
                return new LoginMesage("Login Failed", false);
            }
        } else {
            return new LoginMesage("Email not exists", false);
        }
    }

    @Override
    public List<Rutina> getAllRutinas() {
        List<Rutina> rutinas = rutinaRepository.findAll();
        Type listType = new TypeToken<List<Rutina>>() {}.getType();
        List<Rutina> dtoList = modelMapper.map(rutinas, listType);
        return dtoList;
    }

    @Override
    public String addEntrenador(Entrenador entrenadorDTO) {
        Entrenador entrenador = new Entrenador(
            null,
            entrenadorDTO.getUsername(),
            entrenadorDTO.getEmail(),
            entrenadorDTO.getPassword(),
            null
        );

        entrenador = entrenadorRepository.save(entrenador);

        return entrenador.getUsername();
    }



    @Override
    public Rutina updateRutina(Long rutinaId, Rutina rutina) {
        Rutina existingRutina = rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        existingRutina.setNombre(rutina.getNombre());
        // ...otros campos que deseas actualizar...

        return rutinaRepository.save(existingRutina);
    }

    @Override
    public boolean deleteRutina(Long rutinaId) {
        rutinaRepository.deleteById(rutinaId);
        return true;
    }

    @Override
    public Rutina getRutinaById(Long rutinaId) {
        return rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
    }
    
}

	
   
	





