package com.example;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Utiliza Lombok para gerar construtores, getters e setters
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Produto {
    private int id;           // ID do produto
    private String nome;      // Nome do produto
    private BigDecimal preco; // Preço do produto
}
