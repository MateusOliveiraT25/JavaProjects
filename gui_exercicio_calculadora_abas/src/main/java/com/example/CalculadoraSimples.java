package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSimples extends JPanel{
//atributos
JTextField displaySimples; // Campo de texto para exibir os resultados
String[] botoes = {
    "7", "8", "9", "/", // Botões para os números 7, 8, 9 e a operação de divisão
    "4", "5", "6", "*", // Botões para os números 4, 5, 6 e a operação de multiplicação
    "1", "2", "3", "-", // Botões para os números 1, 2, 3 e a operação de subtração
    "0", "C", "=", "+"  };  // Botão 0, botão para limpar (C), botão de igual (=) e operação de adição
//construtor
public CalculadoraSimples(){
super(new BorderLayout());
displaySimples = new JTextField();
displaySimples.setHorizontalAlignment(JTextField.RIGHT);
displaySimples.setEditable(false);
this.add(displaySimples,BorderLayout.NORTH);

//criar paineis para os botoes
JPanel painelBotoes = new JPanel(new GridLayout(4,4,3,3));
for (String textoBotoes : botoes ){
    JButton botao = new JButton(textoBotoes);
    botao.addActionListener(null);
    painelBotoes.add(botao);
}
this.add(painelBotoes,BorderLayout.CENTER);

public void setDisplaySimples(String texto) {
    this.displaySimples.setText(texto); // Define o texto no campo de exibição
}

public JTextField getDisplaySimples() {
    return displaySimples; // Retorna o campo de texto
}
}



}
    
