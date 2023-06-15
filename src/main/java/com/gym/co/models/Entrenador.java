package com.gym.co.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entrenadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
	@Id
	@Column(name = "entrenador_id", length = 45)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entrenadorId;
    @Column(name = "username", length = 255)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rutina> rutinas;

    // Getters y Setters
    
	public Entrenador(Long id, String username, String email, String password) {
        this.entrenadorId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        // Inicializamos las listas como listas vacías.
        this.rutinas = new ArrayList<>();
        
    }
}
