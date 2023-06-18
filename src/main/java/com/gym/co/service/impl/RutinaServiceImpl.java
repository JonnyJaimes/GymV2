package com.gym.co.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.gym.co.models.Rutina;
import com.gym.co.models.Usuario;

import com.gym.co.repository.RutinaRepository;
import com.gym.co.repository.UsuarioRepository;
import com.gym.co.service.RutinaService;

@Service
public class RutinaServiceImpl implements RutinaService {

    private final RutinaRepository rutinaRepository;
    private final UsuarioRepository usuarioRepository;

    public RutinaServiceImpl(RutinaRepository rutinaRepository, UsuarioRepository usuarioRepository) {
        this.rutinaRepository = rutinaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Rutina createRutina(Rutina rutina) {
        return rutinaRepository.save(rutina);
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
    public List<Rutina> getAllRutinas() {
        return rutinaRepository.findAll();
    }

    @Override
    public Rutina getRutinaById(Long rutinaId) {
        return rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
    }

    @Override
    public Rutina assignRutinaToUsuario(Long rutinaId, Long usuarioId) {
        Rutina rutina = rutinaRepository.findById(rutinaId)
                .orElse(null);

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElse(null);

        if (rutina == null || usuario == null) {
            return null;
        }

        rutina.addUsuario(usuario);
        rutinaRepository.save(rutina);

        return rutina;
    }

    // Resto de tu código
}


	


