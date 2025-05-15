package com.example.classRoomAPI.controladores;
import com.example.classRoomAPI.modelos.Curso;
import com.example.classRoomAPI.servicios.CursoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoControlador {

    @Autowired
    CursoServicios servicios;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Curso datosQueEnviaElCliente){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicios.guardarCurso(datosQueEnviaElCliente));

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
