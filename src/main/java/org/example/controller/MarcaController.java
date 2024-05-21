package org.example.controller;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.MovimentoRepository;

import java.util.List;

public class MarcaController {
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }
}
