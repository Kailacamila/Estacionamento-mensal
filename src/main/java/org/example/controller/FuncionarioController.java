package org.example.controller;


import org.example.model.Entity.Funcionario;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.FuncionarioRepository;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Service.FuncionarioService;
import org.example.model.Service.MarcaService;

import java.util.List;

public class FuncionarioController {
    private FuncionarioService funcionarioService = new FuncionarioService();

    public FuncionarioController() {

    }
    
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }


    public Funcionario findFuncionarioById(Long id) {
        return funcionarioService.findFuncionarioById(id);
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioService.updateFuncionario(funcionario);
    }

    public void deleteFuncionario(Long id) {
        funcionarioService.deleteFuncionario(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }
}