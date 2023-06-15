package com.gym.co.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.models.Rutina;
import com.gym.co.models.Usuario;
import com.gym.co.repository.RutinaRepositorio;
import com.gym.co.service.UsuarioService;
import com.gym.co.util.LoginMesage;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

@RequestMapping("/api/usuario")
public class ApiControlador {

    
	
    @Autowired
    private  UsuarioService usuarioService1;
    @Autowired
    private  RutinaRepositorio rutinaRepositorio;
    @Autowired
    public ApiControlador(UsuarioService usuarioService, RutinaRepositorio rutinaRepositorio) {
        this.usuarioService1 = usuarioService;
        this.rutinaRepositorio = rutinaRepositorio;
    }
    
    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    
    @PostMapping(path ="/save")
    public String saveUsuario(@RequestBody UsuarioDTO usDTO){
        
    	String id= usuarioService1.addUsuario(usDTO);
    	
    	return id;
  
    }
    @PostMapping(path ="/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO usDTO){
		
    	LoginMesage i= usuarioService1.loginUsuario(usDTO);
    	
    	return ResponseEntity.ok(i);
  
    }
    
   
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUsuario(HttpServletRequest request) {
        // Realiza las acciones necesarias para el logout del usuario
        
        // Ejemplo: Invalidar la sesión actual
        request.getSession().invalidate();

        return new ResponseEntity<>("Usuario deslogueado", HttpStatus.OK);
    }
    
    @PostMapping("/{usuarioId}/rutinas/{rutinaId}/tomar")
    public ResponseEntity<String> tomarRutina(@PathVariable Long usuarioId, @PathVariable Long rutinaId) {
        boolean exito = usuarioService1.asignarRutina(usuarioId, rutinaId);
        if (exito) {
            return new ResponseEntity<>("Rutina tomada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al tomar la rutina", HttpStatus.BAD_REQUEST);
        }
    }
    
 
}
