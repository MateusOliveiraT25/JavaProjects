package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExemplo {
    private String[] nomes = new String[3];// fixo com 3 elementos
    private List<String> nomesList; // dinamico

    public ArraysAsListExemplo() {
        nomes = new String[] { "Maria", "João", "Pedro" };
        nomesList = new ArrayList<>(Arrays.asList(nomes));
    }

    // alteração da array fixo
    public void adicionadoArray(String nome) {
        try {
            int posicao = nomes.length;
            nomes[posicao] = nome;

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // alterar uma list
    public void adicionarList(String nome) {
        try {
            nomesList.add(nome);
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            System.out.println(nomesList);
        }

    }
}