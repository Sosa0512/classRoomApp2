package com.example.classRoomAPI.modelos;

public class Docente {
    private int idDocente;
    private String especialidad;

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
        this.especialidad = especialidad;
    }
}
