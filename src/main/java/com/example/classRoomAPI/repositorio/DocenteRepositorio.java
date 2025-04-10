package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepositorio extends JpaRepository <Docente,Integer> {
}
