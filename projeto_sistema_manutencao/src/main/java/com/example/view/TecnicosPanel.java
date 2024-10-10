package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;

    public TecnicosPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        tecnicoController = new TecnicoController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        tecnicoTable = new JTable(tableModel);

        // Preenchendo a tabela com os técnicos do controlador
        List<Tecnico> tecnicos = tecnicoController.readTecnicos(); // Supondo que o método readTecnicos retorna uma lista de Tecnico
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[] {
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tecnicoTable); // Aqui adiciona a JTable ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Aqui você pode adicionar as ActionListeners para os botões
        // Por exemplo: 
        // btnCadastrarTecnico.addActionListener(e -> {/* Ação de cadastro */});
        // btnSalvarAlteracoes.addActionListener(e -> {/* Ação de salvar */});
    }
}
