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
public class Falha {
    private String id;
    private int maquinaId;
    private Date data;
    private String problema;
    private String prioridade;
    private String operador;
}
