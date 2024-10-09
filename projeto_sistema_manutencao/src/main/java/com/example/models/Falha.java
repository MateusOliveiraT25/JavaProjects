package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Falha {
    private String id;
    private String maquinaId;
    private LocalDate data;
    private String problema;
    private String prioridade;
    private String operador;
}
