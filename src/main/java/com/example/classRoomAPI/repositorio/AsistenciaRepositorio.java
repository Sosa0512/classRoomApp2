package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepositorio extends JpaRepository <Asistencia,Integer> {

}
