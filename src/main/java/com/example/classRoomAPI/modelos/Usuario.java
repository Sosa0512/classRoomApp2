package com.example.classRoomAPI.modelos;

import com.example.classRoomAPI.ayudas.TipoUsuario;

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String contraseña;
    private String correoElectrinico;
    private String telefono;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String contraseña, String correoElectrinico, String telefono, TipoUsuario tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correoElectrinico = correoElectrinico;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectrinico() {
        return correoElectrinico;
    }

    public void setCorreoElectrinico(String correoElectrinico) {
        this.correoElectrinico = correoElectrinico;
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
        this.tipoUsuario = tipoUsuario;
    }
}
