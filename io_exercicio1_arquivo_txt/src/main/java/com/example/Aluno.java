package com.example;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    // atributos
    private String nome;
    private List<Double> notas;

    // construtor
    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        notas = new ArrayList<>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);
    }

    // media
    public double media() {
        double media = 0;
        for (Double nota : notas) {
        media =+ nota;
        }

        media/=notas.size();
        return media;
    }
    //maior noat
    public double maiorNotaAluno(){
    double maiorNota = 0;
    for (Double nota : notas) {
        if (nota>maiorNota) {
         maiorNota  =nota;   
        }
        }
        return maiorNota;
    }

   //menor nota
    public double menorNotaAluno(){
    double menorNota = 10;
    for (Double nota : notas) {
        if (nota<menorNota) {
         menorNota  =nota;   
        }
        }
        return menorNota;
    }

    //tostring
    @Override
    public String toString(){
        return "Nome: " +nome + " ,Notas: " + notas.toString();
    }
    public String getnome(){
        return nome;
    }
}
