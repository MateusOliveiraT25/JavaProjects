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

    public static List<Manutencao> getManutencoes() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencoes = new ArrayList<>();

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    // Usando optString para evitar JSONException
                    String id = jsonObject.getString("id");
                    String maquinaId = jsonObject.optString("maquinaId", "desconhecido");
                    LocalDate data = LocalDate.parse(jsonObject.getString("data"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String tipo = jsonObject.getString("tipo");
                    String pecasTrocadas = jsonObject.getString("pecasTrocadas");
                    int tempoDeParada = jsonObject.getInt("tempoDeParada");
                    String tecnicoId = jsonObject.getString("tecnicoId");
                    String observacoes = jsonObject.getString("observacoes");

                    Manutencao manutencao = new Manutencao(id, maquinaId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
                    manutencoes.add(manutencao);
                }
            } catch (JSONException e) {
                e.printStackTrace(); // Log de erros no parsing
            }
        }
        return manutencoes;
    }

    public static String createManutencao(Manutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        return ApiConnection.postData("historicoManutencao", jsonObject.toString());
    }

    public static String updateManutencao(Manutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        return ApiConnection.putData("historicoManutencao/" + manutencao.getId(), jsonObject.toString());
    }

    public static String deleteManutencao(String id) {
        return ApiConnection.deleteData("historicoManutencao/" + id);
    }
}
