package org.example.controller;

import org.example.model.Entity.Marca;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Service.MarcaService;

import java.util.List;

public class MarcaController {
	
    private MarcaService marcaService = new MarcaService();

    public MarcaController() {

    }

    public List<Marca> findAll() {
        return marcaService.findAll();
    }

    public Marca findMarcaById(Long id) {
        return marcaService.findMarcaById(id);
    }

    public void updateMarca(Marca marca) {
        marcaService.updateMarca(marca);
    }

    public void deleteMarca(Long id) {
        marcaService.deleteMarca(id);
    }

    public Marca createMarca(Marca marca) {
        return marcaService.createMarca(marca);
    }
}