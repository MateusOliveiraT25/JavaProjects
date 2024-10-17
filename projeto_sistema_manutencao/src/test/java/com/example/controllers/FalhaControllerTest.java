package com.example.controllers;

import com.example.models.Falha;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class FalhaControllerTest {
    private FalhaController falhaController;

    @Before
    public void setUp() {
        // Inicializa o controlador
        falhaController = new FalhaController();
    }

    @Test
    public void testCreateFalha() {
        // Criando uma falha
        Falha falhaMock = new Falha("1", "Máquina 1", LocalDate.of(2024, 10, 16), "Falha Crítica", "Alta", "Operador 1");

        // Chamando o método de criação
        Falha resultado = falhaController.createFalha(falhaMock);

        // Verificações
        assertNotNull(resultado);
        assertEquals("Máquina 1", resultado.getMaquinaId());
    }

    @Test
    public void testReadFalhas() {
        // Supondo que você já tenha falhas cadastradas na API
        List<Falha> resultados = falhaController.readFalhas();

        // Verificações
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty()); // Verifica se a lista não está vazia
    }

    @Test
    public void testUpdateFalha() {
        // Criando uma falha
        Falha falhaMock = new Falha("1", "Máquina 1", LocalDate.of(2024, 10, 16), "Falha Crítica", "Alta", "Operador 1");
        falhaController.createFalha(falhaMock);

        // Atualizando a falha
        falhaMock.setProblema("Falha Menor");
        String response = falhaController.updateFalha(falhaMock);

        // Verificações
        assertNotNull(response);
        assertEquals("Falha atualizada com sucesso", response); // Ajuste conforme sua lógica de resposta
    }

    @Test
    public void testDeleteFalha() {
        // Criando uma falha para deletar
        Falha falhaMock = new Falha("1", "Máquina 1", LocalDate.of(2024, 10, 16), "Falha Crítica", "Alta", "Operador 1");
        falhaController.createFalha(falhaMock);

        // Deletando a falha
        String response = falhaController.deleteFalha(falhaMock.getId());

        // Verificações
        assertNotNull(response);
        assertEquals("Falha deletada com sucesso", response); // Ajuste conforme sua lógica de resposta
    }
}
