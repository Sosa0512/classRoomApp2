package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository <Curso,Integer> {
}
