package org.example.model.Service;

import java.util.List;

import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.VeiculoRepository;

public class VeiculoService {

	  private VeiculoRepository veiculoRepository = new VeiculoRepository();


  

    public Veiculo findVeiculoById(Long id) {
        return (Veiculo) veiculoRepository.findById(id);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public void updateVeiculo(Veiculo veiculo) {
        veiculoRepository.update(veiculo);
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.delete(id);
    }

    public Veiculo createVeiculo(Veiculo veiculo) {
        return (Veiculo) veiculoRepository.create(veiculo);
    }
}