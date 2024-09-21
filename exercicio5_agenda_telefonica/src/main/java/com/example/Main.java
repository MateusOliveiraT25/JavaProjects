package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n-------- Agenda de Contatos-------");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Buscar Contato pelo Nome");
            System.out.println("4 - Deletar Contato pelo Nome");
            System.out.println("5 - Sair");

            try {
                operacao = sc.nextInt();
                sc.nextLine(); // Limpa o buffer do scanner

                switch (operacao) {
                    case 1:
                        try {
                            System.out.println("Nome: ");
                            String nome = sc.nextLine();
                            System.out.println("Endereço: ");
                            String endereco = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Telefone: ");
                            String telefone = sc.nextLine();

                            Contato contato = new Contato(nome, email, endereco, telefone);
                            agenda.addContato(contato);
                            System.out.println("Contato adicionado com sucesso.");
                        } catch (AgendaCheiaException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar contato: " + e.getMessage());
                        }
                        break;

                    case 2:
                        agenda.listarContato();
                        break;

                    case 3:
                        try {
                            System.out.println("Digite o nome a ser buscado:");
                            String nomeBusca = sc.nextLine();
                            Contato contatoEncontrado = agenda.buscarNome(nomeBusca);
                            System.out.println("Contato encontrado: " + contatoEncontrado.toString());
                        } catch (ContatoNaoEncontrado e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                        }
                        break;

                        case 4:
                        try {
                           System.out.println("Digite o nome a ser deletado:");
                           String nomeDeletar = sc.next();
                          agenda.removerContato(nomeDeletar);
                          System.out.println("Contato deletado com sucesso: ");
                        } catch (Exception e) {
                           // TODO: handle exception
                        }

                    case 5:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Digite um número válido.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine(); // Limpa a entrada inválida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        } while (operacao != 5); // Alterado para 5 para sair corretamente

        sc.close();
    }
}
