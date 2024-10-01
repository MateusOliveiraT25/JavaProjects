package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeituraAPI {
    // Método que realiza a leitura da API do GitHub
    public void exemplo() {
        try {
            // Define a URL da API que será acessada
            URL url = new URL("https://api.github.com/users/MateusOliveiraT25");
            // Abre uma conexão HTTP com a URL especificada
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Define o método de requisição como GET
            con.setRequestMethod("GET");

            // Obtém o código de resposta da requisição
            int status = con.getResponseCode();
            // Verifica se a resposta é 200 (OK). Caso contrário, lança uma exceção
            if (status != 200) {
                throw new Exception("Erro de conexão: " + status);
            }

            // Cria um BufferedReader para ler a resposta da API
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // StringBuilder para construir a resposta em formato de string
            StringBuilder response = new StringBuilder();
            String linha;

            // Lê cada linha da resposta e a adiciona ao StringBuilder
            while ((linha = br.readLine()) != null) {
                response.append(linha);
            }
            // Fecha o BufferedReader
            br.close();

            // Imprime a resposta da API no console
            System.out.println(response.toString());

        } catch (Exception e) {
            // Melhora o tratamento de exceções, imprimindo a stack trace para depuração
            e.printStackTrace();
        }
    }
}
