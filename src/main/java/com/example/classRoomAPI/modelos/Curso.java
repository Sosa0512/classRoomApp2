package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_curso", nullable = false, unique = true)
    private Integer idCurso;
    @Column(name = "nombre", nullable = false, length = 100)
    private Integer nombre;
    @Column(name = "id_docente")
    private Integer idDocente;

    //creando relacion (muchos a 1)
    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference
    private Docente docente;

    @OneToOne(mappedBy = "curso")
    @JsonManagedReference
    private Inscripcion inscripcion;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Materia> materia;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Asistencia> asistencia;

    public Curso() {
    }

    public Curso(Integer idCurso, Integer nombre, Integer idDocente) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.idDocente = idDocente;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }
}
