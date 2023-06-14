package com.gym.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.models.Rutina;
import com.gym.co.repository.RutinaRepositorio;

@Service
public class WorkoutService {

    @Autowired
    private RutinaRepositorio workoutRepository;

    public List<Rutina> getAllWorkouts() {
       return null;
    }

    // También puedes agregar aquí métodos para otras operaciones CRUD (crear, leer, actualizar, eliminar).
}

