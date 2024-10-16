package com.example.controllers;

import com.example.api.FalhaApi;
import com.example.models.Falha;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FalhaControllerTest {
    private FalhaController falhaController;
    private FalhaApi falhaApiMock;

    @Before
    public void setUp() {
        // Mock do FalhaApi
        falhaApiMock = mock(FalhaApi.class);
        falhaController = new FalhaController();

        // Injetar o mock (simulamos chamadas à API real)
       // FalhaApi.setInstance(falhaApiMock);
    }

    @Test
    public void testCreateFalha() {
        // Mock da falha a ser criada
        Falha falhaMock = new Falha("1", "Maquina1", LocalDate.now(), "Falha mecânica", "Alta", "Operador1");
        when(falhaApiMock.createFalha(falhaMock)).thenReturn(falhaMock);

        // Chamada do método createFalha
        Falha resultado = falhaController.createFalha(falhaMock);

        // Verificações
        assertNotNull(resultado);
        assertEquals("Falha mecânica", resultado.getProblema());
        verify(falhaApiMock).createFalha(falhaMock); // Verifica se o método foi chamado
    }

    @Test
    public void testReadFalhas() {
        // Mock da lista de falhas retornada pela API
        List<Falha> falhasMock = Arrays.asList(
            new Falha("1", "Maquina1", LocalDate.now(), "Falha mecânica", "Alta", "Operador1"),
            new Falha("2", "Maquina2", LocalDate.now(), "Falha elétrica", "Média", "Operador2")
        );
        when(falhaApiMock.getFalhas()).thenReturn(falhasMock);

        // Chamada do método readFalhas
        List<Falha> resultados = falhaController.readFalhas();

        // Verificações
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty());
        assertEquals(2, resultados.size());
        verify(falhaApiMock).getFalhas(); // Verifica se o método foi chamado
    }

    @Test
    public void testUpdateFalha() {
        // Mock da falha a ser atualizada
        Falha falhaMock = new Falha("1", "Maquina1", LocalDate.now(), "Falha mecânica", "Alta", "Operador1");
        when(falhaApiMock.updateFalha(falhaMock)).thenReturn("Atualizado com sucesso");

        // Chamada do método updateFalha
        String response = falhaController.updateFalha(falhaMock);

        // Verificações
        assertEquals("Atualizado com sucesso", response);
        verify(falhaApiMock).updateFalha(falhaMock); // Verifica se o método foi chamado
    }

    @Test
    public void testDeleteFalha() {
        // Mock do ID da falha a ser deletada
        String falhaId = "1";
        when(falhaApiMock.deleteFalha(falhaId)).thenReturn("Deletado com sucesso");

        // Chamada do método deleteFalha
        String response = falhaController.deleteFalha(falhaId);

        // Verificações
        assertEquals("Deletado com sucesso", response);
        verify(falhaApiMock).deleteFalha(falhaId); // Verifica se o método foi chamado
    }
}

