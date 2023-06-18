package com.gym.co.models;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "altura")
    private Double altura;
    @Column(name = "grasa_corporal")
    private Double grasaCorporal;
    @Column(name = "masa_muscular")
    private Double masaMuscular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructor vacío
    // Constructor con parámetros

    // Getters y Setters
}