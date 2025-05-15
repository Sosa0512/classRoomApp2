package com.example.classRoomAPI.controladores;

import com.example.classRoomAPI.modelos.Asistencia;
import com.example.classRoomAPI.servicios.AsistenciaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaControlador {

    @Autowired
    AsistenciaServicios servicios;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Asistencia datosQueEnviaElCliente){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicios.guardarAsistencia(datosQueEnviaElCliente));

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //buscartodos

    //buscarPorId

    //modificar

    //eliminar
}
