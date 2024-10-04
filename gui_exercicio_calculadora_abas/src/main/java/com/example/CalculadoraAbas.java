package com.example;

import javax.swing.*;

public class CalculadoraAbas extends JFrame {
    // Construtor
    public CalculadoraAbas() {
        // Configurações básicas da janela
        super("Calculadora Abas");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        // Adiciona componentes
        JTabbedPane abas = new JTabbedPane();

        // Instancia a calculadora simples
        CalculadoraSimples calculadoraSimples = new CalculadoraSimples();
        abas.addTab("Simples", calculadoraSimples);

        // Painel para calculadora avançada
        JPanel CalculadoraAvancada = new CalculadoraAvancada();
        abas.addTab("Avançado", CalculadoraAvancada);

        // Adiciona as abas ao frame
        this.add(abas);
        this.setVisible(true);
    }

  
}
