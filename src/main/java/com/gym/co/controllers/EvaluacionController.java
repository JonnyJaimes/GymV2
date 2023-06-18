package com.gym.co.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.dto.EvaluacionDTO;
import com.gym.co.models.Evaluacion;
import com.gym.co.service.EvaluacionService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/usuario/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        Evaluacion evaluacionGuardada = evaluacionService.addEvaluacion(null, evaluacion);
        return new ResponseEntity<>(evaluacionGuardada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        List<Evaluacion> evaluaciones = evaluacionService.getAllEvaluaciones();
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtenerEvaluacionPorId(@PathVariable Long id) {
        Evaluacion evaluacion = evaluacionService.getEvaluacionById(id);
        return new ResponseEntity<>(evaluacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        evaluacionService.deleteEvaluacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
