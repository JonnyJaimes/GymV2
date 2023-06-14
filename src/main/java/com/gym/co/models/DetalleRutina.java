package com.gym.co.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_rutina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "tiempo")
    private Integer tiempo; // Duración en minutos

    @Column(name = "series")
    private Integer series;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "tipo_rutina", length = 255)
    private String tipoRutina; // Diaria, Semanal, etc.

    @Column(name = "video_url", length = 1000)
    private String videoUrl; // URL del video explicativo

    @Column(name = "categoria", length = 255)
    private String categoria; // Categoría de la rutina

    // Getters y Setters
}