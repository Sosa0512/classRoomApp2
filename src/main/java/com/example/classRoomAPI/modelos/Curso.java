package com.example.classRoomAPI.modelos;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
=======
import jakarta.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f

@Entity
@Table(name = "curso")
public class Curso {
<<<<<<< HEAD
=======
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT
>>>>>>> aba0ff467a4dd5a381d9b6f468058108862fe71f

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

    public Curso(String nombre) {
        this.idCurso = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        setNombre(nombre); // Usa el setter para aplicar validación
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
