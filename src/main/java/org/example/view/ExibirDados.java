package org.example.view;

import org.example.controller.*;
import org.example.model.Entity.*;

public class ExibirDados {
    static MarcaController marcaController = new MarcaController();
    static ModeloController modeloController = new ModeloController();
    static VeiculoController veiculoController = new VeiculoController();
    static FuncionarioController funcionarioController = new FuncionarioController();
    static MovimentoController movimentoController = new MovimentoController();



    public static void ShowFuncionarioById(Long id) {
        Funcionario funcionario = funcionarioController.findFuncionarioById(id);
        if (funcionario != null) {
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
    public static void ShowMarcaById(Long id) {
        Marca marca = marcaController.findMarcaById(id);
        if (marca != null) {
            System.out.println("ID: " + marca.getId());
            System.out.println("Nome: " + marca.getNome());
        } else {
            System.out.println("Marca não encontrada.");
        }
    }
    public static void ShowModeloById(Long id) {
        Modelo modelo = modeloController.findModeloById(id);
        if (modelo != null) {
            System.out.println("ID: " + modelo.getId());
            System.out.println("Marca ID: " + modelo.getMarcaId().getId());
            System.out.println("Nome: " + modelo.getNome());
        } else {
            System.out.println("Modelo não encontrado.");
        }
    }

    public static void ShowMovimentoById(Long id) {
        Movimento movimento = movimentoController.findMovimentoById(id);
        if (movimento != null) {
            System.out.println("ID: " + movimento.getId());
            System.out.println("Entrada: " + movimento.getEntrada());
            System.out.println("Saída: " + movimento.getSaida());
            System.out.println("Tempo: " + movimento.getTempo());
            System.out.println("Veículo ID: " + movimento.getVeiculo().getId());
            System.out.println("Valor Total: " + movimento.getValorTotal());
            System.out.println("Valor Hora: " + movimento.getValorHora());
            System.out.println("Finalizado: " + movimento.isFinalizado());
            System.out.println("Funcionário ID: " + movimento.getFuncionario().getId());
        } else {
            System.out.println("Movimentação não encontrada.");
        }
    }

    public static void ShowVeiculoById(Long id) {
        Veiculo veiculo = veiculoController.findVeiculoById(id);
        if (veiculo != null) {
            System.out.println("ID: " + veiculo.getId());
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Modelo ID: " + veiculo.getModeloId().getId());
            System.out.println("Tipo: " + veiculo.getTipo());
            System.out.println("Ano: " + veiculo.getAno());
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
}
