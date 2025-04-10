package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_materia", nullable = false, unique = true)
    private int idMateria;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonBackReference
    private Curso curso;

    public Materia() {
        // Constructor vacío requerido por JPA
    }

    public Materia(int idMateria, String nombre, Curso curso) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters y Setters
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Materia {ID: " + idMateria + ", Nombre: " + nombre + "}";
    }
}
