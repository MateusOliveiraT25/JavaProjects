package com.example.controllers;

import com.example.api.ManutencaoApi;
import com.example.models.Manutencao;

import java.util.ArrayList;
import java.util.List;

public class ManutencaoController {
    private List<Manutencao> manutencoes;

    // Construtor que inicializa a lista de manutenções
    public ManutencaoController() {
        manutencoes = new ArrayList<>();
    }

    // Método para criar uma nova manutenção
    public String createManutencao(Manutencao manutencao) {
        // Chama a API para criar a manutenção e armazena a resposta
        String response = ManutencaoApi.createManutencao(manutencao);
        if (response != null) {
            // Atualiza a lista de manutenções após criar uma nova
            readManutencoes();
        }
        return response; // Retorna a resposta da API
    }

  // Método para ler todas as manutenções
public List<Manutencao> readManutencoes() {
    // Chama o método getManutencoes da ManutencaoApi e armazena o resultado
    List<Manutencao> manutencoes = ManutencaoApi.getManutencoes();
    return manutencoes; // Retorna a lista de manutenções
}


    // Método para obter a lista de manutenções
    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    // Método para atualizar uma manutenção existente
    public String updateManutencao(Manutencao manutencao) {
        String response = ManutencaoApi.updateManutencao(manutencao);
        if (response != null) {
            readManutencoes(); // Atualiza a lista de manutenções após a atualização
        }
        return response;
    }

    // Método para deletar uma manutenção pelo ID
    public String deleteManutencao(String id) {
        String response = ManutencaoApi.deleteManutencao(id);
        if (response != null) {
            readManutencoes(); // Atualiza a lista de manutenções após a exclusão
        }
        return response;
    }
}
