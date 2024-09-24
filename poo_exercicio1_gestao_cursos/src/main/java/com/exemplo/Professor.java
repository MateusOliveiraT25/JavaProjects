package com.exemplo;

import lombok.Getter;
import lombok.Setter;

// Anotação Lombok para gerar automaticamente os métodos getter e setter
@Getter
@Setter
public class Professor extends Pessoa {
    // Atributo para armazenar o salário do professor
    private double salario;

    // Construtor que recebe o nome, CPF e salário do professor
    public Professor(String nome, String cpf, double salario) {
        super(nome, cpf); // Chama o construtor da classe pai (Pessoa)
        this.salario = salario; // Inicializa o salário
    }

    // Método sobrescrito para exibir informações do professor
    @Override
    public String exibirInfo() {
        // Retorna as informações da classe pai e adiciona o salário
        return super.exibirInfo() + " | Salário: " + salario;
    }
}
