package com.mateus;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciamentoFuncionarios {
    private ArrayList<Funcionario> funcionarios;

    public GerenciamentoFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado.");
            return;
        }
        StringBuilder lista = new StringBuilder("Funcionários cadastrados:\n");
        for (Funcionario funcionario : funcionarios) {
            lista.append(funcionario).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public double calcularMediaSalarial() {
        if (funcionarios.isEmpty()) return 0;
        double somaSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            somaSalarios += funcionario.getSalario();
        }
        return somaSalarios / funcionarios.size();
    }

    public void removerFuncionario(String nome) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(i);
                JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
    }
}
