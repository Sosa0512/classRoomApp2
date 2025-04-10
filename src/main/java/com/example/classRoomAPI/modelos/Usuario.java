package com.example.classRoomAPI.modelos;
import com.example.classRoomAPI.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, unique = true)
    private Integer idUsuario;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;
    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;
    @Column(name = "telefono", length = 20, nullable = true)
    private Integer telefono;
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    public Usuario() {
        // Constructor vacío requerido por JPA
    }

    public Usuario(Integer idUsuario, String nombre, String email, String contrasena, Integer telefono, TipoUsuario tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
