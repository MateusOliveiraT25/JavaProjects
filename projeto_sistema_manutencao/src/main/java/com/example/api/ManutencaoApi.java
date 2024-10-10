package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoApi {

    // Método para obter todas as manutenções do servidor
    public static List<Manutencao> getManutencoes() {
        // Faz uma requisição GET para o endpoint "manutencoes" e armazena a resposta JSON
        String json = ApiConnection.getData("manutencoes");
        List<Manutencao> manutencoes = new ArrayList<>();

        // Verifica se a resposta JSON não é nula
        if (json != null) {
            // Converte a string JSON para um JSONArray
            JSONArray jsonArray = new JSONArray(json);

            // Itera sobre o JSONArray para criar objetos Manutencao
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Cria um objeto Manutencao com base nos dados do JSON
                Manutencao manutencao = new Manutencao(
                        jsonObject.getString("id"),
                        jsonObject.getString("maquinaId"),
                        LocalDate.parse(jsonObject.getString("data")),
                        jsonObject.getString("tipo"),
                        jsonObject.getString("pecasTrocadas"),
                        jsonObject.getInt("tempoDeParada"),
                        jsonObject.getString("tecnicoId"),
                        jsonObject.getString("observacoes")
                );

                // Adiciona a manutenção à lista de manutenções
                manutencoes.add(manutencao);
            }
        }
        // Retorna a lista de manutenções
        return manutencoes;
    }

    // Método para criar uma nova manutenção no servidor
    public static String createManutencao(Manutencao manutencao) {
        // Cria um objeto JSON com os dados da manutenção
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        // Converte o objeto JSON para string para enviar no payload da requisição
        String jsonPayload = jsonObject.toString();

        // Faz uma requisição POST para o endpoint "manutencoes" com o payload JSON
        return ApiConnection.postData("historicoManutencao", jsonPayload);
    }

    // Método para atualizar uma manutenção existente no servidor
    public static String updateManutencao(Manutencao manutencao) {
        // Cria um objeto JSON com os dados atualizados da manutenção
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        // Converte o objeto JSON para string para enviar no payload da requisição
        String jsonPayload = jsonObject.toString();

        // Faz uma requisição PUT para atualizar a manutenção com o ID especificado
        return ApiConnection.putData("historicoManutencao/" + manutencao.getId(), jsonPayload);
    }

    // Método para deletar uma manutenção no servidor com base no ID
    public static String deleteManutencao(String id) {
        // Faz uma requisição DELETE para o endpoint "manutencoes/{id}"
        return ApiConnection.deleteData("historicoManutencao/" + id);
    }
}
