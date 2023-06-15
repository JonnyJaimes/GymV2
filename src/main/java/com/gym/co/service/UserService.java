package com.gym.co.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.models.Usuario;
import com.gym.co.repository.UsuarioRepositorio;

public class UserService {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    public Usuario registerUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public  Usuario loginUser(Usuario usuario) {
        Usuario existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(usuario.getPassword())) {
            return existingUser;
        } else {
            return null;
        }
    }
}