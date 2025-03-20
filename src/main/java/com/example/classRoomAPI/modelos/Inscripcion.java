package com.example.classRoomAPI.modelos;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_inscripcion", nullable = false, unique = true)
    private int idInscripcion;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(LocalDateTime fechaInscripcion) {
        this.idInscripcion = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        this.fechaInscripcion = (fechaInscripcion != null) ? fechaInscripcion : LocalDateTime.now();
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
