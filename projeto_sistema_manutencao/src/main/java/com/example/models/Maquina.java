package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Maquina {

    private String id;
    private String codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private String dataAquisicao;
    private int tempoVidaEstimado;
    private String localizacao;
    private String detalhes;
    private String manual;
}
