package com.example.classRoomAPI.repositorio;

import com.example.classRoomAPI.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,Integer> {
}
