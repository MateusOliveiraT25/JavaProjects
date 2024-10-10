package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
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
import javax.swing.table.DefaultTableModel;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;
import com.example.models.Maquina;

public class ManutencaoPanel extends JPanel {
    // Atributos
    private ManutencaoController manutencaoController;
    private JTable manutencoesTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;

    public ManutencaoPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        manutencaoController = new ManutencaoController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        manutencoesTable = new JTable(tableModel);

        // Preenchendo a tabela com as manutenções do controlador
        List<Manutencao> manutencoes = manutencaoController.readManutencoes();
        for (Manutencao manutencao : manutencoes) {
            tableModel.addRow(new Object[] {
                    manutencao.getId(),
                    manutencao.getMaquinaId(),
                    manutencao.getData(),
                    manutencao.getTipo(),
                    manutencao.getPecasTrocadas(),
                    manutencao.getTempoDeParada(),
                    manutencao.getTecnicoId(),
                    manutencao.getObservacoes()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(manutencoesTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Adicionando ActionListeners para os botões
        addActionListeners();
    }

    private void addActionListeners() {
        // ActionListener para o botão "Cadastrar"
        btnCadastrarManutencao.addActionListener(e -> {
            // Cria um novo JDialog para o cadastro de manutenção
            JDialog dialog = new JDialog((JDialog) null, "Cadastrar Nova Manutenção", true);
            dialog.setSize(400, 400);
            dialog.setLayout(new GridLayout(0, 2));

            // Adiciona campos de texto para os atributos da manutenção
            JTextField txtMaquinaId = new JTextField();
            JTextField txtData = new JTextField(); // Sugere formato "yyyy-MM-dd"
            JTextField txtTipo = new JTextField();
            JTextField txtPecasTrocadas = new JTextField();
            JTextField txtTempoDeParada = new JTextField();
            JTextField txtTecnicoId = new JTextField();
            JTextField txtObservacoes = new JTextField();

            // Adiciona rótulos e campos ao dialog
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

            // Botão para cadastrar a manutenção
            JButton btnSubmit = new JButton("Cadastrar");
            dialog.add(btnSubmit);

            // Quando o botão for clicado, valida e envia os dados
            btnSubmit.addActionListener(ev -> {
                try {
                    // Recupera os dados dos campos de texto
                    String maquinaId = txtMaquinaId.getText();
                    LocalDate data = LocalDate.parse(txtData.getText()); // Valida data
                    String tipo = txtTipo.getText();
                    String pecasTrocadas = txtPecasTrocadas.getText();
                    int tempoDeParada = Integer.parseInt(txtTempoDeParada.getText());
                    String tecnicoId = txtTecnicoId.getText();
                    String observacoes = txtObservacoes.getText();

                    // Cria um novo objeto Manutencao
                    Manutencao novaManutencao = new Manutencao(null, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);

                    // Envia para a API
                    Manutencao manutencaoCriada = manutencaoController.createManutencao(novaManutencao);

                    // Se a manutenção criada não for nula, atualiza a tabela e fecha o diálogo
                    if (manutencaoCriada != null) {
                        tableModel.addRow(new Object[]{
                                manutencaoCriada.getId(), // Assume que o ID é retornado na criação
                                maquinaId, data,
                                tipo, pecasTrocadas, tempoDeParada,
                                tecnicoId, observacoes
                        });
                        JOptionPane.showMessageDialog(dialog, "Manutenção cadastrada com sucesso!");
                        dialog.dispose(); // Fecha o diálogo
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar manutenção.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                }
            });

            // Mostra o formulário
            dialog.setVisible(true);
        });
// ActionListener para o botão "Salvar Manutenção"
btnSalvarAlteracoes.addActionListener(e -> {
    // Verifica se uma linha está selecionada
    int selectedRow = manutencoesTable.getSelectedRow();
    if (selectedRow != -1) {
        // Cria um novo JDialog para editar a manutenção
        JDialog dialog = new JDialog((JDialog) null, "Editar Manutenção", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(0, 2));

        // Pega os valores da linha selecionada
        String id = String.valueOf(tableModel.getValueAt(selectedRow, 0)); // ID da manutenção
        String maquinaId = (String) tableModel.getValueAt(selectedRow, 1);
        LocalDate data = (LocalDate) tableModel.getValueAt(selectedRow, 2); // Obtém o LocalDate diretamente
        String tipo = (String) tableModel.getValueAt(selectedRow, 3);
        String pecasTrocadas = (String) tableModel.getValueAt(selectedRow, 4);
        int tempoDeParada = Integer.parseInt(tableModel.getValueAt(selectedRow, 5).toString());
        String tecnicoId = (String) tableModel.getValueAt(selectedRow, 6);
        String observacoes = (String) tableModel.getValueAt(selectedRow, 7);

        // Adiciona campos de texto para os atributos da manutenção
        JTextField txtMaquinaId = new JTextField(maquinaId);
        JTextField txtData = new JTextField(data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); // Formata a data
        JTextField txtTipo = new JTextField(tipo);
        JTextField txtPecasTrocadas = new JTextField(pecasTrocadas);
        JTextField txtTempoDeParada = new JTextField(String.valueOf(tempoDeParada));
        JTextField txtTecnicoId = new JTextField(tecnicoId);
        JTextField txtObservacoes = new JTextField(observacoes);

        // Adiciona rótulos e campos ao dialog
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

        // Botão para salvar as alterações
        JButton btnSubmit = new JButton("Salvar");
        dialog.add(btnSubmit);

        // Quando o botão "Salvar" for clicado, valida e envia os dados
        btnSubmit.addActionListener(ev -> {
            try {
                // Recupera os dados dos campos de texto
                String newMaquinaId = txtMaquinaId.getText();
                LocalDate newData = LocalDate.parse(txtData.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Validação de formato
                String newTipo = txtTipo.getText();
                String newPecasTrocadas = txtPecasTrocadas.getText();
                int newTempoDeParada = Integer.parseInt(txtTempoDeParada.getText());
                String newTecnicoId = txtTecnicoId.getText();
                String newObservacoes = txtObservacoes.getText();

                // Atualiza os dados da manutenção
                Manutencao manutencaoAtualizada = new Manutencao(id, newMaquinaId, newData, newTipo,
                        newPecasTrocadas, newTempoDeParada, newTecnicoId, newObservacoes);

                // Envia para a API para atualizar a manutenção
                manutencaoController.updateManutencao(manutencaoAtualizada); // Supondo que esse método não retorne nada

                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(dialog, "Alterações salvas com sucesso!");

                // Atualiza a tabela para refletir as mudanças
                tableModel.setValueAt(newMaquinaId, selectedRow, 1);
                tableModel.setValueAt(newData.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), selectedRow, 2); // Formata para String
                tableModel.setValueAt(newTipo, selectedRow, 3);
                tableModel.setValueAt(newPecasTrocadas, selectedRow, 4);
                tableModel.setValueAt(newTempoDeParada, selectedRow, 5);
                tableModel.setValueAt(newTecnicoId, selectedRow, 6);
                tableModel.setValueAt(newObservacoes, selectedRow, 7);

                dialog.dispose(); // Fecha o diálogo
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
            }
        });

        // Exibe o diálogo
        dialog.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha para editar.");
    }
});


    }
}
