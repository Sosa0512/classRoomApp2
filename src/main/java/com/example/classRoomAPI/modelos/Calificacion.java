package com.example.classRoomAPI.modelos;

import java.time.LocalDate;

public class Calificacion {
    private int idCalificacion;
    private double nota;
    private LocalDate fechaEvaluacion;

    public Calificacion() {
    }

    public Calificacion(int idCalificacion, double nota, LocalDate fechaEvaluacion) {
        this.idCalificacion = idCalificacion;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
