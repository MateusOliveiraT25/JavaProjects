package com.example;

public class Calculadora {
    public double soma(double a, double b){
        return a+b;
    }
public double subtrai (double a, double b){
    return a-b;

}

public double multiplica(double a, double b){
    return a*b;
}

public double divide(double a, double b) throws IllegalAccessException{
    if(b==0){
        throw new IllegalAccessException("Divisão por zero não permitida.");
    }
    return a / b;
}
}

