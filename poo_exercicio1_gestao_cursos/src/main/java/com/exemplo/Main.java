package com.exemplo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
       List<Curso> cursos = new ArrayList<>();
       String Operacao ="0";
       do{Operacao =JOptionPane.showInputDialog(
       "\n -----Gerenciamento de curso-----\n"
       +"1 -Criar curso\n"
       + "2 -Adicionar professor\n"
       +"3 -Adicionar aluno\n"
       +"4 -Informações do curso\n"
       +"5 -Atribuir nota\n"
       +"6 -Resultado final\n"
       +"7 -Sair\n"
       );
switch (Operacao) {
    case "1":
    String nomeCurso = JOptionPane.showInputDialog("Informe o nome do curso");
    cursos.add(new Curso(nomeCurso));
        
        break;
        case "2":
        String nomeCursoP = JOptionPane.showInputDialog("Informe o nome do curso");
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP));
            String nomeProf = JOptionPane.showInputDialog("Nome: ");
            String cpfProf = JOptionPane.showInputDialog("CPF: ");
            Double salarioProf = Double.parseDouble(JOptionPane.showInputDialog("Salario: "));
            Professor professor = new Professor (nomeProf, cpfProf, salarioProf);
            curso.addProf(professor);


        }      
            break;

            case "3":
            String nomeCursoA = JOptionPane.showInputDialog("Informe o nome do curso");
       try {
        boolean encontrado = false;
        for (Curso curso : cursos) {
        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)){
            encontrado = true;
            boolean novoAluno = true;
            do {
                String nomeAluno = JOptionPane.showInputDialog("Nome: ");
                String cpfAluno= JOptionPane.showInputDialog("CPF: ");
                String matriculaAluno= JOptionPane.showInputDialog("Matricula: ");
                curso.addAluno(new Aluno (nomeAluno,cpfAluno,matriculaAluno));
                novoAluno = JOptionPane.showInputDialog("Inserir novo Aluno\n"
                + "1 - sim"
                + "2 - não").equals("1")?true:false;
            } while (novoAluno );
        };
        

        }
       } catch (Exception e) {
        // TODO: handle exception
       }

            break;
    default:
        break;
}
       } while(Operacao!="7") ;
    }
}