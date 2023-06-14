package com.gym.co.controllers;
import com.gym.co.dto.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.co.dto.UsuarioDTO;
import com.gym.co.models.Rutina;
import com.gym.co.models.Usuario;
import com.gym.co.repository.RutinaRepositorio;
import com.gym.co.repository.UsuarioRepositorio;
import com.gym.co.service.UserService;
import com.gym.co.service.UsuarioService;

import jakarta.validation.Valid;
import com.gym.co.util.*;
@RestController
@CrossOrigin
@RequestMapping("/api/usuario")
public class ApiControlador {

    @Autowired
    private  UserService usuarioService;
    
    @Autowired
    private  UsuarioService usuarioService1;
    
    private  RutinaRepositorio rutinaRepositorio;
    
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
    
    public ApiControlador(UserService usuarioService, RutinaRepositorio rutinaRepositorio) {
        this.usuarioService = usuarioService;
        this.rutinaRepositorio = rutinaRepositorio;
    }
    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    

    

    @GetMapping("/workouts")
    public List<Rutina> getAllWorkouts() {
        return rutinaRepositorio.findAll();
    }

    @PostMapping("/workouts")
    public Rutina createWorkout(@Valid @RequestBody Rutina rutina) {
        return rutinaRepositorio.save(rutina);
    }
}
