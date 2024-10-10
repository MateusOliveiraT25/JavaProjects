package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController; // Certifique-se de que o controlador está implementado
import com.example.models.Falha; // Certifique-se de que a model está implementada

public class FalhasPanel extends JPanel {
    // Atributos
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;

    public FalhasPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        falhaController = new FalhaController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        falhasTable = new JTable(tableModel);

        // Preenchendo a tabela com as falhas do controlador
        List<Falha> falhas = falhaController.readFalhas(); // Supondo que o método readFalhas retorna uma lista de Falha
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[] {
                    falha.getId(),
                    falha.getMaquinaId(),
                    falha.getData(), // Assumindo que o método getData retorna uma String ou um LocalDate formatado
                    falha.getProblema(),
                    falha.getPrioridade(),
                    falha.getOperador()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(falhasTable); // Aqui adiciona a JTable ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Aqui você pode adicionar as ActionListeners para os botões
        // Por exemplo: 
        // btnCadastrarFalha.addActionListener(e -> {/* Ação de cadastro */});
        // btnSalvarAlteracoes.addActionListener(e -> {/* Ação de salvar */});
    }
}
