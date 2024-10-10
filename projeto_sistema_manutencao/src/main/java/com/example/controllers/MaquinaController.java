package com.example.controllers;

import com.example.api.MaquinaApi;
import com.example.models.Maquina; // Certifique-se de que o pacote está correto
import java.util.ArrayList;
import java.util.List;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    // Método para criar uma nova máquina
    public String createMaquina(Maquina maquina) {
        String response = MaquinaApi.createMaquina(maquina);
        if (response != null) {
            // Optionally refresh the list of machines after creating a new one
            readMaquinas();
        }
        return response; // Return response from the API
    }

    // Método para listar todas as máquinas
    public List<Maquina> readMaquinas() {
        maquinas = MaquinaApi.getMaquinas();
        return maquinas;
    }

    // Método para atualizar uma máquina
    public String updateMaquina(Maquina maquina) {
        String response = MaquinaApi.updateMaquina(maquina);
        if (response != null) {
            // Optionally refresh the list of machines after updating
            readMaquinas();
        }
        return response; // Return response from the API
    }

    // Método para deletar uma máquina
    public String deleteMaquina(String id) {
        String response = MaquinaApi.deleteMaquina(id);
        if (response != null) {
            // Optionally refresh the list of machines after deletion
            readMaquinas();
        }
        return response; // Return response from the API
    }
}
