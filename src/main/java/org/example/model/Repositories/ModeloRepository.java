package org.example.model.Repositories;

import org.example.model.Entity.Configuracao;
import org.example.model.Entity.Modelo;

import java.util.List;

public interface ModeloRepository extends JpaRepository <Modelo, Long >{
    List<Modelo> findAll();
}