package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manutencao {
    private String id;
    private String maquinaId;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private int tempoDeParada;
    private String tecnicoId;
    private String observacoes;
}
