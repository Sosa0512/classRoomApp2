package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Curso;
import com.example.classRoomAPI.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicios {

    @Autowired
    ICursoRepositorio repositorio;

    //Metodo para guardar
    public Curso guardarCurso(Curso datosCurso)throws Exception{
        try{
            return this.repositorio.save(datosCurso);
        }catch (Exception error){
            throw new Exception();
        }
    }
}
