package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Asistencia;
import com.example.classRoomAPI.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServicios {

    @Autowired
    IAsistenciaRepositorio repositorio;

    //Metodo para guardar
    public Asistencia guardarAsistencia(Asistencia datosAsistencia) throws Exception{
        try{
            return this.repositorio.save(datosAsistencia);
        }catch (Exception error){
            throw new Exception();
        }
    }
}
