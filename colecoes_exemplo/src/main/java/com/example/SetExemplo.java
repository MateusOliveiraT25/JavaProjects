package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    // Construtor inicializando o HashSet
    public SetExemplo() {
        nomes = new HashSet<>();
    }

    // Método para adicionar um nome ao set
    public void adicionarNome(String nome) {
        boolean adicionado = nomes.add(nome); // Tenta adicionar o nome
        if (adicionado) {
            System.out.println("Nome adicionado com sucesso: " + nome);
        } else {
            System.out.println("O nome já existe no conjunto: " + nome);
        }
    }

    // Método para listar todos os nomes no set
    public void listarNomes() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    // Método para deletar um nome do set
    public void deletarNome(String nome) {
        if (nomes.remove(nome)) {
            System.out.println("Nome removido com sucesso: " + nome);
        } else {
            System.out.println("Nome não encontrado: " + nome);
        }
    }

    // Método para modificar um nome no set (não é possível alterar diretamente via índice)
    // A lógica é remover o nome antigo e adicionar o novo
    public void modificarNome(String nomeAntigo, String nomeNovo) {
        if (nomes.remove(nomeAntigo)) {
            nomes.add(nomeNovo);
            System.out.println("Nome " + nomeAntigo + " alterado para " + nomeNovo);
        } else {
            System.out.println("Nome não encontrado: " + nomeAntigo);
        }
    }
}
