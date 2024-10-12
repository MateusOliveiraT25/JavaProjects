package com.example.controllers;

import com.example.api.FalhaApi;
import com.example.api.ManutencaoApi;
import com.example.api.MaquinaApi;
import com.example.models.Falha;
import com.example.models.Manutencao;
import com.example.models.Maquina;

import java.util.ArrayList;
import java.util.List;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = new ArrayList<>();
    }

    // Método para criar uma nova falha
    public Falha createFalha(Falha falha) {
         Falha novaFalha = FalhaApi.createFalha(falha);
         if (novaFalha != null) {
            // Atualiza a lista de máquinas após criar uma nova
            readFalhas();
        }
        return novaFalha; // Retorna o objeto Maquina criado
    }

// Método para obter a lista de falhas e armazenar na lista local
public List<Falha> readFalhas() {
    List<Falha> falhas = FalhaApi.getFalhas();
    return falhas; 
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
