package com.example.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        // Adiciona o ChangeListener ao tabbedPane
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                inverterCores(selectedIndex);
            }
        });

        this.add(tabbedPane, BorderLayout.CENTER);
    }

    private void inverterCores(int index) {
        // Cores originais
        Color[] coresOriginais = {
            new Color(50, 50, 50),  // Painel Máquinas
            new Color(70, 70, 70),  // Painel Manutenções
            new Color(60, 60, 60),  // Painel Falhas
            new Color(80, 80, 80)   // Painel Técnicos
        };

        // Cores invertidas
        Color[] coresInvertidas = {
            new Color(200, 200, 200), // Invertido para Painel Máquinas
            new Color(180, 180, 180), // Invertido para Painel Manutenções
            new Color(190, 190, 190), // Invertido para Painel Falhas
            new Color(170, 170, 170)  // Invertido para Painel Técnicos
        };

        // Restaura as cores originais
        painelMaquinas.setBackground(coresOriginais[0]);
        painelManutencao.setBackground(coresOriginais[1]);
        painelFalhas.setBackground(coresOriginais[2]);
        painelTecnicos.setBackground(coresOriginais[3]);

        // Inverte a cor do painel selecionado
        switch (index) {
            case 0:
                painelMaquinas.setBackground(coresInvertidas[0]);
                break;
            case 1:
                painelManutencao.setBackground(coresInvertidas[1]);
                break;
            case 2:
                painelFalhas.setBackground(coresInvertidas[2]);
                break;
            case 3:
                painelTecnicos.setBackground(coresInvertidas[3]);
                break;
        }
    }

}
