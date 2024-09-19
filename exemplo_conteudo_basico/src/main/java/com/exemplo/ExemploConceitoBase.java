package com.exemplo;

public class ExemploConceitoBase {
    int idade=20;
    double valor = 30.99;
    char letra = 'J';
    boolean teste = false;


    public static void main (String [] args) {
        int a = 10, b= 20;
        double c = 3.5;
        boolean resultado = (a>b)&&(c<5);
        System.out.println("Soma: " + (a + b));  // Soma: 30
        System.out.println("Comparação: " + (a > b));  // Falso
        System.out.println("Resultado lógico: " + resultado);  // Falso
        
    }

    public void declaracaoDeUmMetodo(int a, int b){
        System.out.println(a+b);
    }

    public int metodoComRetorno(int a, int b){
        int c = a+b;
        return c;
    }
}



