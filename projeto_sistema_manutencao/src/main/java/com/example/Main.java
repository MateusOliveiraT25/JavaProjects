package com.example;

import javax.swing.SwingUtilities;

import com.example.view.SistemaManutencaoGUI;

public class Main {
    public static void main(String[] args) {
        // Usando SwingUtilities para rodar a GUI na thread de evento
        SwingUtilities.invokeLater(() -> {
            SistemaManutencaoGUI sistemaManutencaoGUI = new SistemaManutencaoGUI();
            sistemaManutencaoGUI.setVisible(true);  // Torna a GUI visível
        });
    }
}
