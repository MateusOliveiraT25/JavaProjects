package com.mateus;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GerenciamentoFuncionarios gerenciamento = new GerenciamentoFuncionarios();
        int escolha;

        do {
            String menu = "\n******* Gerenciamento de Funcionários *******\n" +
                          "1 - Adicionar Funcionário\n" +
                          "2 - Listar Funcionários\n" +
                          "3 - Calcular Média Salarial\n" +
                          "4 - Remover Funcionário\n" +
                          "5 - Sair\n" +
                          "Escolha uma opção:";
            String input;

            // Loop até receber uma entrada válida
            while (true) {
                input = JOptionPane.showInputDialog(menu);

                if (input == null) {
                    // Usuário cancelou
                    return;
                }

                try {
                    escolha = Integer.parseInt(input);

                    // Verificar se a escolha está entre 1 e 5
                    if (escolha < 1 || escolha > 5) {
                        throw new IllegalArgumentException("Por favor, digite um número de 1 a 5.");
                    }
                    break; // Entrada válida, sai do loop
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, digite um número.");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

            switch (escolha) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
                    String idadeStr = JOptionPane.showInputDialog("Idade do Funcionário:");
                    String salarioStr = JOptionPane.showInputDialog("Salário do Funcionário:");

                    try {
                        int idade = Integer.parseInt(idadeStr);
                        double salario = Double.parseDouble(salarioStr);
                        Funcionario funcionario = new Funcionario(nome, idade, salario);
                        gerenciamento.adicionarFuncionario(funcionario);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para idade e salário.");
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Entrada cancelada.");
                    }
                    break;

                case 2:
                    gerenciamento.listarFuncionarios();
                    break;

                case 3:
                    double media = gerenciamento.calcularMediaSalarial();
                    if (media > 0) {
                        JOptionPane.showMessageDialog(null, String.format("Média Salarial: R$ %.2f", media));
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado para calcular a média.");
                    }
                    break;

                case 4:
                    String nomeRemover = JOptionPane.showInputDialog("Digite o nome do funcionário a ser removido:");
                    gerenciamento.removerFuncionario(nomeRemover);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    // Isso não deve ocorrer devido à verificação anterior
                    break;
            }
        } while (escolha != 5);
    }
}
