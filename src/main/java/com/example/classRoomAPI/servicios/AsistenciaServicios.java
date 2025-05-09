package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Asistencia;
import com.example.classRoomAPI.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicios {

    @Autowired
    IAsistenciaRepositorio repositorio;

    //Metodo para guardar
    public Asistencia guardarAsistencia(Asistencia datosAsistencia) throws Exception{
        try{
            return this.repositorio.save(datosAsistencia);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscar todos
    public List<Asistencia> listarAsistencia()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }
    //Metodo para buscar uno por id
    public Asistencia buscarAsistenciaPorId(Integer id)throws Exception{
        try{
            Optional<Asistencia> asistenciaQueEstoyBuscando=this.repositorio.findById(id);
            if(asistenciaQueEstoyBuscando.isPresent()){
                return asistenciaQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo para modificar
    public Asistencia modificarCurso(Integer id, Asistencia datosNuevosAsistencia)throws Exception{
        try{
            Optional<Asistencia>asistenciaQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(asistenciaQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
               asistenciaQueEstoyBuscandoParaEditar.get().setEstado(datosNuevosAsistencia.getEstado());
                //guardo las modificaciones en BD
                return this.repositorio.save(asistenciaQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaAsistencia(Integer id)throws Exception{
        try{
            Optional<Asistencia>asistenciaQueBusco=this.repositorio.findById(id);
            if(asistenciaQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
