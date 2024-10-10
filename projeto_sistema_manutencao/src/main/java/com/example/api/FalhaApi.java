package com.example.api;



import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha; // Certifique-se de que o pacote está correto

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FalhaApi {

    // Método para obter uma lista de falhas do servidor
    public static List<Falha> getFalhas() {
        // Faz uma requisição GET para o endpoint "falhas" e armazena a resposta JSON
        String json = ApiConnection.getData("falhas");
        List<Falha> falhas = new ArrayList<>();

        // Verifica se a resposta JSON não é nula
        if (json != null) {
            // Converte a string JSON para um JSONArray
            JSONArray jsonArray = new JSONArray(json);

            // Itera sobre o JSONArray para criar objetos Falha
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Converte o campo de data para LocalDate usando parse()
                LocalDate data = LocalDate.parse(jsonObject.getString("data"));

                // Cria um objeto Falha com base nos dados do JSON
                Falha falha = new Falha(
                        jsonObject.getString("id"),
                        jsonObject.getString("maquinaId"),
                        data, // Passa o LocalDate para o construtor
                        jsonObject.getString("problema"),
                        jsonObject.getString("prioridade"),
                        jsonObject.getString("operador"));

                // Adiciona a falha à lista de falhas
                falhas.add(falha);
            }
        }
        // Retorna a lista de falhas
        return falhas;
    }

    // Método para criar uma nova falha no servidor
    public static String createFalha(Falha falha) {
        // Cria um objeto JSON com os dados da falha
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", falha.getMaquinaId());
        jsonObject.put("data", falha.getData().toString()); // Converte LocalDate para String
        jsonObject.put("problema", falha.getProblema());
        jsonObject.put("prioridade", falha.getPrioridade());
        jsonObject.put("operador", falha.getOperador());

        // Converte o objeto JSON para string para enviar no payload da requisição
        String jsonPayload = jsonObject.toString();

        // Faz uma requisição POST para o endpoint "falhas" com o payload JSON
        return ApiConnection.postData("falhas", jsonPayload);
    }

    // Método para atualizar uma falha existente no servidor
    public static String updateFalha(Falha falha) {
        // Cria um objeto JSON com os dados atualizados da falha
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", falha.getMaquinaId());
        jsonObject.put("data", falha.getData().toString()); // Converte LocalDate para String
        jsonObject.put("problema", falha.getProblema());
        jsonObject.put("prioridade", falha.getPrioridade());
        jsonObject.put("operador", falha.getOperador());

        // Converte o objeto JSON para string para enviar no payload da requisição
        String jsonPayload = jsonObject.toString();

        // Faz uma requisição PUT para atualizar a falha com o ID especificado
        return ApiConnection.putData("falhas/" + falha.getId(), jsonPayload);
    }

    // Método para deletar uma falha no servidor com base no ID
    public static String deleteFalha(String id) {
        // Faz uma requisição DELETE para o endpoint "falhas/{id}"
        return ApiConnection.deleteData("falhas/" + id);
    }
}
