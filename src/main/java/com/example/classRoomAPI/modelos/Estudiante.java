package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_estudiante", nullable = false, unique = true)
    private int idEstudiante;

    @Column(name = "grado", nullable = false)
    private int grado;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int grado, Date fechaNacimiento, String direccion, Usuario usuario) {
        this.idEstudiante = idEstudiante;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        if (grado < 6 || grado > 11) {
            throw new IllegalArgumentException("El grado debe estar entre 6 y 11.");
        }
        this.grado = grado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Estudiante {ID: " + idEstudiante + ", Grado: " + grado + ", Fecha Nacimiento: " + fechaNacimiento + ", Dirección: " + direccion + "}";
    }
}
