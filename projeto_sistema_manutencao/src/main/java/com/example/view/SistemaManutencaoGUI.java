package com.example.view;

import javax.swing.*;
import java.awt.*;

public class SistemaManutencaoGUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel painelMaquinas;
    private JPanel painelManutencao;
    private JPanel painelFalhas;
    private JPanel painelTecnicos;

    public SistemaManutencaoGUI() {
        super("Sistema de Manutenção");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Inicia os painéis
        painelMaquinas = new MaquinasPanel();
        painelManutencao = new ManutencaoPanel();
        painelFalhas = new FalhasPanel();
        painelTecnicos = new TecnicosPanel();

        // Define cores de fundo dos painéis
        painelMaquinas.setBackground(new Color(50, 50, 50)); // Cinza escuro
        painelManutencao.setBackground(new Color(70, 70, 70)); // Cinza médio
        painelFalhas.setBackground(new Color(60, 60, 60)); // Cinza escuro
        painelTecnicos.setBackground(new Color(80, 80, 80)); // Cinza claro

        // Criar meu tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(45, 45, 45)); // Cor de fundo do JTabbedPane
        tabbedPane.setForeground(Color.WHITE); // Cor do texto
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14)); // Fonte

        // Adiciona painéis ao tabbed pane
        tabbedPane.add("Máquinas", painelMaquinas);
        tabbedPane.add("Manutenções", painelManutencao);
        tabbedPane.add("Falhas", painelFalhas);
        tabbedPane.add("Técnicos", painelTecnicos);

        this.add(tabbedPane, BorderLayout.CENTER);
    }

}
