package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.repositorio.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionServicios {

    @Autowired
    IInscripcionRepositorio repositorio;

    //Metodo para guardar
    public Inscripcion guardarIncripcion(Inscripcion datosInscripcion)throws Exception {
        try {
            return this.repositorio.save(datosInscripcion);
        } catch (Exception error) {
            throw new Exception();
        }
    }
}
