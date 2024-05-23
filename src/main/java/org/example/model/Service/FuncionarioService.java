package org.example.model.Service;

import org.example.model.Entity.Funcionario;
import org.example.model.Entity.Marca;
import org.example.model.Repositories.FuncionarioRepository;
import org.example.model.Repositories.MarcaRepository;

import java.util.List;

public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
    }

    public Funcionario findFuncionarioById(Long id) {
        return (Funcionario) funcionarioRepository.findById(id);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioRepository.update(funcionario);
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.delete(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return (Funcionario) funcionarioRepository.create(funcionario);
    }

}