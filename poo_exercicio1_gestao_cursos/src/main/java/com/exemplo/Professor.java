package com.exemplo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Pessoa {
    // Atributo
    private double salario;

    // Construtor
    public Professor(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    // Método para exibir informações
    @Override
    public String exibirInfo() {
        return super.exibirInfo() + " | Salário: " + salario;
    }
}
