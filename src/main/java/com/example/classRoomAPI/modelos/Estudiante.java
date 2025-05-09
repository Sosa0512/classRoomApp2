package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_estudiante", nullable = false, unique = true)
    private Integer idEstudiante;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "grado", nullable = false)
    private Integer grado;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @OneToOne(mappedBy = "estudiante")
    @JsonManagedReference
    private Inscripcion inscripcion;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia> asistencia;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, Integer idUsuario, Integer grado, Date fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.idUsuario = idUsuario;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    // Getters y Setters

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
