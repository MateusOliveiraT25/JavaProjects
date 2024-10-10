package com.example.controllers;

import com.example.api.FalhaApi;
import com.example.models.Falha;

import java.util.ArrayList;
import java.util.List;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = new ArrayList<>();
    }

    // Método para criar uma nova falha
    public String createFalha(Falha falha) {
        String response = FalhaApi.createFalha(falha);
        if (response != null) {
            // Opcionalmente, atualize a lista de falhas após criar uma nova
            readFalhas();
        }
        return response; // Retorna a resposta da API
    }

    // Método para obter a lista de falhas e armazenar na lista local
    public void readFalhas() {
        falhas = FalhaApi.getFalhas();
    }

    // Método para atualizar uma falha existente
    public String updateFalha(Falha falha) {
        String response = FalhaApi.updateFalha(falha);
        if (response != null) {
            // Atualiza a lista de falhas após a modificação
            readFalhas();
        }
        return response;
    }

    // Método para deletar uma falha pelo ID
    public String deleteFalha(String id) {
        String response = FalhaApi.deleteFalha(id);
        if (response != null) {
            // Atualiza a lista de falhas após a exclusão
            readFalhas();
        }
        return response;
    }

    // Método para obter a lista de falhas (pode ser usado para outros propósitos)
    public List<Falha> getFalhas() {
        return falhas;
    }
}
