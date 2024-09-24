package com.exemplo;

import lombok.Getter;
import lombok.Setter;

// Anotação Lombok para gerar automaticamente os métodos getter e setter
@Getter
@Setter
public class Aluno extends Pessoa implements Avaliave {
    private String matricula; // Atributo para armazenar a matrícula do aluno
    private double nota;      // Atributo para armazenar a nota do aluno

    // Construtor que inicializa nome, CPF e matrícula do aluno
    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf); // Chama o construtor da classe pai (Pessoa)
        this.matricula = matricula; // Inicializa a matrícula
        this.nota = 0; // Inicializa a nota como 0
    }

    // Método para exibir informações do aluno
    @Override
    public String exibirInfo() {
        // Chama o método da classe pai e adiciona informações específicas do aluno
        return super.exibirInfo() + " | Matrícula: " + matricula + " | Nota: " + nota;
    }

    // Método para avaliar o desempenho do aluno
    @Override
    public String avaliarDesempenho() {
        // Retorna o status de aprovação com base na nota
        if (nota >= 7) {
            return "Aprovado"; // Aluno aprovado
        } else if (nota >= 5) {
            return "Recuperação"; // Aluno em recuperação
        } else {
            return "Reprovado"; // Aluno reprovado
        }
    }
}
