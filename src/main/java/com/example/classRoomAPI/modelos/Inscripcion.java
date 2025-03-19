package com.example.classRoomAPI.modelos;

import java.time.LocalDateTime;

public class Inscripcion {
    private int idInscripcion;
    private LocalDateTime fechaInscripcion;

    // Constructor vacío
    public Inscripcion() {
        this.fechaInscripcion = LocalDateTime.now(); // Asignar fecha actual por defecto
    }

    // Constructor con parámetros
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
        this.fechaInscripcion = fechaInscripcion;
    }

    public void mostrarInfo() {
        System.out.println("ID Inscripción: " + idInscripcion);
        System.out.println("Fecha de Inscripción: " + fechaInscripcion);
    }
}
