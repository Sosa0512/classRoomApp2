package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepositorio extends JpaRepository <Inscripcion,Integer> {
}
