package org.example.model.Service;

import org.example.model.Entity.Configuracao;
import org.example.model.Entity.Funcionario;
import org.example.model.Repositories.ConfiguracaoRepository;
import org.example.model.Repositories.FuncionarioRepository;

import java.util.List;

public class ConfiguracaoService {
    private ConfiguracaoRepository configuracaoRepository = new ConfiguracaoRepository();

    public ConfiguracaoService(ConfiguracaoRepository configuracaoRepository) {
    }

    public Configuracao findConfiguracaoById(Long id) {
        return (Configuracao) configuracaoRepository.findById(id);
    }

    public List<Configuracao> findAll() {
        return configuracaoRepository.findAll();
    }

    public void updateConfiguracao(Configuracao configuracao) {
        configuracaoRepository.update(configuracao);
    }

    public void deleteConfiguracao(Long id) {
        configuracaoRepository.delete(id);
    }

    public Configuracao createConfiguracao(Configuracao configuracao) {
        return (Configuracao) configuracaoRepository.create(configuracao);
    }

}

