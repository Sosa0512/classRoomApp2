package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Usuario;
import com.example.classRoomAPI.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicios {

    @Autowired
    IUsuarioRepositorio repositorio;

    //Metodo para guardar
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception {
        try {
            return this.repositorio.save(datosUsuario);
        } catch (Exception error) {
            throw new Exception();
        }
    }
}
