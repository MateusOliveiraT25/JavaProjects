package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class SimplesActionListener implements ActionListener {
    private double valorAtual;
    private String operadorAtual;
    private CalculadoraSimples calculadoraSimples;

    public SimplesActionListener(CalculadoraSimples calculadora) {
        this.calculadoraSimples = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // Se o comando é um número (0-9)
        if (comando.matches("\\d")) {
            // Adiciona o número ao display
            calculadoraSimples.setDisplaySimples(calculadoraSimples.getDisplaySimples().getText() + comando);
        } 
        // Se o comando é um operador (+, -, *, /)
        else if (comando.matches("[+\\-*/]")) {
            // Armazena o operador atual
            operadorAtual = comando;

            // Armazena o valor atual
            valorAtual = Double.parseDouble(calculadoraSimples.getDisplaySimples().getText());

            // Limpa o display para o próximo número
            calculadoraSimples.setDisplaySimples("");
        } 
        // Se o comando é "C", limpa o display
        else if (comando.equals("C")) {
            calculadoraSimples.setDisplaySimples("");
        } 
        // Se o comando é "="
        else if (comando.equals("=")) {
            double valorSegundo;
            try {
                valorSegundo = Double.parseDouble(calculadoraSimples.getDisplaySimples().getText());
            } catch (NumberFormatException ex) {
                calculadoraSimples.setDisplaySimples("Erro"); // Se não for um número válido
                return;
            }
            double resultado = calcularResultado(valorSegundo);
            calculadoraSimples.setDisplaySimples(String.valueOf(resultado));
        }
    }

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
                    throw new ArithmeticException("Divisão por zero");
                }
            default:
                return 0; // Para caso nenhum operador seja definido
        }
    }
}
