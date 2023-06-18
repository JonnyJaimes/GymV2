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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.dto.EjercicioDTO;

import com.gym.co.dto.LoginDTO;

import com.gym.co.service.EjercicioService;
import com.gym.co.service.EntrenadorService;
import com.gym.co.service.RutinaService;
import com.gym.co.util.LoginMesage;

import jakarta.servlet.http.HttpServletRequest;
import com.gym.co.models.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;
    
    @Autowired
    private RutinaService rutinaService;
    
    @Autowired
    private EjercicioService ejercicioService;
   
   
    @PostMapping("/logout")
    public ResponseEntity<String> logoutEntrenador(HttpServletRequest request) {
        // Realiza las acciones necesarias para el logout del entrenador
        request.getSession().invalidate();
        return new ResponseEntity<>("Entrenador deslogueado", HttpStatus.OK);
    }
    
    @PostMapping(path ="/save")
    public String saveUsuario(@RequestBody Entrenador usDTO){
        
    	String id= entrenadorService.addEntrenador(usDTO);
    	
    	return id;
  
    }
    @PostMapping(path ="/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO usDTO){
		
    	LoginMesage i= entrenadorService.loginEntrenador(usDTO);
    	
    	
    	return ResponseEntity.ok(i);
  
    }
    @PostMapping("/logoutE")
    public ResponseEntity<String> logoutUsuario(HttpServletRequest request) {
        // Realiza las acciones necesarias para el logout del usuario
        
        // Ejemplo: Invalidar la sesión actual
        request.getSession().invalidate();

        return new ResponseEntity<>("Usuario deslogueado", HttpStatus.OK);
    }
    @PostMapping("/{entrenadorId}/rutinas")
    public ResponseEntity<Rutina> createRutina(@PathVariable Long entrenadorId, @RequestBody Rutina rutinaA){
        Rutina rutina = entrenadorService.createRutina(entrenadorId, rutinaA);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rutina, HttpStatus.CREATED);
    }
    
    @GetMapping("/rutinas")
    public ResponseEntity<List<Rutina>> getAllRutinas() {
        List<Rutina> rutinas = entrenadorService.getAllRutinas();
        return new ResponseEntity<>(rutinas, HttpStatus.OK);
    }
    
    @PutMapping("/rutinas/{rutinaId}")
    public ResponseEntity<Rutina> updateRutina(@PathVariable Long rutinaId, @RequestBody Rutina rutina) {
        Rutina updatedRutina = rutinaService.updateRutina(rutinaId, rutina);
        if (updatedRutina == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRutina, HttpStatus.OK);
    }
    
    @DeleteMapping("/rutinas/{rutinaId}")
    public ResponseEntity<String> deleteRutina(@PathVariable Long rutinaId) {
        boolean result = rutinaService.deleteRutina(rutinaId);
        if (!result) {
            return new ResponseEntity<>("No se pudo eliminar la rutina", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Rutina eliminada correctamente", HttpStatus.OK);
    }
    
    @GetMapping("/rutinas/{rutinaId}")
    public ResponseEntity<Rutina> getRutinaById(@PathVariable Long rutinaId) {
        Rutina rutina = rutinaService.getRutinaById(rutinaId);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rutina, HttpStatus.OK);
    }
    
    @PostMapping("/rutinas/{rutinaId}/usuarios/{usuarioId}")
    public ResponseEntity<Rutina> assignRutinaToUsuario(@PathVariable Long rutinaId, @PathVariable Long usuarioId) {
        Rutina rutina = rutinaService.assignRutinaToUsuario(rutinaId, usuarioId);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rutina, HttpStatus.CREATED);
    }

    @PostMapping("/rutinas/{rutinaId}/ejercicios")
    public ResponseEntity<Ejercicio> addEjercicioToRutina(@PathVariable Long rutinaId, @RequestBody Ejercicio ejercicioDTO) {
        Rutina rutina = rutinaService.getRutinaById(rutinaId);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre(ejercicioDTO.getNombre());
        ejercicio.setDescripcion(ejercicioDTO.getDescripcion());
        ejercicio.setRepeticiones(ejercicioDTO.getRepeticiones());
        ejercicio.setRutina(rutina);

        ejercicio = ejercicioService.addEjercicio(rutinaId, ejercicio);

        return new ResponseEntity<>(ejercicio, HttpStatus.CREATED);
    }
    
    // Resto de tu código
    
}

    



