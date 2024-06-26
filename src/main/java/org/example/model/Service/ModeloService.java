package org.example.model.Service;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Modelo;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.ModeloRepository;

import java.util.List;

public class ModeloService {

    private ModeloRepository modeloRepository = new ModeloRepository();


    public Modelo findModeloById(Long id) {
        return (Modelo) modeloRepository.findById(id);
    }

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    public void updateModelo(Modelo quiosque) {
        modeloRepository.update(quiosque);
    }

    public void deleteModelo(Long id) {
        modeloRepository.delete(id);
    }

    public Modelo createModelo(Modelo modelo) {
        return (Modelo) modeloRepository.create(modelo);
    }
}