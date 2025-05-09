package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Calificacion;
import com.example.classRoomAPI.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServicios {

    @Autowired
    ICalificacionRepositorio repositorio;

    //Metodo para guardar
    public Calificacion guardarCalificacion(Calificacion datosCalificacion)throws Exception{
        try{
            return this.repositorio.save(datosCalificacion);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscar todos
    public List<Calificacion> listarCalificacion()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Calificacion buscarCalificacionPorId(Integer id)throws Exception{
        try{
            Optional<Calificacion> calificacionQueEstoyBuscando=this.repositorio.findById(id);
            if(calificacionQueEstoyBuscando.isPresent()){
                return calificacionQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Calificacion modificarEstudiante(Integer id, Calificacion datosNuevosCalificacion)throws Exception{
        try{
            Optional<Calificacion>calificacionQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(calificacionQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                calificacionQueEstoyBuscandoParaEditar.get().setNota(datosNuevosCalificacion.getNota());
                //guardo las modificaciones en BD
                return this.repositorio.save(calificacionQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo para eliminar
    public boolean eliminaCalificacion(Integer id)throws Exception{
        try{
            Optional<Calificacion>calificacionQueBusco=this.repositorio.findById(id);
            if(calificacionQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
