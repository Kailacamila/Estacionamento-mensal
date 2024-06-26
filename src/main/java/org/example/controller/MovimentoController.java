package org.example.controller;


import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.MovimentoRepository;
import org.example.model.Service.MarcaService;
import org.example.model.Service.MovimentoService;

import java.util.List;

public class MovimentoController {
    private MovimentoService movimentoService = new MovimentoService();

    public MovimentoController() {

    }
    public List<Movimento> findAll() {
        return movimentoService.findAll();
    }


    public Movimento findMovimentoById(Long id) {
        return movimentoService.findMovimentoById(id);
    }

    public void updateMovimento(Movimento movimento) {
        movimentoService.updateMovimento(movimento);
    }

    public void deleteMovimento(Long id) {
        movimentoService.deleteMovimento(id);
    }

    public Movimento createMovimento(Movimento movimento) {
        return movimentoService.createMovimento(movimento);
    }
    public Movimento finalizarMovimento(Long id) {
        return movimentoService.finalizarMovimento(id);
    }
}