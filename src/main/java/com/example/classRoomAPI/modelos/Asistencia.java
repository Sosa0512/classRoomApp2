package com.example.classRoomAPI.modelos;

import com.example.classRoomAPI.ayudas.Estado;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "asistencia")
public class Asistencia {
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_asistencia", nullable = false, unique = true)
    private int idAsistencia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    public Asistencia() {
    }

    public Asistencia(LocalDate fecha, Estado estado) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        if (estado == null) {
            throw new IllegalArgumentException("El estado de asistencia no puede ser nulo.");
        }

        this.idAsistencia = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado de asistencia no puede ser nulo.");
        }
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asistencia {ID: " + idAsistencia + ", Fecha: " + fecha + ", Estado: " + estado + "}";
    }
}
