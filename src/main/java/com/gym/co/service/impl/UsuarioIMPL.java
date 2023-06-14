package com.gym.co.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.co.dto.LoginDTO;
import com.gym.co.dto.UsuarioDTO;
import com.gym.co.models.Usuario;
import com.gym.co.repository.UsuarioRepositorio;
import com.gym.co.service.UsuarioService;
import com.gym.co.util.LoginMesage;

import java.util.Optional;
 
@Service
 
public class UsuarioIMPL implements UsuarioService {
 
    @Autowired
    private UsuarioRepositorio employeeRepo;
 

 
    @Override
    public String addUsuario(UsuarioDTO employeeDTO) {
 
        Usuario employee = new Usuario(
 
                employeeDTO.getId(),
                employeeDTO.getUsername(),
                employeeDTO.getEmail(),
 
           employeeDTO.getPassword()
        );
 
        employeeRepo.save(employee);
 
        return employee.getUsername();
    }
    UsuarioDTO employeeDTO;
 
 

	@Override
	public LoginMesage loginUsuario(LoginDTO loginDTO) {
		String msg = "";
        Usuario employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
           
            if (1<2) {
                Optional<Usuario> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
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

	
 
}