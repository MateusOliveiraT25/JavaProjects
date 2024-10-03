package com.example;

public class Main {
    public static void main(String[] args) {
        LeituraProdutosCSV leitura = new LeituraProdutosCSV();
        leitura.valorTotal();
        leitura.valorTotalEstoque();
        leitura.novoArquivoCSV();//novo arquivo
        
    }
}