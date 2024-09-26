package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<Integer, String> nomes;

    // Construtor inicializando o HashMap
    public MapExemplo() {
        nomes = new HashMap<>();
    }

    // Método para adicionar um nome ao Map, com um identificador (ID)
    public void adicionarNome(int id, String nome) {
        if (nomes.containsKey(id)) {
            System.out.println("ID " + id + " já existe com o nome: " + nomes.get(id));
        } else {
            nomes.put(id, nome);
            System.out.println("Nome adicionado: " + nome + " com ID: " + id);
        }
    }

    // Método para listar todos os nomes no Map
    public void listarNomes() {
        for (Map.Entry<Integer, String> entry : nomes.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - Nome: " + entry.getValue());
        }
    }

    // Método para deletar um nome pelo ID no Map
    public void deletarNome(int id) {
        if (nomes.containsKey(id)) {
            nomes.remove(id);
            System.out.println("Nome com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("ID " + id + " não encontrado.");
        }
    }

    // Método para modificar um nome pelo ID
    public void modificarNome(int id, String novoNome) {
        if (nomes.containsKey(id)) {
            String nomeAnterior = nomes.get(id);
            nomes.put(id, novoNome);
            System.out.println("Nome com ID " + id + " alterado de " + nomeAnterior + " para " + novoNome);
        } else {
            System.out.println("ID " + id + " não encontrado.");
        }
    }
}
