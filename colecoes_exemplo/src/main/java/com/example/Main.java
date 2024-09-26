package com.example;

public class Main {
    public static void main(String[] args) {
        MapExemplo map = new MapExemplo();

        // Adicionando nomes com IDs ao Map
        map.adicionarNome(1, "Maria");
        map.adicionarNome(2, "João");
        map.adicionarNome(3, "Ana");
        map.adicionarNome(1, "Carlos"); // Este ID já existe, não será substituído

        // Listando os nomes
        System.out.println("Lista de nomes:");
        map.listarNomes();

        // Modificando um nome
        map.modificarNome(2, "Carlos");

        // Listando novamente após modificação
        System.out.println("Lista de nomes após modificação:");
        map.listarNomes();

        // Deletando um nome
        map.deletarNome(3);

        // Listando após remoção
        System.out.println("Lista de nomes após remoção:");
        map.listarNomes();
    }
}
