package org.example.controller;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Modelo;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.ModeloRepository;
import org.example.model.Repositories.MovimentoRepository;
import org.example.model.Service.MarcaService;
import org.example.model.Service.ModeloService;

import java.util.List;

public class ModeloController {
    private ModeloService modeloService = new ModeloService();
    
    public ModeloController() {
    	
    }

    public List<Modelo> findAll() {
        return modeloService.findAll();

    }
   
    public ModeloController(ModeloRepository modeloRepository) {
        this.modeloService = new ModeloService();
    }

    public Modelo findModeloById(Long id) {
        return modeloService.findModeloById(id);
    }
    public void updateModelo(Modelo modelo) {
        modeloService.updateModelo(modelo);
    }

    public void deleteModelo(Long id) {
        modeloService.deleteModelo(id);
    }

    public Modelo createModelo(Modelo modelo) {
        return modeloService.createModelo(modelo);
    }
}