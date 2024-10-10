package com.example.controllers;



import com.example.models.Tecnico;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TecnicoControllerIntegrationTest {

    private TecnicoController tecnicoController;

    @Before
    public void setUp() {
        // Instancia o controller antes de cada teste
        tecnicoController = new TecnicoController();
    }

    @Test
    public void testCreateAndReadTecnicos() {
        // Cria um novo técnico para o teste
        Tecnico tecnico = new Tecnico("", "John", "Eletricista", "Disponível");

        // Chama o método createTecnico e verifica a resposta
        String response = tecnicoController.createTecnico(tecnico);
        assertEquals("Success", response);

        // Chama o método readTecnicos para obter a lista de técnicos
        tecnicoController.readTecnicos();
        List<Tecnico> tecnicos = tecnicoController.getTecnicos();

        // Verifica se a lista de técnicos não está vazia
        assertNotNull(tecnicos);
        assertEquals(1, tecnicos.size());

        // Verifica os detalhes do técnico criado
        Tecnico createdTecnico = tecnicos.get(0);
        assertEquals("João", createdTecnico.getNome());
        assertEquals("Eletricista", createdTecnico.getEspecialidade());
    }

    @Test
    public void testUpdateTecnico() {
        // Primeiro cria um técnico
        Tecnico tecnico = new Tecnico("2", "Mario", "Mecânica", "Indisponível");
        tecnicoController.createTecnico(tecnico);

        // Modifica os detalhes do técnico
        tecnico.setNome("Maria Silva");
        tecnico.setDisponibilidade("Disponível");

        // Chama o método de updateTecnico e verifica a resposta
        String response = tecnicoController.updateTecnico(tecnico);
        assertEquals("Success", response);

        // Recarrega a lista de técnicos para confirmar a atualização
        tecnicoController.readTecnicos();
        Tecnico updatedTecnico = tecnicoController.getTecnicos().get(0);

        // Verifica os novos detalhes do técnico atualizado
        assertEquals("Maria Silva", updatedTecnico.getNome());
        assertEquals("Disponível", updatedTecnico.getDisponibilidade());
    }

    @Test
    public void testDeleteTecnico() {
        // Cria um técnico para ser deletado
        Tecnico tecnico = new Tecnico("3", "Carlos", "Eletrônica", "Disponível");
        tecnicoController.createTecnico(tecnico);

        // Chama o método de deleção e verifica a resposta
        String deleteResponse = tecnicoController.deleteTecnico("3");
        assertEquals("Deleted", deleteResponse);

        // Verifica se o técnico foi realmente removido
        tecnicoController.readTecnicos();
        List<Tecnico> tecnicos = tecnicoController.getTecnicos();

        // A lista de técnicos deve estar vazia após a exclusão
        assertEquals(0, tecnicos.size());
    }
}

