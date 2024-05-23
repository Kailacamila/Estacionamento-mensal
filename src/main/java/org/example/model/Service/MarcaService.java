package org.example.model.Service;

import org.example.model.Entity.Marca;
import org.example.model.Repositories.MarcaRepository;

public class MarcaService {

    private final MarcaRepository marcaRepository = new MarcaRepository();

    public Marca findClientByIdCar(Long id){
        return (Marca) marcaRepository.findById(id);
    }
}
