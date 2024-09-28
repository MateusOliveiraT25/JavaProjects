package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class GerenciamentoVendas {
    // Mapa que armazena as vendas de cada cliente, onde a chave é o CPF do cliente
    // e o valor é uma lista de produtos comprados por esse cliente.
    private Map<String, List<Produto>> vendasClientes;

    // Construtor que inicializa o mapa de vendas.
    public GerenciamentoVendas() {
        vendasClientes = new HashMap<>();
    }

    // Método para registrar uma venda para um cliente, dado seu CPF e o produto.
    public void venda(String cpf, Produto produto) {
        // Itera sobre os CPFs já cadastrados para verificar se o CPF existe.
        for (String cpfCliente : vendasClientes.keySet()) {
            // Se o CPF do cliente já está cadastrado, adiciona o produto à lista de produtos.
            if (cpfCliente.equalsIgnoreCase(cpf)) {
                List<Produto> produtos = vendasClientes.get(cpfCliente);
                produtos.add(produto);
                vendasClientes.put(cpf, produtos); // Atualiza a lista de produtos para esse CPF.
                return; // Sai do método após registrar a venda.
            }
        }
        // Se o CPF não existe, cria uma nova lista de produtos e adiciona o produto.
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        vendasClientes.put(cpf, produtos); // Registra a nova venda para o novo CPF.
    }
    
    // Método para consultar as vendas de um cliente com base no CPF.
    public void consultarVendasPorCliente(String cpf) {
        // Recupera a lista de produtos comprados pelo cliente ou uma lista vazia.
        List<Produto> produtos = vendasClientes.getOrDefault(cpf, Collections.emptyList());
        
        // Verifica se a lista está vazia e informa que não há vendas cadastradas.
        if (produtos.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            // Exibe cada produto vendido ao cliente.
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
    }

    // Método para consultar vendas de um cliente acima de um valor mínimo.
    public void consultarClienteAcimaDE(String cpf, double valorMinimo) {
        // Recupera a lista de produtos comprados pelo cliente ou uma lista vazia.
        List<Produto> produtos = vendasClientes.getOrDefault(cpf, Collections.emptyList());
        
        // Verifica se a lista está vazia e informa que não há vendas cadastradas.
        if (produtos.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            // Exibe todos os produtos vendidos ao cliente.
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
            // Filtra os produtos que têm valor maior ou igual ao valor mínimo especificado.
            List<Produto> resultado = produtos.stream()
                .filter(p -> p.getValor() >= valorMinimo)
                .collect(Collectors.toList());
            
            // Verifica se existem produtos que atendem ao critério de valor mínimo.
            if (resultado.isEmpty()) {
                System.out.println("Nenhuma compra atingiu o valor mínimo");
            } else {
                // Exibe os produtos que atendem ao critério de valor mínimo.
                for (Produto produto : resultado) {
                    System.out.println(produto.toString());
                }
            }
        }
    }
}
