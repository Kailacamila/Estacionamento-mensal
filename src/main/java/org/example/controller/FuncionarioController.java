package org.example.controller;


import org.example.model.Entity.Funcionario;
import org.example.model.Repositories.FuncionarioRepository;

import java.util.List;

public class FuncionarioController {
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}
