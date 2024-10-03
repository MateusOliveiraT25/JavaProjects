package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeituraProdutosCSV {
    public void valorTotal() {
        String linha;
        String csvDivisor = ","; // Assumindo que o CSV é separado por vírgulas

        try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
            // Lê a linha de cabeçalho (se existir)
            String cabecalho = br.readLine();
            System.out.println("Cabeçalho: " + cabecalho);

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes
                String[] dados = linha.split(csvDivisor);

                // Supondo que o CSV tem as colunas: nome, quantidade, preço
                String nome = dados[0]; // Nome do produto
                int quantidade = Integer.parseInt(dados[1]); // Quantidade
                double preco = Double.parseDouble(dados[2]); // Preço

                // Calcula o valor total do estoque para o produto
                double valorTotalEstoque = quantidade * preco;

                // Imprime os resultados
                System.out.println("Produto: " + nome + ", Quantidade: " + quantidade 
                        + ", Preço: " + preco + ", Valor Total em Estoque: " + valorTotalEstoque);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Erro ao ler o arquivo
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados numéricos: " + e.getMessage());
        }
    }
    public void valorTotalEstoque() {
        String linha;
        String csvDivisor = ","; // Assumindo que o CSV é separado por vírgulas
        String produtoMaiorValor = null; // Para armazenar o nome do produto com maior valor
        double maiorValorTotal = 0; // Para armazenar o maior valor total

        try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
            // Lê a linha de cabeçalho (se existir)
            String cabecalho = br.readLine();
            System.out.println("Cabeçalho: " + cabecalho);

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes
                String[] dados = linha.split(csvDivisor);

                // Supondo que o CSV tem as colunas: nome, quantidade, preço
                String nome = dados[0]; // Nome do produto
                int quantidade = Integer.parseInt(dados[1]); // Quantidade
                double preco = Double.parseDouble(dados[2]); // Preço

                // Calcula o valor total do estoque para o produto
                double valorTotalEstoque = quantidade * preco;

                // Imprime os resultados
                System.out.println("Produto: " + nome + ", Quantidade: " + quantidade 
                        + ", Preço: " + preco + ", Valor Total em Estoque: " + valorTotalEstoque);

                // Verifica se este é o maior valor total
                if (valorTotalEstoque > maiorValorTotal) {
                    maiorValorTotal = valorTotalEstoque; // Atualiza o maior valor
                    produtoMaiorValor = nome; // Atualiza o nome do produto
                }
            }

            // Exibe o produto com o maior valor total em estoque
            if (produtoMaiorValor != null) {
                System.out.println("Produto com o maior valor total em estoque: " + produtoMaiorValor 
                        + " com valor total: " + maiorValorTotal);
            } else {
                System.out.println("Nenhum produto encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Erro ao ler o arquivo
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados numéricos: " + e.getMessage());
        }
    }
public void novoArquivoCSV() {
        String linha;
        String csvDivisor = ","; // Assumindo que o CSV é separado por vírgulas
        String produtoMaiorValor = null; // Para armazenar o nome do produto com maior valor
        double maiorValorTotal = 0; // Para armazenar o maior valor total

        // Nome do novo arquivo CSV que será gerado
        String novoArquivo = "dados_com_valor_total.csv";

        try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivo))) {
             
            // Lê a linha de cabeçalho (se existir)
            String cabecalho = br.readLine();
            System.out.println("Cabeçalho: " + cabecalho);

            // Escreve o novo cabeçalho com a coluna adicional
            bw.write(cabecalho + ",Valor Total em Estoque");
            bw.newLine();

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes
                String[] dados = linha.split(csvDivisor);

                // Supondo que o CSV tem as colunas: nome, quantidade, preço
                String nome = dados[0]; // Nome do produto
                int quantidade = Integer.parseInt(dados[1]); // Quantidade
                double preco = Double.parseDouble(dados[2]); // Preço

                // Calcula o valor total do estoque para o produto
                double valorTotalEstoque = quantidade * preco;

                // Imprime os resultados
                System.out.println("Produto: " + nome + ", Quantidade: " + quantidade 
                        + ", Preço: " + preco + ", Valor Total em Estoque: " + valorTotalEstoque);

                // Verifica se este é o maior valor total
                if (valorTotalEstoque > maiorValorTotal) {
                    maiorValorTotal = valorTotalEstoque; // Atualiza o maior valor
                    produtoMaiorValor = nome; // Atualiza o nome do produto
                }

                // Escreve os dados originais mais o valor total no novo arquivo
                bw.write(nome + "," + quantidade + "," + preco + "," + valorTotalEstoque);
                bw.newLine();
            }

            // Exibe o produto com o maior valor total em estoque
            if (produtoMaiorValor != null) {
                System.out.println("Produto com o maior valor total em estoque: " + produtoMaiorValor 
                        + " com valor total: " + maiorValorTotal);
            } else {
                System.out.println("Nenhum produto encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Erro ao ler ou escrever o arquivo
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados numéricos: " + e.getMessage());
        }
    }

}