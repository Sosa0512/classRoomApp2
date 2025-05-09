package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.repositorio.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicios {

    @Autowired
    IInscripcionRepositorio repositorio;

    //Metodo para guardar
    public Inscripcion guardarIncripcion(Inscripcion datosInscripcion)throws Exception {
        try {
            return this.repositorio.save(datosInscripcion);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar todos
    public List<Inscripcion> listarInscripcion()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Inscripcion buscarInscripcionPorId(Integer id)throws Exception{
        try{
            Optional<Inscripcion> inscripcionQueEstoyBuscando=this.repositorio.findById(id);
            if(inscripcionQueEstoyBuscando.isPresent()){
                return inscripcionQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Inscripcion modificarEstudiante(Integer id, Inscripcion datosNuevosInscripcion)throws Exception{
        try{
            Optional<Inscripcion>inscripcionQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(inscripcionQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                inscripcionQueEstoyBuscandoParaEditar.get().setFechaInscripcion(datosNuevosInscripcion.getFechaInscripcion());
                //guardo las modificaciones en BD
                return this.repositorio.save(inscripcionQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaeInscripcion(Integer id)throws Exception{
        try{
            Optional<Inscripcion>inscripcionQueBusco=this.repositorio.findById(id);
            if(inscripcionQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
