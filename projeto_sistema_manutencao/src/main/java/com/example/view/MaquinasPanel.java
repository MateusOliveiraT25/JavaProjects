package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    public MaquinasPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        maquinaController = new MaquinaController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID",  "Nome", "Modelo", "Fabricante", "Detalhes","Localizacao","Tempo Vida Estimado"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        maquinasTable = new JTable(tableModel);

        // Preenchendo a tabela com as máquinas do controlador
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[] {
                    maquina.getId(),
                    maquina.getNome(),
                    maquina.getModelo(),
                    maquina.getFabricante(),
                    maquina.getDetalhes(),
                    maquina.getLocalizacao(),
                    maquina.getTempoVidaEstimado()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(maquinasTable); // Aqui adiciona a JTable ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Aqui você pode adicionar as ActionListeners para os botões
        // Por exemplo: 
        // btnCadastrarMaquina.addActionListener(e -> {/* Ação de cadastro */});
        // btnSalvarAlteracoes.addActionListener(e -> {/* Ação de salvar */});
    }
}
