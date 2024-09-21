package com.exemplo;
import java.util.Scanner;
public class ExercicioRecursao {
    
          //atributos
        int numero = -1;
        Scanner sc = new Scanner(System.in);

        //metood
        public long fatorial (int numero){
            if (numero == 0|| numero == 1){
                return 1;

            }else {

                return numero*fatorial(numero-1);
            }
        }
         // fazer a operação
         public void calculadora () throws Exception{
            while (true){
                System.out.println("Digite um nummero");
                numero = sc.nextInt();
                if (numero <0){
                    throw new Exception("Não permitido n° negativo");
                }
                try {long resultado = fatorial(numero);
                    System.out.println("O fatorial é " + resultado);
                   
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
         }

    }

