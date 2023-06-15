package com.gym.co.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.dto.EvaluacionDTO;
import com.gym.co.service.EvaluacionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionControlador {

    @Autowired
    private EvaluacionService evaluacionService;

    public EvaluacionControlador(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping(path = "/add") // http://localhost:8080/api/evaluacion/add
    public ResponseEntity<String> addEvaluacion(@RequestBody EvaluacionDTO evaluacionDTO) {
        String response = evaluacionService.addEvaluacion(evaluacionDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{usuarioId}") // http://localhost:8080/api/evaluacion/1
    public ResponseEntity<List<EvaluacionDTO>> getEvaluacionesByUsuarioId(@PathVariable Long usuarioId) {
        
        List<EvaluacionDTO> evaluaciones = evaluacionService.getAllEvaluacionesByUsuarioId(usuarioId);
        
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }
}
