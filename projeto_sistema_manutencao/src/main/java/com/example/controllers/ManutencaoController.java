package com.example.controllers;

import com.example.api.ManutencaoApi;
import com.example.models.Manutencao;

import java.util.List;

public class ManutencaoController {
    // Atributo para armazenar a lista de manutenções
    private List<Manutencao> manutencoes;

    // Construtor que inicializa a lista de manutenções
    public ManutencaoController() {
        // Inicializa a lista de manutenções ao carregar
        manutencoes = readManutencoes();
    }

    // Método para criar uma nova manutenção
    public Manutencao createManutencao(Manutencao manutencao) {
        // Chama a API para criar a manutenção e armazena a resposta
        Manutencao novaManutencao = ManutencaoApi.createManutencao(manutencao);
        if (novaManutencao != null) {
            // Atualiza a lista de manutenções após criar uma nova
            manutencoes = readManutencoes();
        }
        return novaManutencao; // Retorna a nova manutenção criada
    }

    // Método para ler todas as manutenções
    public List<Manutencao> readManutencoes() {
        // Chama o método getManutencoes da ManutencaoApi e armazena o resultado
        manutencoes = ManutencaoApi.getManutencoes();
        return manutencoes; // Retorna a lista de manutenções
    }

    // Método para obter a lista de manutenções
    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    // Método para atualizar uma manutenção existente
    public boolean updateManutencao(Manutencao manutencao) {
        // Chama o método de atualização na API
        boolean success = ManutencaoApi.updateManutencao(manutencao);
        if (success) {
            // Atualiza a lista de manutenções após a atualização
            manutencoes = readManutencoes(); // Certifique-se de que readManutencoes retorna a lista atualizada
        }
        return success; // Retorna true se a atualização foi bem-sucedida
    }

    // Método para deletar uma manutenção pelo ID
    public boolean deleteManutencao(String id) {
        // Chama a API para deletar a manutenção e armazena o resultado
        boolean success = ManutencaoApi.deleteManutencao(id);
        if (success) {
            // Atualiza a lista de manutenções após a exclusão
            manutencoes = readManutencoes();
        }
        return success; // Retorna true se a exclusão foi bem-sucedida
    }
}
