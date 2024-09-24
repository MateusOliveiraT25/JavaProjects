package com.exemplo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Lista para armazenar os cursos
        List<Curso> cursos = new ArrayList<>();
        String operacao = "0"; // Inicializa a operação

        do {
            // Exibe um menu para o usuário
            operacao = JOptionPane.showInputDialog(
                "\n -----Gerenciamento de curso-----\n"
                + "1 - Criar curso\n"
                + "2 - Adicionar professor\n"
                + "3 - Adicionar aluno\n"
                + "4 - Informações do curso\n"
                + "5 - Atribuir nota\n"
                + "6 - Resultado final\n"
                + "7 - Sair\n"
            );

            switch (operacao) {
                case "1":
                    // Opção para criar um novo curso
                    String nomeCurso = JOptionPane.showInputDialog("Informe o nome do curso");
                    cursos.add(new Curso(nomeCurso)); // Adiciona o novo curso à lista
                    break;

                case "2":
                    // Opção para adicionar um professor a um curso existente
                    String nomeCursoP = JOptionPane.showInputDialog("Informe o nome do curso");
                    for (Curso curso : cursos) {
                        // Verifica se o curso existe
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                            String nomeProf = JOptionPane.showInputDialog("Nome: ");
                            String cpfProf = JOptionPane.showInputDialog("CPF: ");
                            Double salarioProf = Double.parseDouble(JOptionPane.showInputDialog("Salário: "));
                            Professor professor = new Professor(nomeProf, cpfProf, salarioProf); // Cria um novo professor
                            curso.addProf(professor); // Adiciona o professor ao curso
                        }
                    }
                    break;

                case "3":
                    // Opção para adicionar um aluno a um curso existente
                    String nomeCursoA = JOptionPane.showInputDialog("Informe o nome do curso");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            // Verifica se o curso existe
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)) {
                                encontrado = true;
                                boolean novoAluno = true;
                                do {
                                    // Coleta informações do aluno
                                    String nomeAluno = JOptionPane.showInputDialog("Nome: ");
                                    String cpfAluno = JOptionPane.showInputDialog("CPF: ");
                                    String matriculaAluno = JOptionPane.showInputDialog("Matrícula: ");
                                    curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno)); // Adiciona o aluno ao curso
                                    
                                    // Pergunta se o usuário deseja adicionar outro aluno
                                    novoAluno = JOptionPane.showInputDialog("Inserir novo Aluno\n"
                                        + "1 - Sim\n"
                                        + "2 - Não").equals("1");
                                } while (novoAluno); // Continua enquanto o usuário quiser adicionar mais alunos
                            }
                        }
                    } catch (Exception e) {
                        // Tratamento de exceção, se necessário
                    }
                    break;

                // Outros casos podem ser implementados aqui
                default:
                    break;
            }
        } while (!operacao.equals("7")); // Continua até que o usuário escolha sair
    }
}
