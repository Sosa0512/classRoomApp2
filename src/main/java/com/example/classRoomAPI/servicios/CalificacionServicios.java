package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Calificacion;
import com.example.classRoomAPI.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionServicios {

    @Autowired
    ICalificacionRepositorio repositorio;

    //Metodo para guardar
    public Calificacion guardarCalificacion(Calificacion datosCalificacion)throws Exception{
        try{
            return this.repositorio.save(datosCalificacion);
        }catch (Exception error){
            throw new Exception();
        }
    }
}
