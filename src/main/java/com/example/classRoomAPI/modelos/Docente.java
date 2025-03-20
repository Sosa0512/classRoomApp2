package com.example.classRoomAPI.modelos;
import jakarta.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "docente")
public class Docente {
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_docente", nullable = false, unique = true)
    private int idDocente;

    @Column(name = "especialidad", nullable = false, length = 100)
    private String especialidad;

    public Docente() {
    }

    public Docente(String especialidad) {
        this.idDocente = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        setEspecialidad(especialidad); // Usa el setter para validación
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Docente {ID: " + idDocente + ", Especialidad: " + especialidad + "}";
    }
}
