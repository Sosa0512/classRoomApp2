package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
    @Table(name = "calificacion")
    public class Calificacion {

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

    public Calificacion(int idCalificacion, BigDecimal nota, LocalDate fechaEvaluacion, Estudiante estudiante, Materia materia) {
        this.idCalificacion = idCalificacion;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
        this.estudiante = estudiante;
        this.materia = materia;
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
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Calificacion {ID: " + idCalificacion + ", Nota: " + nota + ", Fecha: " + fechaEvaluacion + "}";
    }
}