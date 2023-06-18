package com.gym.co.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.models.Rutina;

import com.gym.co.service.RutinaService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    private final RutinaService rutinaService1;

    public RutinaController(RutinaService rutinaService) {
        this.rutinaService1 = rutinaService;
    }

    @PostMapping("/{entrenadorId}")
    public ResponseEntity<Rutina> createRutina( @RequestBody Rutina rutinaA) {
        Rutina rutina = rutinaService1.createRutina(rutinaA);
        return new ResponseEntity<>(rutina, HttpStatus.CREATED);
    }

    @PutMapping("/{rutinaId}")
    public ResponseEntity<Rutina> updateRutina(@PathVariable Long rutinaId, @RequestBody Rutina rutinaA) {
        Rutina rutina = rutinaService1.updateRutina(rutinaId, rutinaA);
        return new ResponseEntity<>(rutina, HttpStatus.OK);
    }

    @DeleteMapping("/{rutinaId}")
    public ResponseEntity<Void> deleteRutina(@PathVariable Long rutinaId) {
        rutinaService1.deleteRutina(rutinaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Rutina>> getAllRutinas() {
        List<Rutina> rutinas = rutinaService1.getAllRutinas();
        return new ResponseEntity<>(rutinas, HttpStatus.OK);
    }

    @GetMapping("/{rutinaId}")
    public ResponseEntity<Rutina> getRutinaById(@PathVariable Long rutinaId) {
        Rutina rutina = rutinaService1.getRutinaById(rutinaId);
        return new ResponseEntity<>(rutina, HttpStatus.OK);
    }

    @PostMapping("/{rutinaId}/usuarios/{usuarioId}")
    public ResponseEntity<Rutina> assignRutinaToUsuario(@PathVariable Long rutinaId, @PathVariable Long usuarioId) {
        Rutina rutina = rutinaService1.assignRutinaToUsuario(rutinaId, usuarioId);
        return new ResponseEntity<>(rutina, HttpStatus.OK);
    }
}
