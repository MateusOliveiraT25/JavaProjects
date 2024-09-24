package com.exemplo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Curso {
    // Atributos
    private String nomeCurso;
    private ArrayList<Aluno> alunos;
    private Professor professor;

    // Construtor 
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.alunos = new ArrayList<>();
    }

    public Curso() {
        //TODO Auto-generated constructor stub
    }

    // Métodos 
    public void addProf(Professor professor) {
        this.professor = professor;
    }

    // Método para adicionar aluno
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Método para mostrar informações do curso
    public void infoCurso(){
        System.out.println("Curso: " + nomeCurso);
        System.out.println("Professor" + professor);
        System.out.println("Alunos Matriculados");
        for (Aluno aluno : alunos){
            System.out.println("Alunos: " + aluno.getNome()+"RA: " +aluno.getMatricula());
        }
    }

    //metodo ara lançar nota
    public void atribuirNotaNome(String nomeAluno, double notaAluno){
        for (Aluno aluno : alunos){
            if(aluno.getNome().equalsIgnoreCase(nomeAluno)){
                aluno.setNota(notaAluno);
                return;
            }
    }System.out.println("Aluno não encontrado");
    }
    //metodo exibir resultado final 
    public void exibirResultadoFinal(){
        for (Aluno aluno : alunos){
            System.out.println(aluno.exibirInfo());
            System.out.println(aluno.avaliarDesempenho());
        }
    
}
}
