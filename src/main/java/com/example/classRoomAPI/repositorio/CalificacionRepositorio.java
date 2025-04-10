package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepositorio extends JpaRepository <Calificacion,Integer> {
}
