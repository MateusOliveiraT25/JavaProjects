package com.example.controllers;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ManutencaoControllerTest {
    private ManutencaoController manutencaoController;

    @Before
    public void setUp() {
        // Inicializa o controlador
        manutencaoController = new ManutencaoController();
    }

    @Test
    public void testCreateManutencao() {
        // Criando uma nova manutenção
        Manutencao manutencaoMock = new Manutencao("1", "Máquina 1", LocalDate.now(), "Tipo A", "Peça X", 5, "Técnico 1", "Observações");

        // Chamando o método de criação
        Manutencao resultado = manutencaoController.createManutencao(manutencaoMock);

        // Verificações
        assertNotNull(resultado);
        assertEquals("Máquina 1", resultado.getMaquinaId());
    }

    @Test
    public void testReadManutencoes() {
        // Supondo que você já tenha manutenções cadastradas na API
        List<Manutencao> resultados = manutencaoController.readManutencoes();

        // Verificações
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty()); // Verifica se a lista não está vazia
    }

    @Test
    public void testUpdateManutencao() {
        // Criando uma nova manutenção
        Manutencao manutencaoMock = new Manutencao("1", "Máquina 1", LocalDate.now(), "Tipo A", "Peça X", 5, "Técnico 1", "Observações");
        manutencaoController.createManutencao(manutencaoMock);

        // Atualizando a manutenção
        manutencaoMock.setTipo("Tipo B");
        boolean success = manutencaoController.updateManutencao(manutencaoMock);

        // Verificações
        assertTrue(success);
    }

    @Test
    public void testDeleteManutencao() {
        // Criando uma nova manutenção para deletar
        Manutencao manutencaoMock = new Manutencao("1", "Máquina 1", LocalDate.now(), "Tipo A", "Peça X", 5, "Técnico 1", "Observações");
        manutencaoController.createManutencao(manutencaoMock);

        // Deletando a manutenção
        boolean success = manutencaoController.deleteManutencao(manutencaoMock.getId());

        // Verificações
        assertTrue(success);
    }
}
