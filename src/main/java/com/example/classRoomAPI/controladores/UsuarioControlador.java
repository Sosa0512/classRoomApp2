package com.example.classRoomAPI.controladores;

import com.example.classRoomAPI.modelos.Usuario;
import com.example.classRoomAPI.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicios servicios;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosQueEnviaElCliente){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicios.guardarUsuario(datosQueEnviaElCliente));

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
