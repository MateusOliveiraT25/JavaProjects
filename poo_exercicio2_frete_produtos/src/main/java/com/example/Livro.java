package com.example;


public class Livro extends Produto implements Transportavel {
        // Atributo específico da classe Livro
        private double volume;
    public Livro (String nome, double preco, double volume) {
        // Chamada ao construtor da superclasse Produto, passando nome e preco
        super(nome, preco);
        // Inicializa o volume do eletrônico
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        // O peso é calculado como volume multiplicado por 
        double peso = volume * 2;
        return peso;
    }

    // Implementação do método calcularFrete() da interface Transportavel
    @Override
    public double calcularFrete() {
        // O valor do frete é calculado com base no peso multiplicado por 
        double valorFrete = calcularPeso() * 3;
        return valorFrete;
    }
    }

