package com.gym.co.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.gym.co.models.Ejercicio;

import com.gym.co.models.Rutina;
import com.gym.co.repository.EjercicioRepository;

import com.gym.co.repository.RutinaRepository;
import com.gym.co.service.EjercicioService;

@Service
public class EjercicioServiceImpl implements EjercicioService {

    private final EjercicioRepository ejercicioRepository;
    private final RutinaRepository rutinaRepository;

    public EjercicioServiceImpl(EjercicioRepository ejercicioRepository, RutinaRepository rutinaRepository) {
        this.ejercicioRepository = ejercicioRepository;
        this.rutinaRepository = rutinaRepository;
    }

    @Override
    public Ejercicio addEjercicio(Long rutinaId, Ejercicio ejercicio) {
        Rutina rutina = rutinaRepository.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        ejercicio.setRutina(rutina);
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public Ejercicio updateEjercicio(Long ejercicioId, Ejercicio ejercicio) {
        Ejercicio existingEjercicio = ejercicioRepository.findById(ejercicioId)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));

        existingEjercicio.setNombre(ejercicio.getNombre());
        // ...otros campos que deseas actualizar...

        return ejercicioRepository.save(existingEjercicio);
    }

    @Override
    public boolean deleteEjercicio(Long ejercicioId) {
        ejercicioRepository.deleteById(ejercicioId);
        return true;
    }

    @Override
    public List<Ejercicio> getEjerciciosByIds(List<Long> ejercicioIds) {
        return ejercicioRepository.findAllById(ejercicioIds);
    }

    // Resto de tu código
}


