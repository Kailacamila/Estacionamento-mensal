package org.example.model.Repositories;

import org.example.model.Entity.Veiculo;

import java.util.List;

@Repository

public interface VeiculoRepository  extends JpaRepository<Veiculo, Long> {


    List<Veiculo> findAll();
}
