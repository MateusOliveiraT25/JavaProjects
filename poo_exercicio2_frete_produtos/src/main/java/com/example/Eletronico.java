package com.example;


// A classe Eletronico herda de Produto e implementa a interface Transportavel
public class Eletronico extends Produto implements Transportavel {

    // Atributo específico da classe Eletronico
    private double volume;

    // Construtor da classe Eletronico, que chama o construtor da superclasse Produto
    public Eletronico(String nome, double preco, double volume) {
        // Chamada ao construtor da superclasse Produto, passando nome e preco
        super(nome, preco);
        // Inicializa o volume do eletrônico
        this.volume = volume;
    }

    // Implementação do método calcularPeso() da interface Transportavel
    @Override
    public double calcularPeso() {
        // O peso é calculado como volume multiplicado por 1.5
        double peso = volume * 1.5;
        return peso;
    }

    // Implementação do método calcularFrete() da interface Transportavel
    @Override
    public double calcularFrete() {
        // O valor do frete é calculado com base no peso multiplicado por 2
        double valorFrete = calcularPeso() * 2;
        return valorFrete;
    }
}
