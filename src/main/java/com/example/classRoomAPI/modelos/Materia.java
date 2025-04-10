package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_materia", nullable = false, unique = true)
    private Integer idMateria;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "id_curso")
    private Integer idCurso;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    @OneToMany (mappedBy = "materia")
    @JsonManagedReference
    private List<Calificacion> calificacion;

    public Materia() {
        // Constructor vacío requerido por JPA
    }

    public Materia(Integer idMateria, String nombre, Integer idCurso) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.idCurso = idCurso;
    }

    // Getters y Setters

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
