package org.example.controller;

import org.example.model.Entity.Modelo;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.ModeloRepository;
import org.example.model.Repositories.MovimentoRepository;

import java.util.List;

public class ModeloController {
    private ModeloRepository modeloRepository;

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }
}
