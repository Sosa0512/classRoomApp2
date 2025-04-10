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
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "especialidad", nullable = false, length = 100)
    private String especialidad;

    //Creando relacion (1 a muchos)
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;


    public Docente() {
    }

    public Docente(int idDocente, Integer idUsuario, String especialidad) {
        this.idDocente = idDocente;
        this.idUsuario = idUsuario;
        this.especialidad = especialidad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
