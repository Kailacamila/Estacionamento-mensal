package org.example.model.Service;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.VeiculoRepository;

import java.util.List;

public class VeiculoService {

    private VeiculoRepository veiculoRepository = new VeiculoRepository();

    public VeiculoService(VeiculoRepository veiculoRepository) {
    }

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