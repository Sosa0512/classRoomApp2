package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Estudiante;
import com.example.classRoomAPI.repositorio.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicios {

    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstudiante(Estudiante datosEstudiante)throws Exception {
        try {
            return this.repositorio.save(datosEstudiante);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar todos
    public List<Estudiante> listarEstudiante()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Estudiante buscarEstudiantePorId(Integer id)throws Exception{
        try{
            Optional<Estudiante> estudianteQueEstoyBuscando=this.repositorio.findById(id);
            if(estudianteQueEstoyBuscando.isPresent()){
                return estudianteQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Estudiante modificarEstudiante(Integer id, Estudiante datosNuevosEstudiante)throws Exception{
        try{
            Optional<Estudiante>estudianteQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(estudianteQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                estudianteQueEstoyBuscandoParaEditar.get().setGrado(datosNuevosEstudiante.getGrado());
                //guardo las modificaciones en BD
                return this.repositorio.save(estudianteQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaeEstudiante(Integer id)throws Exception{
        try{
            Optional<Estudiante>estudianteQueBusco=this.repositorio.findById(id);
            if(estudianteQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
