package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProdutoController {

    // Método para testar a consulta e exibir todos os produtos
    public void exibir() {
        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {

            // Itera sobre os resultados da consulta
               // Exibir produtos
               System.out.println("Produtos:");
            while (rs.next()) {
                // Cria um objeto Produto e imprime suas informações
                Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getBigDecimal("preco"));
                System.out.println("ID: " + produto.getId()
                        + " Nome: " + produto.getNome()
                        + " Preço: " + produto.getPreco());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// Método para calcular e exibir o preço mínimo e máximo dos produtos
public void miniMaxi() {
    // Utiliza um bloco try-with-resources para garantir que os recursos sejam fechados automaticamente
    try (Connection con = ConnectionFactory.getConnection(); // Obtém uma conexão com o banco de dados
         Statement stmt = con.createStatement(); // Cria um objeto Statement para executar a consulta
         ResultSet rs = stmt.executeQuery("SELECT MIN(preco) AS preco_minimo, MAX(preco) AS preco_maximo FROM produtos")
         ) { // Executa a consulta para obter o preço mínimo e máximo

        // Verifica se o ResultSet contém pelo menos uma linha de resultados
        if (rs.next()) {
            // Imprime o preço mínimo e máximo obtidos do ResultSet
            System.out.println("Preço Mínimo: " + rs.getBigDecimal("preco_minimo")); // Obtém o preço mínimo
            System.out.println("Preço Máximo: " + rs.getBigDecimal("preco_maximo")); // Obtém o preço máximo
        }

    } catch (SQLException e) {
        // Trata qualquer SQLException que possa ocorrer durante a execução
        e.printStackTrace(); // Imprime a stack trace do erro para facilitar a depuração
    }
}

// Método para calcular e exibir a média dos preços dos produtos
public void mediaProduto() {
    // Utiliza um bloco try-with-resources para garantir que os recursos sejam fechados automaticamente
    try (Connection con = ConnectionFactory.getConnection(); // Obtém uma conexão com o banco de dados
         Statement stmt = con.createStatement()) { // Cria um objeto Statement para executar as consultas

        // Consulta para calcular a média dos preços
        ResultSet rs = stmt.executeQuery("SELECT AVG(preco) AS media_preco FROM produtos"); // Executa a consulta para calcular a média dos preços

        // Verifica se o ResultSet contém pelo menos uma linha de resultados
        if (rs.next()) {
            // Imprime a média dos preços obtida do ResultSet
            System.out.println("Média dos preços: " + rs.getBigDecimal("media_preco")); // Obtém e exibe a média dos preços
        }

    } catch (SQLException e) {
        // Trata qualquer SQLException que possa ocorrer durante a execução
        e.printStackTrace(); // Imprime a stack trace do erro para facilitar a depuração
    }
}

// Método para executar as operações de exibição, cálculo de preço mínimo e máximo, e cálculo da média dos preços
public void executarAnaliseProdutos() {
    exibir();       // Chama o método para exibir todos os produtos
    miniMaxi();    // Chama o método para calcular e exibir o preço mínimo e máximo
    mediaProduto(); // Chama o método para calcular e exibir a média dos preços
}
}
