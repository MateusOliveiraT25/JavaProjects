package com.example.controllers;

import com.example.api.TecnicoApi;
import com.example.models.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // Método para criar um novo técnico
    public String createTecnico(Tecnico tecnico) {
        String response = TecnicoApi.createTecnico(tecnico);
        if (response != null) {
            // Atualiza a lista de técnicos após a criação
            readTecnicos();
        }
        return response; // Retorna a resposta da API
    }

    // Método para obter a lista de técnicos e armazená-la localmente
    public void readTecnicos() {
        tecnicos = TecnicoApi.getTecnicos();
    }

    // Método para atualizar um técnico existente
    public String updateTecnico(Tecnico tecnico) {
        String response = TecnicoApi.updateTecnico(tecnico);
        if (response != null) {
            // Atualiza a lista de técnicos após a modificação
            readTecnicos();
        }
        return response;
    }

    // Método para deletar um técnico pelo ID
    public String deleteTecnico(String id) {
        String response = TecnicoApi.deleteTecnico(id);
        if (response != null) {
            // Atualiza a lista de técnicos após a exclusão
            readTecnicos();
        }
        return response;
    }

    // Método para obter a lista de técnicos (pode ser usada para outros propósitos)
    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }
}
