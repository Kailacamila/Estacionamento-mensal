package org.example.model.Service;

import org.example.model.Entity.Marca;
import org.example.model.Repositories.MarcaRepository;

import java.util.List;

public class MarcaService {

    private MarcaRepository marcaRepository = new MarcaRepository();

    public MarcaService(MarcaRepository marcaRepository) {
    }

    public Marca findMarcaById(Long id) {
        return (Marca) marcaRepository.findById(id);
    }

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public void updateMarca(Marca marca) {
        marcaRepository.update(marca);
    }

    public void deleteMarca(Long id) {
        marcaRepository.delete(id);
    }

    public Marca createMarca(Marca marca) {
        return (Marca) marcaRepository.create(marca);
    }
}