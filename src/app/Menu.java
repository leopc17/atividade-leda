package app;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import utils.GerenciadorFilmesABB;
import utils.GerenciadorFilmesFila;
import utils.GerenciadorFilmesTH;
import utils.Ordenacao;

import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final Scanner scString = new Scanner(System.in);

    public static void iniciar() {
        System.out.println("Projeto LEDA\n\nGerenciador de Filmes\n");
        System.out.println("Escolha uma das opções para criar o Gerenciador");
        System.out.println("1. Árvore Binária de Busca (BST)");
        System.out.println("2. Tabela Hash");
        System.out.println("3. Fila\n");

        int escolha1 = sc.nextInt();

        while (escolha1 != 1 && escolha1 != 2 && escolha1 != 3) {
            System.out.println("Opção inválida!\n");
            escolha1 = sc.nextInt();
        }

        GerenciadorFilmes_IF gerenciador = null;

        switch (escolha1) {
            case 1: gerenciador = new GerenciadorFilmesABB(); break;

            case 2:
                System.out.println("Digite o tamanho da Tabela Hash");
                gerenciador = new GerenciadorFilmesTH(sc.nextInt());
                break;

            case 3: gerenciador = new GerenciadorFilmesFila(); break;
        }

        int escolha2 = 0;

        while (escolha2 != 5) {
            System.out.println("Escolha uma das operações");
            System.out.println("1. Inserir");
            System.out.println("2. Buscar");
            System.out.println("3. Remover");
            System.out.println("4. Ordenar");
            System.out.println("5. Encerrar");

            escolha2 = sc.nextInt();

            while (escolha2 != 1 && escolha2 != 2 && escolha2 != 3 && escolha2 != 4 && escolha2 != 5) {
                System.out.println("Opção inválida!\n");
                escolha2 = sc.nextInt();
            }

            Filme_IF f;
            switch (escolha2) {
                case 1:
                    gerenciador.inserir(criarFilme());
                    System.out.println("Filme Criado!");
                    break;
                case 2:
                    System.out.println("Digite o id");
                    try {
                        f = gerenciador.buscar(sc.nextLong());
                        System.out.println("Filme encontrado: " + f);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Digite o id");
                    try {
                        f = gerenciador.remover(sc.nextLong());
                        System.out.println("Filme removido: " + f);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Filme_IF[] vetor = gerenciador.ordenar();
                        boolean b = Ordenacao.checaVetorOrdenado(vetor);
                        System.out.println("Vetor está ordenado: " + b);
                        System.out.println("Filme ordenados pelo ID: ");
                        for (Filme_IF filme : vetor) {
                            System.out.println(filme);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

    private static Filme_IF criarFilme() {
        System.out.println("Digite as informações do Filme");
        System.out.print("Nome ");
        String nome = scString.nextLine();
        System.out.print("Nota ");
        int nota = sc.nextInt();
        System.out.print("Ano ");
        int ano = sc.nextInt();
        System.out.print("ID ");
        long id = sc.nextLong();

        return new Filme(nome, nota, ano, id);
    }
}
