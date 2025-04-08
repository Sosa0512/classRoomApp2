package com.example.classRoomAPI.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_curso", nullable = false, unique = true)
    private int idCurso;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    //creando relacion (muchos a 1)
    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id")
    @JsonBackReference
    private Docente docente;

    public Curso() {
    }

    public Curso(int idCurso, String nombre) {
        this.idCurso = idCurso;
        this.nombre = nombre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso {ID: " + idCurso + ", Nombre: " + nombre + "}";
    }
}
