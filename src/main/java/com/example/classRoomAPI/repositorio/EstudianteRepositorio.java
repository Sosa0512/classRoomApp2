package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository <Estudiante,Integer> {
}
