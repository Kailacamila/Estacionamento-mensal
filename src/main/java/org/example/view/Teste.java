package org.example.view;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vind@");
        System.out.println("1-marca");
        System.out.println("0-sair");

        boolean rodar = true;
        while (rodar){
            System.out.println("Escolha uma opção");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o id");
                    ExibirDados.ShowMarcaById();


                    break;
                case 0:{
                    rodar=false;
                }

            }

        }
    }
}


// testa pode ser no main
