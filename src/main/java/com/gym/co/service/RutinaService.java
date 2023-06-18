package com.gym.co.service;

import java.util.List;


import com.gym.co.models.Rutina;



public interface RutinaService {
    Rutina createRutina(Rutina rutina);
    Rutina updateRutina(Long rutinaId, Rutina rutina);
    boolean deleteRutina(Long rutinaId);
    List<Rutina> getAllRutinas();
    Rutina getRutinaById(Long rutinaId);
    Rutina assignRutinaToUsuario(Long rutinaId, Long usuarioId);
}