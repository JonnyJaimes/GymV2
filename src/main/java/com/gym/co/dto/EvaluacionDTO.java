package com.gym.co.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluacionDTO {
    private Long id;
    private Date fecha;
    private Double peso;
    private Double altura;
    private Double grasaCorporal;
    private Double masaMuscular;
    private Long usuarioId;

    public EvaluacionDTO() {
    }

    public EvaluacionDTO(Long id, Date fecha, Double peso, Double altura, Double grasaCorporal, Double masaMuscular, Long usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.peso = peso;
        this.altura = altura;
        this.grasaCorporal = grasaCorporal;
        this.masaMuscular = masaMuscular;
        this.usuarioId = usuarioId;
    }

    // getters and setters...
}