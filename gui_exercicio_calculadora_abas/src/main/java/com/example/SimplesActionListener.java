package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplesActionListener implements ActionListener {
    private double valorAtual = 0;
    private String operadorAtual = "";
    private CalculadoraSimples calculadoraSimples;
    private boolean novoNumero = true;

    public SimplesActionListener(CalculadoraSimples calculadora) {
        this.calculadoraSimples = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String displayAtual = calculadoraSimples.getDisplaySimples().getText();

        if (comando.matches("\\d")) { // Se for um número
            if (novoNumero) {
                calculadoraSimples.setDisplaySimples(comando); // Inicia novo número
                novoNumero = false;
            } else {
                calculadoraSimples.setDisplaySimples(displayAtual + comando); // Continua número
            }
        } else if (comando.matches("[+\\-*/]")) { // Se for um operador
            operadorAtual = comando;
            valorAtual = Double.parseDouble(displayAtual);
            novoNumero = true;
        } else if (comando.equals("C")) { // Se for 'C' (limpar)
            limparDisplay();
        } else if (comando.equals("=")) { // Se for '=' (calcular)
            double valorSegundo;
            try {
                valorSegundo = Double.parseDouble(displayAtual);
            } catch (NumberFormatException ex) {
                calculadoraSimples.setDisplaySimples("Erro");
                return;
            }

            double resultado = calcularResultado(valorSegundo);
            calculadoraSimples.setDisplaySimples(String.valueOf(resultado));
            novoNumero = true;
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
                    calculadoraSimples.setDisplaySimples("Erro");
                    return 0;
                }
            default:
                return valorSegundo;
        }
    }

    private void limparDisplay() {
        calculadoraSimples.setDisplaySimples("");
        valorAtual = 0;
        operadorAtual = "";
        novoNumero = true;
    }
}
