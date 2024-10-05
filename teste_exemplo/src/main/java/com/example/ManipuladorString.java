package com.example;

public class ManipuladorString {

    // Método para inverter uma string
    public String invertString(String original) {
        if (original == null) {
            throw new IllegalArgumentException("String não pode ser nula");
        }
        return new StringBuilder(original).reverse().toString();
    }

    // Método para contar o número de vogais em uma string
    public int contarVogais(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Texto não pode ser nulo");
        }
        int count = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Método para contar o número de palavras em uma string
    public int contarPalavras(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Texto não pode ser nulo");
        }
        if (texto.trim().isEmpty()) {
            return 0;
        }
        return texto.trim().split("\\s+").length;
    }
}
