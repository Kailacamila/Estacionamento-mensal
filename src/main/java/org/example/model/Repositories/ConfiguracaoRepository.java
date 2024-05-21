package org.example.model.Repositories;

import org.example.model.Entity.Configuracao;

import java.util.List;

public interface ConfiguracaoRepository extends JpaRepository <Configuracao , Long > {
    List<Configuracao> findAll();
}
