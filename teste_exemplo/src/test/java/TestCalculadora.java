
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class TestCalculadora { // A classe agora é pública

    Calculadora calculadora = new Calculadora();

    @Test
    public void testSoma() { // Método público
        double resultado = calculadora.soma(2, 3);
        assertEquals(5, resultado, 0); // Verifica a soma
    }

    @Test
    public void testSubtrai() { // Método público
        double resultado = calculadora.subtrai(5, 2);
        assertEquals(3, resultado, 0); // Verifica a subtração
    }

    @Test
    public void testMultiplica() { // Método público
        double resultado = calculadora.multiplica(4, 2);
        assertEquals(8, resultado, 0); // Verifica a multiplicação
    }

    @Test
    public void testDivide() throws IllegalAccessException { // Método público
        double resultado = calculadora.divide(10, 2);
        assertEquals(5, resultado, 0); // Verifica a divisão
    }

    @Test
    public void testDividePorZero() { // Método público
        // Verifica se a exceção é lançada ao dividir por zero
        assertThrows(ArithmeticException.class, () -> calculadora.divide(10, 0)); // Verifica se ArithmeticException é lançada
    }
}
