package com.gym.co.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private long id;
    private String username;
    private String email;
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int employeeid, String employeename, String email, String password) {
        this.id = employeeid;
        this.username = employeename;
        this.email = email;
        this.password = password;
    }

} //create getters and