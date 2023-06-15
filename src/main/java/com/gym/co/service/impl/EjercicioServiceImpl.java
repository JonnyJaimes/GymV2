package com.gym.co.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.dto.EjercicioDTO;
import com.gym.co.models.Ejercicio;
import com.gym.co.repository.EjercicioRepositorio;
import com.gym.co.service.EjercicioService;

@Service
public class EjercicioServiceImpl implements EjercicioService {

    @Autowired
    private EjercicioRepositorio ejercicioRepositorio;

    // ... Otros métodos ...

    @Override
    public List<Ejercicio> getEjerciciosByIds1(List<Long> ejercicioIds) {
        return ejercicioRepositorio.findByIdIn(ejercicioIds);
    }

	@Override
	public Ejercicio addEjercicio(Long entrenadorId, Long rutinaId, EjercicioDTO ejercicioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ejercicio updateEjercicio(Long entrenadorId, Long rutinaId, Long ejercicioId, EjercicioDTO ejercicioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEjercicio(Long entrenadorId, Long rutinaId, Long ejercicioId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ejercicio> getEjerciciosByIds(List<Long> ejercicioIds) {
		// TODO Auto-generated method stub
		return null;
	}
}
