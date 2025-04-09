package com.example.classRoomAPI.modelos;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
    @Table(name = "calificacion")
    public class Calificacion {
<<<<<<< HEAD
=======
        private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_calificacion", nullable = false, unique = true)
    private int idCalificacion;

    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private BigDecimal nota;

    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    @JsonBackReference
    private Materia materia;

    public Calificacion() {
    }

<<<<<<< HEAD
    public Calificacion(int idCalificacion, BigDecimal nota, LocalDate fechaEvaluacion) {
        this.idCalificacion = idCalificacion;
=======
    public Calificacion(BigDecimal nota, LocalDate fechaEvaluacion) {
        if (nota == null || nota.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La nota no puede ser nula o negativa.");
        }
        if (fechaEvaluacion == null) {
            throw new IllegalArgumentException("La fecha de evaluación no puede ser nula.");
        }

        this.idCalificacion = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        if (nota == null || nota.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La nota no puede ser nula o negativa.");
        }
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        if (fechaEvaluacion == null) {
            throw new IllegalArgumentException("La fecha de evaluación no puede ser nula.");
        }
        this.fechaEvaluacion = fechaEvaluacion;
    }

    @Override
    public String toString() {
        return "Calificacion {ID: " + idCalificacion + ", Nota: " + nota + ", Fecha: " + fechaEvaluacion + "}";
    }
}