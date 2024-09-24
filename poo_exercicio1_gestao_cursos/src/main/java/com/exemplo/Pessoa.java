package com.exemplo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    private String nome;
    private String cpf;
// metodo
public String  exibirInfo(){
return "Nome: " + nome + " Cpf: " + cpf;
};


}
