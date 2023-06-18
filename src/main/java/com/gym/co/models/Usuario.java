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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	@Column(name = "usuario_id", length = 45)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "usuario_name", length = 255)
	private String username;
	@Column(name = "email", length = 255)
	private String email;
	@Column(name = "password", length = 255)
	private String password;


	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Evaluacion> evaluaciones;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Rutina> rutinas = new ArrayList<>(); 

    // ...

    
	public Usuario(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        // Inicializamos las listas como listas vacías.
       
        this.evaluaciones = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }
	public void addRutina(Rutina rutina) {
        rutinas.add(rutina);
        rutina.addUsuario(this);
    }

	public List<Rutina> getRutinas() {
        return rutinas;
    }
   

	public void setRutinas(List<Rutina> rutinas) {
        for (Rutina rutina : rutinas) {
            this.addRutina(rutina);
        }
    }
	

	// Getters y Setters

}
