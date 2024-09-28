package com.example;

import java.util.Arrays;
import java.util.List;

public class StreamExemplo {
    List<String> words = Arrays.asList(
            "banana", "abacaxi", "laranja", "ameixa", "uva", "amora");

    // crei uma nova list resultado
    // filtee palavra com letra a 
    // to upercase
    // crie metodo
    public void imprimirPalavrasFiltradas() {
        words.stream()
                .filter(word -> word.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
