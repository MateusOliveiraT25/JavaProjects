package com.example;

import javax.swing.*;
import java.awt.*;

public class CalculadoraSimples extends JPanel {
    private JTextField displaySimples;
    private final String[] botoes = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "=", "+"
    };

    public CalculadoraSimples() {
        inicializarLayout();
        criarBotoes();
    }

    private void inicializarLayout() {
        setLayout(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        displaySimples.setPreferredSize(new Dimension(200, 50));
        displaySimples.setFont(new Font("Arial", Font.PLAIN, 24));
        this.add(displaySimples, BorderLayout.NORTH);
    }

    private void criarBotoes() {
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            botao.setFont(new Font("Arial", Font.PLAIN, 20)); // Fonte maior para os botões
            botao.addActionListener(new SimplesActionListener(this)); // Adiciona listener de ação
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER); // Adiciona o painel de botões ao centro
    }

    public void setDisplaySimples(String texto) {
        this.displaySimples.setText(texto);
    }

    public JTextField getDisplaySimples() {
        return displaySimples;
    }
}
