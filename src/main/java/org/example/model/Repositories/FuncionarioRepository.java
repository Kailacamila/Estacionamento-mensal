package org.example.model.Repositories;

import org.example.model.Entity.Funcionario;

import java.util.List;

public interface FuncionarioRepository extends  JpaRepository <Funcionario , Long > {
    List<Funcionario> findAll();
}
