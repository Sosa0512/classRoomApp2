package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Materia;
import com.example.classRoomAPI.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServicios {

        @Autowired
        IMateriaRepositorio repositorio;

        //Metodo para guardar
        public Materia guardarMateria(Materia datosMateria)throws Exception {
            try {
                return this.repositorio.save(datosMateria);
            } catch (Exception error) {
                throw new Exception();
            }
        }
}
