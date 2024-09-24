package com.exemplo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

// Anotação Lombok para gerar automaticamente os métodos getter e setter
@Getter
@Setter
public class Curso {
    // Atributos do curso
    private String nomeCurso; // Nome do curso
    private ArrayList<Aluno> alunos; // Lista de alunos matriculados
    private Professor professor; // Professor responsável pelo curso

    // Construtor que inicializa o nome do curso e a lista de alunos
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.alunos = new ArrayList<>(); // Inicializa a lista de alunos
    }

    // Construtor sem parâmetros
    public Curso() {
        // TODO: Auto-generated constructor stub
    }

    // Método para adicionar um professor ao curso
    public void addProf(Professor professor) {
        this.professor = professor; // Atribui o professor ao curso
    }

    // Método para adicionar um aluno ao curso
    public void addAluno(Aluno aluno) {
        alunos.add(aluno); // Adiciona o aluno à lista de alunos
    }

    // Método para mostrar informações do curso
    public void infoCurso() {
        System.out.println("Curso: " + nomeCurso); // Exibe o nome do curso
        System.out.println("Professor: " + professor); // Exibe informações do professor
        System.out.println("Alunos Matriculados:"); // Cabeçalho para a lista de alunos
        for (Aluno aluno : alunos) {
            // Exibe nome e matrícula de cada aluno
            System.out.println("Aluno: " + aluno.getNome() + " | RA: " + aluno.getMatricula());
        }
    }

    // Método para atribuir uma nota a um aluno pelo nome
    public void atribuirNotaNome(String nomeAluno, double notaAluno) {
        for (Aluno aluno : alunos) {
            // Verifica se o aluno existe na lista
            if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                aluno.setNota(notaAluno); // Atribui a nota ao aluno
                return; // Sai do método após atribuir a nota
            }
        }
        System.out.println("Aluno não encontrado"); // Mensagem caso o aluno não seja encontrado
    }

    // Método para exibir o resultado final de todos os alunos
    public void exibirResultadoFinal() {
        for (Aluno aluno : alunos) {
            // Exibe informações do aluno e seu desempenho
            System.out.println(aluno.exibirInfo());
            System.out.println(aluno.avaliarDesempenho());
        }
    }
}
