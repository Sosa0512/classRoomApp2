package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.modelos.Usuario;
import com.example.classRoomAPI.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo para buscar todos
    public List<Usuario> listarUsuario()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Usuario buscarUsuarioPorId(Integer id)throws Exception{
        try{
            Optional<Usuario> usuarioQueEstoyBuscando=this.repositorio.findById(id);
            if(usuarioQueEstoyBuscando.isPresent()){
                return usuarioQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Usuario modificarUsuario(Integer id, Usuario datosNuevosInscripcion)throws Exception{
        try{
            Optional<Usuario>usuarioQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(usuarioQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                usuarioQueEstoyBuscandoParaEditar.get().setTipoUsuario(datosNuevosInscripcion.getTipoUsuario());
                //guardo las modificaciones en BD
                return this.repositorio.save(usuarioQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaeInscripcion(Integer id)throws Exception{
        try{
            Optional<Usuario>usuarioQueBusco=this.repositorio.findById(id);
            if(usuarioQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
