package com.example.classRoomAPI.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_inscripcion", nullable = false, unique = true)
    private int idInscripcion;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonBackReference
    private Curso curso;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, LocalDateTime fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        if (fechaInscripcion == null) {
            throw new IllegalArgumentException("La fecha de inscripción no puede ser nula.");
        }
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion {ID: " + idInscripcion + ", Fecha: " + fechaInscripcion + "}";
    }
}
