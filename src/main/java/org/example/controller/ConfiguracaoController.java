package org.example.controller;


import org.example.model.Entity.Configuracao;
import org.example.model.Repositories.ConfiguracaoRepository;

import java.util.List;

public class ConfiguracaoController {
    private ConfiguracaoRepository configuracaoRepository;

    public List<Configuracao> findAll() {
        return
                configuracaoRepository.findAll();
    }
}
