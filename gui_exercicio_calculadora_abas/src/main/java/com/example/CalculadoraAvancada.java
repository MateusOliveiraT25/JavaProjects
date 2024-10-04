package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraAvancada extends JPanel {
    // Atributos
    JTextField displayAvancado; // Campo de texto para exibir os resultados
    String[] botoes = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "=", "+",
        "sqrt", "log", "!", "%"  // Adicionando novos botões
    };

    //construtor
public CalculadoraAvancada(){
    super(new BorderLayout());
    displayAvancado = new JTextField();
    displayAvancado.setHorizontalAlignment(JTextField.RIGHT);
    displayAvancado.setEditable(false);
    this.add(displayAvancado,BorderLayout.NORTH);
    
    //criar paineis para os botoes
    JPanel painelBotoes = new JPanel(new GridLayout(5,4,3,3));
    for (String textoBotoes : botoes ){
        JButton botao = new JButton(textoBotoes);
        botao.addActionListener(null);
        painelBotoes.add(botao);
    }
    this.add(painelBotoes,BorderLayout.CENTER);
    
    
    
    
    
    }
    
    
    
    
    }
        
    