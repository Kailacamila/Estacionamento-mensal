package org.example.view;

import org.example.controller.*;
import org.example.model.Entity.*;
import org.example.model.Repositories.*;
import org.example.view.ExibirDados;

import java.util.Scanner;

public class Main {
    static FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    static FuncionarioController funcionarioController = new FuncionarioController(funcionarioRepository);
    static VeiculoRepository veiculoRepository = new VeiculoRepository();
    static VeiculoController veiculoController = new VeiculoController(veiculoRepository);
    static MarcaRepository marcaRepository = new MarcaRepository();
    static MarcaController marcaController = new MarcaController(marcaRepository);
    static ModeloRepository modeloRepository = new ModeloRepository();
    static ModeloController modeloController = new ModeloController(modeloRepository);
    static MovimentoRepository movimentoRepository = new MovimentoRepository();
    static MovimentoController movimentoController = new MovimentoController(movimentoRepository);

    private static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("Seja bem-vind@");
        System.out.println("1 - Gestão de veículos");
        System.out.println("2 - Gestão de funcionários");
        System.out.println("3 - Gestão de marcas");
        System.out.println("4 - Gestão de modelos");
        System.out.println("5 - Gestão de movimentos");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> exibirOpcoesVeiculo();
            case 2 -> exibirOpcoesFuncionario();
            case 3 -> exibirOpcoesMarca();
            case 4 -> exibirOpcoesModelo();
            case 5 -> exibirOpcoesMovimento();
            case 0 -> System.out.println("Saindo...");
            default -> {
                System.out.println("Opção inválida");
                exibirMenuPrincipal();
            }
        }
    }

    private static void exibirOpcoesVeiculo() {
        System.out.println("1 - Buscar veículo pelo ID");
        System.out.println("2 - Editar veículo");
        System.out.println("3 - Novo veículo");
        System.out.println("4 - Excluir veículo");
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o ID do veículo:");
                long id = sc.nextLong();
                ExibirDados.ShowVeiculoById(id);
                aguardarEnter();
                exibirOpcoesVeiculo();
            }
            case 2 -> {
                editarVeiculo();
                aguardarEnter();
                exibirOpcoesVeiculo();
            }
            case 3 -> {
                criarNovoVeiculo();
                aguardarEnter();
                exibirOpcoesVeiculo();
            }
            case 4 -> {
                System.out.println("Digite o ID do veículo a ser excluído:");
                long deleteId = sc.nextLong();
                veiculoController.deleteVeiculo(deleteId);
                System.out.println("Veículo excluído.");
                aguardarEnter();
                exibirOpcoesVeiculo();
            }
            case 0 -> exibirMenuPrincipal();
            default -> {
                System.out.println("Opção inválida.");
                exibirOpcoesVeiculo();
            }
        }
    }

    private static void editarVeiculo() {
        System.out.println("Digite o ID do veículo a ser editado:");
        long id = sc.nextLong();
        sc.nextLine();

        Veiculo veiculo = veiculoController.findVeiculoById(id);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.println("Digite a nova placa (ou pressione Enter para manter a atual: " + veiculo.getPlaca() + "):");
        String novaPlaca = sc.nextLine();
        if (!novaPlaca.isEmpty()) {
            veiculo.setPlaca(novaPlaca);
        }

        System.out.println("Digite o novo ID do modelo (ou pressione Enter para manter o atual: " + veiculo.getModeloId().getId() + "):");
        String novoIdModelo = sc.nextLine();
        if (!novoIdModelo.isEmpty()) {
            long modeloId = Long.parseLong(novoIdModelo);
            Modelo novoModelo = modeloController.findModeloById(modeloId);
            if (novoModelo != null) {
                veiculo.setModeloId(novoModelo);
            } else {
                System.out.println("Modelo não encontrado.");
            }
        }

        veiculoController.updateVeiculo(veiculo);
        System.out.println("Veículo atualizado com sucesso.");
    }

    private static void criarNovoVeiculo() {

        System.out.println("Digite a placa do novo veículo:");
        String placa = sc.nextLine();

        System.out.println("Digite o ID do modelo do novo veículo:");
        long idModelo = sc.nextLong();
        Modelo modelo = modeloController.findModeloById(idModelo);

        System.out.println("Digite a cor do novo veiculo:");
        String cor = sc.nextLine();

        System.out.println("Digite o ano do novo veículo:");
        long ano = sc.nextLong();

        System.out.println("Digite o tipo do novo veiculo(carro, moto ou van):");
        String tipo = sc.nextLine();

        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.setPlaca(placa);
        novoVeiculo.setModeloId(modelo);
        novoVeiculo.setCor(cor);
        novoVeiculo.setTipo(cor);
        novoVeiculo.setAno(ano);

        Veiculo criadoVeiculo = veiculoController.createVeiculo(novoVeiculo);

        if (criadoVeiculo != null) {
            System.out.println("Novo veículo criado com sucesso.");
            System.out.println("ID: " + criadoVeiculo.getId());
            System.out.println("Placa: " + criadoVeiculo.getPlaca());
            System.out.println("ID do Modelo: " + criadoVeiculo.getModeloId());
            System.out.println("Cor: " + criadoVeiculo.getCor());
            System.out.println("Ano: " + criadoVeiculo.getAno());

        } else {
            System.out.println("Falha ao criar novo veículo.");
        }
    }

    private static void exibirOpcoesFuncionario() {
        System.out.println("1 - Buscar funcionário pelo ID");
        System.out.println("2 - Editar funcionário");
        System.out.println("3 - Novo funcionário");
        System.out.println("4 - Excluir funcionário");
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o ID do funcionário:");
                long id = sc.nextLong();
                ExibirDados.ShowFuncionarioById(id);
                aguardarEnter();
                exibirOpcoesFuncionario();
                break;
            case 2:
                editarFuncionario();
                aguardarEnter();
                exibirOpcoesFuncionario();
                break;
            case 3:
                criarNovoFuncionario();
                aguardarEnter();
                exibirOpcoesFuncionario();
                break;
            case 4:
                System.out.println("Digite o ID do funcionário a ser excluído:");
                long deleteId = sc.nextLong();
                funcionarioController.deleteFuncionario(deleteId);
                System.out.println("Funcionário excluído.");
                aguardarEnter();
                exibirOpcoesFuncionario();
                break;
            case 0:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirOpcoesFuncionario();
                break;
        }
    }

    private static void editarFuncionario() {
        System.out.println("Digite o ID do funcionário a ser editado:");
        long id = sc.nextLong();
        sc.nextLine();

        Funcionario funcionario = funcionarioController.findFuncionarioById(id);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome (ou pressione Enter para manter o atual: " + funcionario.getNome() + "):");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) {
            funcionario.setNome(novoNome);
        }

        System.out.println("Digite o novo cpf (ou pressione Enter para manter o atual: " + funcionario.getCpf() + "):");
        String novoCpf = sc.nextLine();
        if (!novoCpf.isEmpty()) {
            funcionario.setCpf(novoCpf);
        }

        funcionarioController.updateFuncionario(funcionario);
        System.out.println("Funcionário atualizado com sucesso.");
    }

    private static void criarNovoFuncionario() {
        System.out.println("Digite o nome do novo funcionário:");
        String nome = sc.nextLine();

        System.out.println("Digite o cpf do novo funcionário:");
        String cpf = sc.nextLine();

        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(nome);
        novoFuncionario.setCpf(cpf);

        Funcionario criadoFuncionario = funcionarioController.createFuncionario(novoFuncionario);

        if (criadoFuncionario != null) {
            System.out.println("Novo funcionário criado com sucesso.");
            System.out.println("ID: " + criadoFuncionario.getId());
            System.out.println("Nome: " + criadoFuncionario.getNome());
            System.out.println("Telefone: " + criadoFuncionario.getCpf());
        } else {
            System.out.println("Falha ao criar novo funcionário.");
        }
    }

    private static void exibirOpcoesMarca() {
        System.out.println("1 - Buscar marca pelo ID");
        System.out.println("2 - Editar marca");
        System.out.println("3 - Nova marca");
        System.out.println("4 - Excluir marca");
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o ID da marca:");
                long id = sc.nextLong();
                ExibirDados.ShowMarcaById(id);
                aguardarEnter();
                exibirOpcoesMarca();
                break;
            case 2:
                editarMarca();
                aguardarEnter();
                exibirOpcoesMarca();
                break;
            case 3:
                criarNovaMarca();
                aguardarEnter();
                exibirOpcoesMarca();
                break;
            case 4:
                System.out.println("Digite o ID da marca a ser excluída:");
                long deleteId = sc.nextLong();
                marcaController.deleteMarca(deleteId);
                System.out.println("Marca excluída.");
                aguardarEnter();
                exibirOpcoesMarca();
                break;
            case 0:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirOpcoesMarca();
                break;
        }
    }

    private static void editarMarca() {
        System.out.println("Digite o ID da marca a ser editada:");
        long id = sc.nextLong();
        sc.nextLine();

        Marca marca = marcaController.findMarcaById(id);
        if (marca == null) {
            System.out.println("Marca não encontrada.");
            return;
        }

        System.out.println("Digite o novo nome (ou pressione Enter para manter o atual: " + marca.getNome() + "):");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) {
            marca.setNome(novoNome);
        }

        marcaController.updateMarca(marca);
        System.out.println("Marca atualizada com sucesso.");
    }

    private static void criarNovaMarca() {
        System.out.println("Digite o nome da nova marca:");
        String nome = sc.nextLine();

        Marca novaMarca = new Marca();
        novaMarca.setNome(nome);

        Marca criadaMarca = marcaController.createMarca(novaMarca);

        if (criadaMarca != null) {
            System.out.println("Nova marca criada com sucesso.");
            System.out.println("ID: " + criadaMarca.getId());
            System.out.println("Nome: " + criadaMarca.getNome());
        } else {
            System.out.println("Falha ao criar nova marca.");
        }
    }

    private static void exibirOpcoesModelo() {
        System.out.println("1 - Buscar modelo pelo ID");
        System.out.println("2 - Editar modelo");
        System.out.println("3 - Novo modelo");
        System.out.println("4 - Excluir modelo");
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o ID do modelo:");
                long id = sc.nextLong();
                ExibirDados.ShowModeloById(id);
                aguardarEnter();
                exibirOpcoesModelo();
            }
            case 2 -> {
                editarModelo();
                aguardarEnter();
                exibirOpcoesModelo();
            }
            case 3 -> {
                criarNovoModelo();
                aguardarEnter();
                exibirOpcoesModelo();
            }
            case 4 -> {
                System.out.println("Digite o ID do modelo a ser excluído:");
                long deleteId = sc.nextLong();
                modeloController.deleteModelo(deleteId);
                System.out.println("Modelo excluído.");
                aguardarEnter();
                exibirOpcoesModelo();
            }
            case 0 -> exibirMenuPrincipal();
            default -> {
                System.out.println("Opção inválida.");
                exibirOpcoesModelo();
            }
        }
    }

    private static void editarModelo() {
        System.out.println("Digite o ID do modelo a ser editado:");
        long id = sc.nextLong();
        sc.nextLine();

        Modelo modelo = modeloController.findModeloById(id);
        if (modelo == null) {
            System.out.println("Modelo não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome (ou pressione Enter para manter o atual: " + modelo.getNome() + "):");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) {
            modelo.setNome(novoNome);
        }

        System.out.println("Digite o novo ID da marca (ou pressione Enter para manter o atual: " + modelo.getMarcaId() + "):");
        String novoIdMarca = sc.nextLine();
         long marcaId = Long.parseLong(novoIdMarca);
        Marca marca = marcaController.findMarcaById(marcaId);

        if (!novoIdMarca.isEmpty()) {
            modelo.setMarcaId(marca);
        }

        modeloController.updateModelo(modelo);
        System.out.println("Modelo atualizado com sucesso.");
    }

    private static void criarNovoModelo() {
        System.out.println("Digite o nome do novo modelo:");
        String nome = sc.nextLine();

        System.out.println("Digite o ID da marca do novo modelo:");
        long idMarca = sc.nextLong();
        Marca marca = marcaController.findMarcaById(idMarca);

        Modelo novoModelo = new Modelo();
        novoModelo.setNome(nome);
        novoModelo.setMarcaId(marca);
        Modelo criadoModelo = modeloController.createModelo(novoModelo);

        if (criadoModelo != null) {
            System.out.println("Novo modelo criado com sucesso.");
            System.out.println("ID: " + criadoModelo.getId());
            System.out.println("Nome: " + criadoModelo.getNome());
            System.out.println("ID da Marca: " + criadoModelo.getMarcaId());
        } else {
            System.out.println("Falha ao criar novo modelo.");
        }
    }

    private static void exibirOpcoesMovimento() {
        System.out.println("1 - Buscar movimento pelo ID");
        System.out.println("2 - Editar movimento");
        System.out.println("3 - Novo movimento");
        System.out.println("4 - Excluir movimento");
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Escolha uma opção:");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o ID do movimento:");
                long id = sc.nextLong();
                ExibirDados.ShowMovimentoById(id);
                aguardarEnter();
                exibirOpcoesMovimento();
                break;
            case 2:
                editarMovimento();
                aguardarEnter();
                exibirOpcoesMovimento();
                break;
            case 3:
                criarNovoMovimento();
                aguardarEnter();
                exibirOpcoesMovimento();
                break;
            case 4:
                System.out.println("Digite o ID do movimento a ser excluído:");
                long deleteId = sc.nextLong();
                movimentoController.deleteMovimento(deleteId);
                System.out.println("Movimento excluído.");
                aguardarEnter();
                exibirOpcoesMovimento();
                break;
            case 0:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirOpcoesMovimento();
                break;
        }
    }

    private static void editarMovimento() {
//        System.out.println("Digite o ID do movimento a ser editado:");
//        long id = sc.nextLong();
//        sc.nextLine();
//
//        Movimento movimento = movimentoController.findMovimentoById(id);
//        if (movimento == null) {
//            System.out.println("Movimento não encontrado.");
//            return;
//        }
//
//        System.out.println("Digite o novo ID do veículo (ou pressione Enter para manter o atual: " + movimento.getVeiculo() + "):");
//        String novoIdVeiculo = sc.nextLine();
//        if (!novoIdVeiculo.isEmpty()) {
//            movimento.setIdVeiculo(Long.parseLong(novoIdVeiculo));
//        }
//
//        System.out.println("Digite o novo ID do funcionário (ou pressione Enter para manter o atual: " + movimento.getIdFuncionario() + "):");
//        String novoIdFuncionario = sc.nextLine();
//        if (!novoIdFuncionario.isEmpty()) {
//            movimento.setIdFuncionario(Long.parseLong(novoIdFuncionario));
//        }
//
//        System.out.println("Digite a nova descrição (ou pressione Enter para manter a atual: " + movimento.getDescricao() + "):");
//        String novaDescricao = sc.nextLine();
//        if (!novaDescricao.isEmpty()) {
//            movimento.setDescricao(novaDescricao);
//        }
//
//        System.out.println("Digite a nova data (ou pressione Enter para manter a atual: " + movimento.getData() + "):");
//        String novaData = sc.nextLine();
//        if (!novaData.isEmpty()) {
//            movimento.setData(novaData);
//        }
//
//        movimentoController.updateMovimento(movimento);
//        System.out.println("Movimento atualizado com sucesso.");
    }

    private static void criarNovoMovimento() {
//        System.out.println("Digite o ID do veículo:");
//        long idVeiculo = sc.nextLong();
//
//        System.out.println("Digite o ID do funcionário:");
//        long idFuncionario = sc.nextLong();
//
//        sc.nextLine(); // Limpa o buffer
//
//        System.out.println("Digite a descrição do movimento:");
//        String descricao = sc.nextLine();
//
//        System.out.println("Digite a data do movimento:");
//        String data = sc.nextLine();
//
//        Movimento novoMovimento = new Movimento();
//        novoMovimento.setIdVeiculo(idVeiculo);
//        novoMovimento.setIdFuncionario(idFuncionario);
//        novoMovimento.setDescricao(descricao);
//        novoMovimento.setData(data);
//
//        Movimento criadoMovimento = movimentoController.createMovimento(novoMovimento);
//
//        if (criadoMovimento != null) {
//            System.out.println("Novo movimento criado com sucesso.");
//            System.out.println("ID: " + criadoMovimento.getId());
//            System.out.println("ID do Veículo: " + criadoMovimento.getIdVeiculo());
//            System.out.println("ID do Funcionário: " + criadoMovimento.getIdFuncionario());
//            System.out.println("Descrição: " + criadoMovimento.getDescricao());
//            System.out.println("Data: " + criadoMovimento.getData());
//        } else {
//            System.out.println("Falha ao criar novo movimento.");
//        }
    }

    private static void aguardarEnter() {
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();
    }
}
