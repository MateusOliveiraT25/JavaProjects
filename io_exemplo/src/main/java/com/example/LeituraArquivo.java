package com.example;

import java.io.BufferedReader;

import java.io.FileReader;

public class LeituraArquivo {
    public void exemplo(){
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
