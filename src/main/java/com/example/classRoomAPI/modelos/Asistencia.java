package com.example.classRoomAPI.modelos;

import com.example.classRoomAPI.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_asistencia", nullable = false, unique = true)
    private int idAsistencia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonBackReference
    private Curso curso;

    public Asistencia() {
    }

    public Asistencia(int idAsistencia, LocalDate fecha, Estado estado) {
        this.idAsistencia = idAsistencia;
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
