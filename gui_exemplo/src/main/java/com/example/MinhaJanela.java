package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JFrame {
    public MinhaJanela() {
        super("Minha Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        
        // Criando um painel
        JPanel painel = new JPanel();
        this.add(painel);
        
        // Adicionando um botão
        JButton botao = new JButton("Clique aqui");
        painel.add(botao); // Adicionando o botão ao painel

        // Adiciona um evento ao botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe uma mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(null, "Botão clicado!"); // Mensagem correta
            }
        });

        // Exibindo a janela
        this.setVisible(true);
    }

}
