package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
    @Table(name = "calificacion")
    public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Column(name = "id_materia")
    private Integer idMateria;
    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private Integer nota;
    @Column(name = "fecha_evaluacion", nullable = false)
    private Integer fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_materia",referencedColumnName = "id_materia")
    @JsonBackReference
    private Materia materia;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Integer idEstudiante, Integer idMateria, Integer nota, Integer fechaEvaluacion) {
        this.idCalificacion = idCalificacion;
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Integer fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}