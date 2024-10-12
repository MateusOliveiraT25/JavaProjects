package com.example.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.models.Manutencao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoApi {

    // Método para obter a lista de manutenções
    public static List<Manutencao> getManutencoes() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencoes = new ArrayList<>();

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Manutencao manutencao = jsonToManutencao(jsonObject);
                    manutencoes.add(manutencao);
                }
            } catch (JSONException e) {
                e.printStackTrace(); // Log de erros no parsing
            }
        }
        return manutencoes;
    }

   // Método para converter JSONObject em Manutencao
private static Manutencao jsonToManutencao(JSONObject jsonObject) {
    String id = jsonObject.getString("id");
    String maquinaId = jsonObject.optString("maquinaId", "desconhecido");
    LocalDate data = LocalDate.parse(jsonObject.getString("data"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    String tipo = jsonObject.getString("tipo");
    String pecasTrocadas = jsonObject.getString("pecasTrocadas");
    int tempoDeParada = jsonObject.getInt("tempoDeParada");
    
    // Use optString para evitar JSONException caso tecnicoId não seja uma string
    String tecnicoId = jsonObject.optString("tecnicoId", "desconhecido");
    
    String observacoes = jsonObject.getString("observacoes");

    return new Manutencao(id, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
}


    // Método para criar uma nova manutenção
    public static Manutencao createManutencao(Manutencao manutencao) {
        JSONObject jsonObject = manutencaoToJson(manutencao);
        String response = ApiConnection.postData("historicoManutencao", jsonObject.toString());

        if (response != null) {
            try {
                JSONObject createdManutencaoJson = new JSONObject(response);
                return jsonToManutencao(createdManutencaoJson);
            } catch (JSONException e) {
                e.printStackTrace(); // Log de erros no parsing
            }
        }
        return null; // Retorna null em caso de falha
    }

    // Método para atualizar uma manutenção existente
    public static boolean updateManutencao(Manutencao manutencao) {
        JSONObject jsonObject = manutencaoToJson(manutencao);
        String response = ApiConnection.putData("historicoManutencao/" + manutencao.getId(), jsonObject.toString());
        return response != null; // Retorna true se a atualização foi bem-sucedida
    }

    // Método para deletar uma manutenção pelo ID
    public static boolean deleteManutencao(String id) {
        String response = ApiConnection.deleteData("historicoManutencao/" + id);
        return response != null; // Retorna true se a deleção foi bem-sucedida
    }

    // Método para converter Manutencao em JSONObject
    private static JSONObject manutencaoToJson(Manutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); // Formata a data para String
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());
        return jsonObject;
    }
}
