package org.example.controller;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Entity.Veiculo;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.VeiculoRepository;
import org.example.model.Service.MarcaService;
import org.example.model.Service.VeiculoService;

import java.util.List;

public class VeiculoController {

	 private VeiculoService veiculoService = new VeiculoService();


	    public VeiculoController() {
	        
	    }
	    
    public List<Veiculo> findAll(Long id) {
        return veiculoService.findAll();
    }
  

    public Veiculo findVeiculoById(Long id) {
        return veiculoService.findVeiculoById(id);
    }

    public void updateVeiculo(Veiculo veiculo) {
        veiculoService.updateVeiculo(veiculo);
    }

    public void deleteVeiculo(Long id) {
        veiculoService.deleteVeiculo(id);
    }

    public Veiculo createVeiculo(Veiculo veiculo) {
        return veiculoService.createVeiculo(veiculo);
    }
}