package com.gym.co.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RutinaDTO {
    private Long id;
    private String nombre;
    private Long usuarioId;
    private Long entrenadorId;
    private String descripcion;
    private Integer tiempo;
    private Integer series;
    private Integer repeticiones;
    private String tipoRutina;
    private String videoUrl;
    private String categoria;
    private List<Long> ejerciciosId;
}
