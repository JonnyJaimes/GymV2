package com.gym.co.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "rutinas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rutina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 255)
    private String nombre;

    // Detalles de la rutina
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
    
    @ManyToMany(mappedBy = "rutinas")
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ejercicio> ejercicios = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.getRutinas().add(this);
    }


    public void setUsuarios(Usuario usuario) {
        this.usuarios.clear();
        if (usuario != null) {
            this.usuarios.add(usuario);
            usuario.getRutinas().add(this);
        }
    }


    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }


    
  


    
}

