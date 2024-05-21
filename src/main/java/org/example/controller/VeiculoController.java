package org.example.controller;

import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.VeiculoRepository;

import java.util.List;

public class VeiculoController {

    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }
}
