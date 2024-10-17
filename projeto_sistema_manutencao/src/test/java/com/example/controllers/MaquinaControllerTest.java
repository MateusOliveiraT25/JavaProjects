package com.example.controllers;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class MaquinaControllerTest {
    private MaquinaController maquinaController;

    @Before
    public void setUp() {
        // Inicializa o controlador
        maquinaController = new MaquinaController();
    }

    @Test
    public void testCreateMaquina() {
        // Criando uma nova máquina
        Maquina maquinaMock = new Maquina("1", "001", "Máquina 1", "Modelo A", "Fabricante X", 
                                          LocalDate.of(2024, 10, 16), 10, 
                                          "Localização A", "Detalhes sobre a máquina", 
                                          "link_para_manual");

        // Chamando o método de criação
        Maquina resultado = maquinaController.createMaquina(maquinaMock);

        // Verificações
        assertNotNull(resultado);
        assertEquals("Máquina 1", resultado.getNome());
        assertEquals("Modelo A", resultado.getModelo());
        assertEquals("Fabricante X", resultado.getFabricante());
    }

    @Test
    public void testReadMaquinas() {
        // Supondo que você já tenha máquinas cadastradas na API
        List<Maquina> resultados = maquinaController.readMaquinas();

        // Verificações
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty()); // Verifica se a lista não está vazia
    }

    @Test
    public void testUpdateMaquina() {
        // Criando uma nova máquina
        Maquina maquinaMock = new Maquina("1", "001", "Máquina 1", "Modelo A", "Fabricante X", 
                                          LocalDate.of(2024, 10, 16), 10, 
                                          "Localização A", "Detalhes sobre a máquina", 
                                          "link_para_manual");
        maquinaController.createMaquina(maquinaMock);

        // Atualizando a máquina
        maquinaMock.setModelo("Modelo B");
        String response = maquinaController.updateMaquina(maquinaMock);

        // Verificações
        assertNotNull(response);
        assertEquals("Máquina atualizada com sucesso", response); // Ajuste conforme sua lógica de resposta
    }

    @Test
    public void testDeleteMaquina() {
        // Criando uma nova máquina para deletar
        Maquina maquinaMock = new Maquina("1", "001", "Máquina 1", "Modelo A", "Fabricante X", 
                                          LocalDate.of(2024, 10, 16), 10, 
                                          "Localização A", "Detalhes sobre a máquina", 
                                          "link_para_manual");
        maquinaController.createMaquina(maquinaMock);

        // Deletando a máquina
        String response = maquinaController.deleteMaquina(maquinaMock.getId());

        // Verificações
        assertNotNull(response);
        assertEquals("Máquina deletada com sucesso", response); // Ajuste conforme sua lógica de resposta
    }
}
