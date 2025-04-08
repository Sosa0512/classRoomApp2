package com.example.classRoomAPI.modelos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Simula AUTO_INCREMENT en BD
    @Column(name = "id_docente", nullable = false, unique = true)
    private int idDocente;

    @Column(name = "especialidad", nullable = false, length = 100)
    private String especialidad;

    //Creando relacion (1 a muchos)
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;


    public Docente() {
    }

    public Docente(int idDocente, String especialidad) {
        this.idDocente = idDocente;
        this.especialidad = especialidad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Docente {ID: " + idDocente + ", Especialidad: " + especialidad + "}";
    }
}
