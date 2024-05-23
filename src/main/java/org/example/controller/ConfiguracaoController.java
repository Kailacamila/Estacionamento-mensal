package org.example.controller;


import org.example.model.Entity.Configuracao;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.ConfiguracaoRepository;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Service.ConfiguracaoService;
import org.example.model.Service.MarcaService;
// import org.example.model.Repositories.ConfiguracaoRepository;

import java.util.List;

public class ConfiguracaoController {
    private ConfiguracaoService configuracaoService;

    public ConfiguracaoController(ConfiguracaoRepository configuracaoRepository) {
        this.configuracaoService = new ConfiguracaoService(configuracaoRepository);
    }
    public ConfiguracaoController() {

    }
    public List<Configuracao> findAll(Long id) {
        return configuracaoService.findAll();
    }
    public Configuracao findConfiguracaoById(Long id) {
        return configuracaoService.findConfiguracaoById(id);
    }

    public void updateConfiguracao(Configuracao configuracao) {
        configuracaoService.updateConfiguracao(configuracao);
    }

    public void deleteConfiguracao(Long id) {
        configuracaoService.deleteConfiguracao(id);
    }

    public Configuracao createConfiguracao(Configuracao configuracao) {
        return configuracaoService.createConfiguracao(configuracao);
    }
}

