package com.example.classRoomAPI.modelos;
import com.example.classRoomAPI.ayudas.TipoUsuario;
import jakarta.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "usuario")
public class Usuario {
    private static final AtomicInteger contadorId = new AtomicInteger(1); // Simula AUTO_INCREMENT

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, unique = true)
    private int idUsuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    public Usuario() {
        // Constructor vacío requerido por JPA
    }

    public Usuario(String nombre, String email, String contrasena, String telefono, TipoUsuario tipoUsuario) {
        this.idUsuario = contadorId.getAndIncrement(); // Simula AUTO_INCREMENT
        setNombre(nombre);
        setEmail(email);
        setContrasena(contrasena);
        setTelefono(telefono);
        setTipoUsuario(tipoUsuario);
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
        }
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            throw new IllegalArgumentException("El tipo de usuario no puede ser nulo.");
        }
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario {ID: " + idUsuario + ", Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono + ", Tipo: " + tipoUsuario + "}";
    }
}
