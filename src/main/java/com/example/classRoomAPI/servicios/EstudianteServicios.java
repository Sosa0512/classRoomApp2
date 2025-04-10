package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Estudiante;
import com.example.classRoomAPI.repositorio.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicios {

    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstudiante(Estudiante datosEstudiante)throws Exception {
        try {
            return this.repositorio.save(datosEstudiante);
        } catch (Exception error) {
            throw new Exception();
        }
    }
}
