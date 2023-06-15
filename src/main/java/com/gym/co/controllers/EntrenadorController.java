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
import com.gym.co.models.Entrenador;
import com.gym.co.dto.EntrenadorDTO;
import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.RutinaDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.service.EntrenadorService;
import com.gym.co.util.LoginMesage;

import jakarta.servlet.http.HttpServletRequest;
import com.gym.co.models.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

   
    @PostMapping("/logout")
    public ResponseEntity<String> logoutEntrenador(HttpServletRequest request) {
        // Realiza las acciones necesarias para el logout del entrenador
        request.getSession().invalidate();
        return new ResponseEntity<>("Entrenador deslogueado", HttpStatus.OK);
    }
    
    @PostMapping(path ="/save")
    public String saveUsuario(@RequestBody EntrenadorDTO usDTO){
        
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
    @PostMapping(path ="/{entrenadorId}/rutinas")
    public ResponseEntity<Rutina> createRutina(@PathVariable Long entrenadorId, @RequestBody RutinaDTO rutinaDTO){
        Rutina rutina = entrenadorService.createRutina(entrenadorId, rutinaDTO);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rutina, HttpStatus.CREATED);
    }

    @PutMapping("/{entrenadorId}/rutinas/{rutinaId}")
    public ResponseEntity<Rutina> updateRutina(@PathVariable Long entrenadorId, @PathVariable Long rutinaId, @RequestBody RutinaDTO rutinaDTO){
        Rutina rutina = entrenadorService.updateRutina(entrenadorId, rutinaId, rutinaDTO);
        if (rutina == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rutina, HttpStatus.OK);
    }

    @DeleteMapping("/{entrenadorId}/rutinas/{rutinaId}")
    public ResponseEntity<String> deleteRutina(@PathVariable Long entrenadorId, @PathVariable Long rutinaId){
        boolean deleted = entrenadorService.deleteRutina(entrenadorId, rutinaId);
        if (!deleted) {
            return new ResponseEntity<>("Failed to delete the routine", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Routine deleted successfully", HttpStatus.OK);
    }
 
}
    
    
    



