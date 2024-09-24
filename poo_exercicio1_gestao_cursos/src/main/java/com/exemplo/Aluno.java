package com.exemplo;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa implements Avaliave {
    private String matricula;
    private double nota;

public Aluno (String nome, String cpf, String matricula){
    super(nome,cpf);
    this.matricula = matricula;
    this.nota = 0 ;
}

//metodo exibirinfo
@Override
public String exibirInfo(){
    super.exibirInfo();
    return " Matricula: " + matricula + " Nota: " + nota;
}

@Override
public String avaliarDesempenho() {
    if(nota>=7){
        return "Aprovado";
    }else if (nota>=5){
        return "Recuperação";
    }else 
    return "Reprovado";
}
}
