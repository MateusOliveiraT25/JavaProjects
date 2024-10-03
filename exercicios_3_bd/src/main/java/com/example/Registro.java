package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registro {

    // Método para testar a consulta e exibir todos os produtos
    public void teste() {
        try {
            // Estabelece a conexão com o banco de dados
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            
            // Cria um objeto Statement para executar a consulta SQL
            Statement stmt = con.createStatement();
            
            // Executa a consulta para selecionar todos os produtos
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");
            
            // Itera sobre os resultados da consulta
            while (rs.next()) {
                // Imprime as informações de cada produto
                System.out.println("ID: " + rs.getInt("id")
                        + " Nome: " + rs.getString("nome")
                        + " Preço: " + rs.getBigDecimal("preco"));
            }
            
            // Fecha a conexão (deve ser feita fora do loop)
            con.close();

        } catch (Exception e) {
            // Imprime o erro caso ocorra uma exceção
            e.printStackTrace();
        }
    }

    // Método para calcular e exibir o preço mínimo e máximo dos produtos
    public void miniMaxi() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Estabelece a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            stmt = con.createStatement();

            // Consulta para obter o preço mínimo e máximo
            rs = stmt.executeQuery("SELECT MIN(preco) AS preco_minimo, MAX(preco) AS preco_maximo FROM produtos");
            if (rs.next()) {
                // Imprime o preço mínimo e máximo
                System.out.println("Preço Mínimo: " + rs.getBigDecimal("preco_minimo"));
                System.out.println("Preço Máximo: " + rs.getBigDecimal("preco_maximo"));
            }

        } catch (SQLException e) {
            // Imprime o erro caso ocorra uma exceção
            e.printStackTrace();
        } finally {
            // Fechar os recursos para evitar vazamentos de memória
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                // Imprime o erro ao fechar os recursos
                e.printStackTrace();
            }
        }
    }
    
    // Método para calcular e exibir a média dos preços dos produtos
    public void mediaProduto() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Estabelece a conexão com o banco de dados
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            stmt = con.createStatement();

            // Consulta para obter todos os produtos
            rs = stmt.executeQuery("SELECT * FROM produtos");

            // Exibir produtos
            System.out.println("Produtos:");
            while (rs.next()) {
                // Imprime as informações de cada produto
                System.out.println( " Nome: " + rs.getString("nome")
                        + " Preço: " + rs.getBigDecimal("preco"));
            }

            // Consulta para calcular a média dos preços
            rs = stmt.executeQuery("SELECT AVG(preco) AS media_preco FROM produtos");
            if (rs.next()) {
                // Imprime a média dos preços
                System.out.println("Média dos preços: " + rs.getBigDecimal("media_preco"));
            }

        } catch (SQLException e) {
            // Imprime o erro caso ocorra uma exceção
            e.printStackTrace();
        } finally {
            // Fechar os recursos para evitar vazamentos de memória
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                // Imprime o erro ao fechar os recursos
                e.printStackTrace();
            }
        }
    }
}
