package com.example.classRoomAPI.modelos;
import jakarta.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "materia")
public class Materia {
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_materia", nullable = false, unique = true)
    private int idMateria;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public Materia() {
        // Constructor vacío requerido por JPA
    }

    public Materia(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacío.");
        }

        this.idMateria = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        this.nombre = nombre;
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
