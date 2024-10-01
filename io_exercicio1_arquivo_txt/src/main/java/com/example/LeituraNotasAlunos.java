package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeituraNotasAlunos {
private List<Aluno> alunos;

//construtor
public LeituraNotasAlunos() {
    alunos = new ArrayList<>();
    //metido de leitura
    
   }
   public void leituraFile(){
    try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
        String   linha = br.readLine();
       do {

     String []aluno = linha.split(",");
     Aluno alunoNota = new Aluno (aluno[0],
     Double.parseDouble(aluno[1]),
     Double.parseDouble(aluno[2]),
     Double.parseDouble(aluno[3]));
     alunos.add(alunoNota);
     linha = br.readLine();

  
       } while (linha!=null);     
    } catch (Exception e) {
        e.printStackTrace();
    }System.out.println(alunos);
}
//Aluno maio nota
public void alunoMaiorNota(){
    String nome="";
    double maiorNota = 0;
    for (Aluno aluno : alunos) {
        if (aluno.maiorNotaAluno()>maiorNota) {
            maiorNota = aluno.maiorNotaAluno();
            nome = aluno.getnome();
        }
    }System.out.println("O aluno com Maior nota é " +nome + " com nota = " +maiorNota);
}
public void alunoMenorNota(){
    String nome="";
    double menorNota = 10;
    for (Aluno aluno : alunos) {
        if (aluno.menorNotaAluno()<menorNota) {
            menorNota = aluno.menorNotaAluno();
            nome = aluno.getnome();
        }
    }System.out.println("O aluno com Menor nota é " +nome + " com nota = " +menorNota);
}


// Calcula a média da turma
public void mediaTurma() {
    double somaDasMedias = 0;

    if (alunos.isEmpty()) {
        System.out.println("Não há alunos na turma.");
        return; // Retorna se não houver alunos
    }

    for (Aluno aluno : alunos) {
        somaDasMedias += aluno.media(); // Certifique-se de que aluno.media() retorne a média correta
    }

    double mediaTurma = somaDasMedias / alunos.size(); // Calcular média da turma
    System.out.printf("A média da turma é %.2f%n", mediaTurma); // Formatação para duas casas decimais
}


}