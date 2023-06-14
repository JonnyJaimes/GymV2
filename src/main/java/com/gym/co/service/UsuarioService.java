package com.gym.co.service;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.util.LoginMesage;

public interface UsuarioService {
    String addUsuario(UsuarioDTO usuarioDTO);
 
    LoginMesage loginUsuario(LoginDTO loginDTO);
 
}