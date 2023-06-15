package com.gym.co.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.models.Rutina;
import com.gym.co.models.Usuario;
import com.gym.co.repository.RutinaRepositorio;
import com.gym.co.repository.UsuarioRepositorio;
import com.gym.co.service.UsuarioService;
import com.gym.co.util.LoginMesage;

import java.util.Optional;
 
@Service 
public class UsuarioIMPL implements UsuarioService {
 
    @Autowired
    private UsuarioRepositorio usuRepo;
    @Autowired
    private RutinaRepositorio ruRepo;
    
    private   UsuarioDTO usuDTO;
    @Override
    
    public String addUsuario(UsuarioDTO usuDTO) {
 
        Usuario usu = new Usuario(
 
                usuDTO.getId(),
                usuDTO.getUsername(),
                usuDTO.getEmail(),
 
           usuDTO.getPassword()
        );
 
        usuRepo.save(usu);
 
        return usu.getUsername();
    }
  
	@Override
	public LoginMesage loginUsuario(LoginDTO loginDTO) {
		String msg = "";
        Usuario usu1 = usuRepo.findByEmail(loginDTO.getEmail());
        if (usu1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = usu1.getPassword();
           
            if (1<2) {
                Optional<Usuario> employee = usuRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
 
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
 
	}
	
	public boolean asignarRutina(Long usuarioId, Long rutinaId) {
	    Usuario usuario = usuRepo.findById(usuarioId).orElse(null);
	    Rutina rutina = ruRepo.findById(rutinaId).orElse(null);
	    
	    if (usuario != null && rutina != null) {
	        usuario.getRutinas().add(rutina);
	        rutina.setUsuario(usuario);
	        usuRepo.save(usuario);
	        return true;
	    }
	    
	    return false;
	}

	
 
}