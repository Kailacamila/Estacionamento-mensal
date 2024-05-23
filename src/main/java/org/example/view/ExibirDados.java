package org.example.view;

import org.example.controller.MarcaController;
import org.example.model.Entity.Marca;

public class ExibirDados {
    public static void ShowMarcaById(){
        MarcaController marcaController = new MarcaController();
        for (Marca x : marcaController.findAll()){
            System.out.println("id"+ x.getId()+ "nome"+ x.getNome());
        }

    }
}

// exibo os dados e system busca

