package com.gym.co.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EjercicioDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer repeticiones;
    private Long rutinaId;
}
