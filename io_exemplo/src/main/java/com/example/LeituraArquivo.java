package com.example;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {
    public void exemplo(){
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) {
            String linha;
           do {
            linha = br.readLine();
            System.out.println(linha==null?"Fim do documento":linha);
           } while (linha!=null);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}
