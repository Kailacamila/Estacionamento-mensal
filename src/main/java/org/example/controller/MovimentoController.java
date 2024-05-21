package org.example.controller;


import org.example.model.Entity.Movimento;
import org.example.model.Repositories.MovimentoRepository;

import java.util.List;

public class MovimentoController {
    private MovimentoRepository movimentoRepository;

    public List<Movimento> findAll() {
        return movimentoRepository.findAll();
    }
}
