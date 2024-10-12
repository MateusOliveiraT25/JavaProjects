package com.example.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.api.TecnicoApi;
import com.example.models.Tecnico;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TecnicoControllerTest {
    private TecnicoController tecnicoController;

    @Before
    public void setUp() {
        // Inicializa o controlador
        tecnicoController = new TecnicoController();
    }

    @Test
    public void testCreateTecnico() {
        // Criando um tecnico
        Tecnico tecnicoMock = new Tecnico("1", "Joao", "Mecanico", "Disponivel");

        // Chamando o metodo de criacao
        Tecnico resultado = tecnicoController.createTecnico(tecnicoMock);

        // Verificacoes
        assertNotNull(resultado);
        assertEquals("Joao", resultado.getNome());
    }

    @Test
    public void testReadTecnicos() {
        // Supondo que voce ja tenha tecnicos cadastrados na API
        List<Tecnico> resultados = tecnicoController.readTecnicos();

        // Verificacoes (ajuste de acordo com os dados da API)
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty()); // Verifica se a lista nao esta vazia
    }

     
}
