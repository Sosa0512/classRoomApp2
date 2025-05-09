package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Curso;
import com.example.classRoomAPI.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicios {

    @Autowired
    ICursoRepositorio repositorio;

    //Metodo para guardar
    public Curso guardarCurso(Curso datosCurso)throws Exception{
        try{
            return this.repositorio.save(datosCurso);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo para buscar todos
    public List<Curso> listarCurso()throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error) {
            throw new Exception();
        }
    }

    //Metodo para buscar uno por id
    public Curso buscarCursoPorId(Integer id)throws Exception{
        try{
            Optional<Curso> cursoQueEstoyBuscando=this.repositorio.findById(id);
            if(cursoQueEstoyBuscando.isPresent()){
                return cursoQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar
    public Curso modificarCurso(Integer id, Curso datosNuevosCurso)throws Exception{
        try{
            Optional<Curso>cursoQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(cursoQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                cursoQueEstoyBuscandoParaEditar.get().setNombre(datosNuevosCurso.getNombre());
                //guardo las modificaciones en BD
                return this.repositorio.save(cursoQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean eliminaCurso(Integer id)throws Exception{
        try{
            Optional<Curso>cursoQueBusco=this.repositorio.findById(id);
            if(cursoQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
