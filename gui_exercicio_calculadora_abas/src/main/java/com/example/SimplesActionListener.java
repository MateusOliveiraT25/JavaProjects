package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplesActionListener implements ActionListener {
    private double valorAtual = 0; // Inicializa com 0 para evitar erros
    private String operadorAtual = ""; // Inicializa vazio
    private CalculadoraSimples calculadoraSimples;
    private boolean novoNumero = true; // Para limpar o display antes do próximo número

    public SimplesActionListener(CalculadoraSimples calculadora) {
        this.calculadoraSimples = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String displayAtual = calculadoraSimples.getDisplaySimples().getText();

        // Se o comando é um número (0-9)
        if (comando.matches("\\d")) {
            if (novoNumero) {
                calculadoraSimples.setDisplaySimples(comando); // Inicia um novo número
                novoNumero = false;
            } else {
                calculadoraSimples.setDisplaySimples(displayAtual + comando);
            }
        }
        // Se o comando é um operador (+, -, *, /)
        else if (comando.matches("[+\\-*/]")) {
            operadorAtual = comando; // Armazena o operador
            valorAtual = Double.parseDouble(displayAtual); // Armazena o valor do display
            novoNumero = true; // Prepara para o próximo número
        } 
        // Se o comando é "C", limpa o display
        else if (comando.equals("C")) {
            calculadoraSimples.setDisplaySimples("");
            valorAtual = 0; // Reseta o valor atual
            operadorAtual = ""; // Reseta o operador
            novoNumero = true; // Prepara para um novo número
        }
        // Se o comando é "="
        else if (comando.equals("=")) {
            double valorSegundo;
            try {
                valorSegundo = Double.parseDouble(displayAtual); // Obtém o segundo valor
            } catch (NumberFormatException ex) {
                calculadoraSimples.setDisplaySimples("Erro"); // Se não for um número válido
                return;
            }

            double resultado = calcularResultado(valorSegundo);
            calculadoraSimples.setDisplaySimples(String.valueOf(resultado));
            novoNumero = true; // Prepara para uma nova operação
        }
    }

    // Método para calcular o resultado da operação
    private double calcularResultado(double valorSegundo) {
        switch (operadorAtual) {
            case "+":
                return valorAtual + valorSegundo;
            case "-":
                return valorAtual - valorSegundo;
            case "*":
                return valorAtual * valorSegundo;
            case "/":
                if (valorSegundo != 0) {
                    return valorAtual / valorSegundo;
                } else {
                    calculadoraSimples.setDisplaySimples("Erro"); // Tratamento de divisão por zero
                    return 0;
                }
            default:
                return valorSegundo; // Se nenhum operador foi definido, retorna o segundo valor
        }
    }
}
