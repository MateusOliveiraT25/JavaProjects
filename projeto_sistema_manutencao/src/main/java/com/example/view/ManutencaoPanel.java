package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    private ManutencaoController manutencaoController;
    private JTable manutencoesTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;
    private JButton btnGerarRelatorio;

    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[] {
            "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desabilita a edição direta na tabela
            }
        };

        manutencoesTable = new JTable(tableModel);
        
        List<Manutencao> manutencoes = manutencaoController.readManutencoes();
        for (Manutencao manutencao : manutencoes) {
            tableModel.addRow(new Object[] {
                manutencao.getId(),
                manutencao.getMaquinaId(),
                manutencao.getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), // Formata LocalDate
                manutencao.getTipo(),
                manutencao.getPecasTrocadas(),
                manutencao.getTempoDeParada(),
                manutencao.getTecnicoId(),
                manutencao.getObservacoes()
            });
        }

        JScrollPane scrollPane = new JScrollPane(manutencoesTable);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        btnGerarRelatorio = new JButton("Gerar Relatório");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnGerarRelatorio);
        this.add(painelInferior, BorderLayout.SOUTH);

        addActionListeners();
        addDoubleClickListener();
    }

    private void addActionListeners() {
        btnCadastrarManutencao.addActionListener(e -> {
            JDialog dialog = new JDialog((JDialog) null, "Cadastrar Nova Manutenção", true);
            dialog.setSize(400, 400);
            dialog.setLayout(new GridLayout(0, 2));

            JTextField txtMaquinaId = new JTextField();
            JTextField txtData = new JTextField(); // Formato "yyyy-MM-dd"
            JTextField txtTipo = new JTextField();
            JTextField txtPecasTrocadas = new JTextField();
            JTextField txtTempoDeParada = new JTextField();
            JTextField txtTecnicoId = new JTextField();
            JTextField txtObservacoes = new JTextField();

            dialog.add(new JLabel("Máquina ID:"));
            dialog.add(txtMaquinaId);
            dialog.add(new JLabel("Data (yyyy-MM-dd):"));
            dialog.add(txtData);
            dialog.add(new JLabel("Tipo:"));
            dialog.add(txtTipo);
            dialog.add(new JLabel("Peças Trocadas:"));
            dialog.add(txtPecasTrocadas);
            dialog.add(new JLabel("Tempo de Parada:"));
            dialog.add(txtTempoDeParada);
            dialog.add(new JLabel("Técnico ID:"));
            dialog.add(txtTecnicoId);
            dialog.add(new JLabel("Observações:"));
            dialog.add(txtObservacoes);

            JButton btnSubmit = new JButton("Cadastrar");
            dialog.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                try {
                    String maquinaId = txtMaquinaId.getText();
                    LocalDate data = LocalDate.parse(txtData.getText());
                    String tipo = txtTipo.getText();
                    String pecasTrocadas = txtPecasTrocadas.getText();
                    int tempoDeParada = Integer.parseInt(txtTempoDeParada.getText());
                    String tecnicoId = txtTecnicoId.getText();
                    String observacoes = txtObservacoes.getText();

                    Manutencao novaManutencao = new Manutencao(null, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
                    Manutencao manutencaoCriada = manutencaoController.createManutencao(novaManutencao);

                    if (manutencaoCriada != null) {
                        tableModel.addRow(new Object[] {
                            manutencaoCriada.getId(), maquinaId, data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes
                        });
                        JOptionPane.showMessageDialog(dialog, "Manutenção cadastrada com sucesso!");
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar manutenção.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                }
            });

            dialog.setVisible(true);
        });

        btnSalvarAlteracoes.addActionListener(e -> {
            int selectedRow = manutencoesTable.getSelectedRow();
            if (selectedRow != -1) {
                editarManutencao(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha para editar.");
            }
        });

        btnGerarRelatorio.addActionListener(e -> {
            gerarRelatorioDeManutencoes();
        });
    }

    private void addDoubleClickListener() {
        manutencoesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) { // Verifica se é um clique duplo
                    int selectedRow = manutencoesTable.getSelectedRow();
                    if (selectedRow != -1) {
                        editarManutencao(selectedRow);
                    }
                }
            }
        });
    }

    private void editarManutencao(int selectedRow) {
        JDialog dialog = new JDialog((JDialog) null, "Editar Manutenção", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(0, 2));

        String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
        String maquinaId = (String) tableModel.getValueAt(selectedRow, 1);
        LocalDate data = LocalDate.parse((String) tableModel.getValueAt(selectedRow, 2)); // Converte String para LocalDate
        String tipo = (String) tableModel.getValueAt(selectedRow, 3);
        String pecasTrocadas = (String) tableModel.getValueAt(selectedRow, 4);
        int tempoDeParada = Integer.parseInt(tableModel.getValueAt(selectedRow, 5).toString());
        String tecnicoId = (String) tableModel.getValueAt(selectedRow, 6);
        String observacoes = (String) tableModel.getValueAt(selectedRow, 7);

        JTextField txtMaquinaId = new JTextField(maquinaId);
        JTextField txtData = new JTextField(data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        JTextField txtTipo = new JTextField(tipo);
        JTextField txtPecasTrocadas = new JTextField(pecasTrocadas);
        JTextField txtTempoDeParada = new JTextField(String.valueOf(tempoDeParada));
        JTextField txtTecnicoId = new JTextField(tecnicoId);
        JTextField txtObservacoes = new JTextField(observacoes);

        dialog.add(new JLabel("Máquina ID:"));
        dialog.add(txtMaquinaId);
        dialog.add(new JLabel("Data (yyyy-MM-dd):"));
        dialog.add(txtData);
        dialog.add(new JLabel("Tipo:"));
        dialog.add(txtTipo);
        dialog.add(new JLabel("Peças Trocadas:"));
        dialog.add(txtPecasTrocadas);
        dialog.add(new JLabel("Tempo de Parada:"));
        dialog.add(txtTempoDeParada);
        dialog.add(new JLabel("Técnico ID:"));
        dialog.add(txtTecnicoId);
        dialog.add(new JLabel("Observações:"));
        dialog.add(txtObservacoes);

        JButton btnSubmit = new JButton("Salvar");
        dialog.add(btnSubmit);

        btnSubmit.addActionListener(ev -> {
            try {
                String newMaquinaId = txtMaquinaId.getText().trim();
                LocalDate newData = LocalDate.parse(txtData.getText().trim());
                String newTipo = txtTipo.getText().trim();
                String newPecasTrocadas = txtPecasTrocadas.getText().trim();
                int newTempoDeParada = Integer.parseInt(txtTempoDeParada.getText().trim());
                String newTecnicoId = txtTecnicoId.getText().trim();
                String newObservacoes = txtObservacoes.getText().trim();

                // Validação básica
                if (newMaquinaId.isEmpty() || newTipo.isEmpty() || newTecnicoId.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Manutencao manutencaoAtualizada = new Manutencao(id, newMaquinaId, newData, newTipo, newPecasTrocadas, newTempoDeParada, newTecnicoId, newObservacoes);
                manutencaoController.updateManutencao(manutencaoAtualizada);

                // Atualiza a tabela
                tableModel.setValueAt(newMaquinaId, selectedRow, 1);
                tableModel.setValueAt(newData.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), selectedRow, 2); // Formata para String
                tableModel.setValueAt(newTipo, selectedRow, 3);
                tableModel.setValueAt(newPecasTrocadas, selectedRow, 4);
                tableModel.setValueAt(newTempoDeParada, selectedRow, 5);
                tableModel.setValueAt(newTecnicoId, selectedRow, 6);
                tableModel.setValueAt(newObservacoes, selectedRow, 7);

                JOptionPane.showMessageDialog(dialog, "Alterações salvas com sucesso!");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Erro ao salvar alterações: " + ex.getMessage());
            }
        });

        dialog.setVisible(true);
    }

    private void gerarRelatorioDeManutencoes() {
        String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String horaAtual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        
        File pastaRelatorio = new File("relatorio");
        if (!pastaRelatorio.exists()) {
            pastaRelatorio.mkdir(); // Cria a pasta
        }
        
        File file = new File(pastaRelatorio, "relatorio_manutencao_" + dataAtual + "_" + horaAtual + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Relatório de Manutenções\n");
            writer.write("------------------------\n");

            int totalTempoDeParada = 0;

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                writer.write("ID: " + tableModel.getValueAt(i, 0) + "\n");
                writer.write("Máquina ID: " + tableModel.getValueAt(i, 1) + "\n");
                writer.write("Data: " + tableModel.getValueAt(i, 2) + "\n");
                writer.write("Tipo: " + tableModel.getValueAt(i, 3) + "\n");
                int tempoDeParada = Integer.parseInt(tableModel.getValueAt(i, 5).toString());
                writer.write("Tempo de Parada: " + tempoDeParada + " horas\n");
                writer.write("Técnico ID: " + tableModel.getValueAt(i, 6) + "\n");
                writer.write("Observações: " + tableModel.getValueAt(i, 7) + "\n");
                writer.write("------------------------\n");
                totalTempoDeParada += tempoDeParada;
            }

            writer.write("Total de Tempo de Inatividade: " + totalTempoDeParada + " horas\n");

            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso: " + file.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
