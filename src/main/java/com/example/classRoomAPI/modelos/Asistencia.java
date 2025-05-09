package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_asistencia", nullable = false, unique = true)
    private Integer idAsistencia;
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "estado", nullable = false)
    private Integer Estado;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencia, Integer idEstudiante, Integer idCurso, LocalDate fecha, Integer estado) {
        this.idAsistencia = idAsistencia;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fecha = fecha;
        Estado = estado;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }
}
