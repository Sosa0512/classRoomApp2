package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository <Materia,Integer> {
}
