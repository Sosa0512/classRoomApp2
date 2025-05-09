package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.modelos.Materia;
import com.example.classRoomAPI.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo para buscar todos
    public List<Materia> listarMateria()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Materia buscarMateriaPorId(Integer id)throws Exception{
        try{
            Optional<Materia> materiaQueEstoyBuscando=this.repositorio.findById(id);
            if(materiaQueEstoyBuscando.isPresent()){
                return materiaQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Materia modificarMateria(Integer id, Materia datosNuevosInscripcion)throws Exception{
        try{
            Optional<Materia>materiaQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(materiaQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                materiaQueEstoyBuscandoParaEditar.get().setNombre(datosNuevosInscripcion.getNombre());
                //guardo las modificaciones en BD
                return this.repositorio.save(materiaQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaeInscripcion(Integer id)throws Exception{
        try{
            Optional<Materia> materiaQueBusco=this.repositorio.findById(id);
            if(materiaQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
