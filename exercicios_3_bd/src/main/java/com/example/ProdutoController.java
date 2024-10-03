package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    // Método para testar a consulta e exibir todos os produtos
    public void teste() {
        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {

            // Itera sobre os resultados da consulta
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
        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MIN(preco) AS preco_minimo, MAX(preco) AS preco_maximo FROM produtos")) {

            if (rs.next()) {
                // Imprime o preço mínimo e máximo
                System.out.println("Preço Mínimo: " + rs.getBigDecimal("preco_minimo"));
                System.out.println("Preço Máximo: " + rs.getBigDecimal("preco_maximo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para calcular e exibir a média dos preços dos produtos
    public void mediaProduto() {
        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement()) {

            // Consulta para obter todos os produtos
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

            // Exibir produtos
            System.out.println("Produtos:");
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getBigDecimal("preco"));
                System.out.println(" Nome: " + produto.getNome()
                        + " Preço: " + produto.getPreco());
            }

            // Consulta para calcular a média dos preços
            rs = stmt.executeQuery("SELECT AVG(preco) AS media_preco FROM produtos");
            if (rs.next()) {
                // Imprime a média dos preços
                System.out.println("Média dos preços: " + rs.getBigDecimal("media_preco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
