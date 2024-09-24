package com.exemplo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotação Lombok para gerar um construtor com todos os parâmetros
@AllArgsConstructor
// Anotação Lombok para gerar um construtor sem parâmetros (default)
@NoArgsConstructor
@Getter // Anotação Lombok para gerar automaticamente os métodos getter
@Setter // Anotação Lombok para gerar automaticamente os métodos setter
public class Pessoa {
    private String nome; // Atributo para armazenar o nome da pessoa
    private String cpf;  // Atributo para armazenar o CPF da pessoa

    // Método para exibir informações da pessoa
    public String exibirInfo() {
        // Retorna uma string com o nome e o CPF formatados
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}
