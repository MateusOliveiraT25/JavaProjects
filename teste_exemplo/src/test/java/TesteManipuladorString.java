import org.junit.jupiter.api.Test;

import com.example.ManipuladorString;

import static org.junit.jupiter.api.Assertions.*;

public class TesteManipuladorString {

    private final ManipuladorString utils = new ManipuladorString();

    // Testes para o método invertString
    @Test
    public void testInvertStringNormal() {
        assertEquals("dcba", utils.invertString("abcd"));
    }

    @Test
    public void testInvertStringEmpty() {
        assertEquals("", utils.invertString(""));
    }

    @Test
    public void testInvertStringSingleCharacter() {
        assertEquals("a", utils.invertString("a"));
    }

    @Test
    public void testInvertStringNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            utils.invertString(null);
        });
    }

    // Testes para o método contarVogais
    @Test
    public void testContarVogaisNormal() {
        assertEquals(5, utils.contarVogais("abracadabra"));
    }

    @Test
    public void testContarVogaisEmpty() {
        assertEquals(0, utils.contarVogais(""));
    }

    @Test
    public void testContarVogaisWithoutVogais() {
        assertEquals(0, utils.contarVogais("bcdfgh"));
    }

    @Test
    public void testContarVogaisComNumeros() {
        assertEquals(2, utils.contarVogais("123abcde"));
    }

    @Test
    public void testContarVogaisNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            utils.contarVogais(null);
        });
    }

    // Testes para o método contarPalavras
    @Test
    public void testContarPalavrasNormal() {
        assertEquals(3, utils.contarPalavras("A casa azul"));
    }

    @Test
    public void testContarPalavrasEmpty() {
        assertEquals(0, utils.contarPalavras(""));
    }

    @Test
    public void testContarPalavrasComEspacosExtras() {
        assertEquals(3, utils.contarPalavras("   A casa   azul  "));
    }

    @Test
    public void testContarPalavrasSingleWord() {
        assertEquals(1, utils.contarPalavras("Azul"));
    }

    @Test
    public void testContarPalavrasNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            utils.contarPalavras(null);
        });
    }
}
