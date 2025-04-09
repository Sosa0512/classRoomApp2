package com.example.classRoomAPI.modelos;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
<<<<<<< HEAD
=======
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_inscripcion", nullable = false, unique = true)
    private int idInscripcion;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;

<<<<<<< HEAD
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
=======
    public Inscripcion() {
    }

    public Inscripcion(LocalDateTime fechaInscripcion) {
        this.idInscripcion = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        this.fechaInscripcion = (fechaInscripcion != null) ? fechaInscripcion : LocalDateTime.now();
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f
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
