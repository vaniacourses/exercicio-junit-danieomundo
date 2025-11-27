package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    // ---------------------- SOMA ----------------------
    @Test
    @DisplayName("Soma de dois números positivos")
    void testSomaPositivos() {
        assertEquals(7, calc.soma(3, 4));
    }

    @Test
    @DisplayName("Soma com números negativos")
    void testSomaNegativos() {
        assertEquals(-5, calc.soma(-2, -3));
    }

    @Test
    @DisplayName("Soma misturando positivo e negativo")
    void testSomaMisto() {
        assertEquals(0, calc.soma(2, -2));
    }

    // ---------------------- SUBTRAÇÃO ----------------------
    @Test
    @DisplayName("Subtração simples")
    void testSubtracao() {
        assertEquals(1, calc.subtracao(5, 4));
    }

    @Test
    @DisplayName("Subtração com resultado negativo")
    void testSubtracaoNegativa() {
        assertEquals(-3, calc.subtracao(2, 5));
    }

    // ---------------------- MULTIPLICAÇÃO ----------------------
    @Test
    @DisplayName("Multiplicação simples")
    void testMultiplicacao() {
        assertEquals(20, calc.multiplicacao(5, 4));
    }

    @Test
    @DisplayName("Multiplicação com zero")
    void testMultiplicacaoZero() {
        assertEquals(0, calc.multiplicacao(10, 0));
    }

    @Test
    @DisplayName("Multiplicação com negativos")
    void testMultiplicacaoNegativos() {
        assertEquals(-12, calc.multiplicacao(3, -4));
    }

    // ---------------------- DIVISÃO ----------------------
    @Test
    @DisplayName("Divisão simples")
    void testDivisao() {
        assertEquals(5, calc.divisao(20, 4));
    }

    @Test
    @DisplayName("Divisão com resultado zero")
    void testDivisaoResultadoZero() {
        assertEquals(0, calc.divisao(0, 5));
    }

    @Test
    @DisplayName("Divisão por zero lança ArithmeticException")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    // ---------------------- SOMATÓRIA ----------------------
    @Test
    @DisplayName("Somatória de 0 até n (ex: 5 resulta em 15)")
    void testSomatoria() {
        assertEquals(15, calc.somatoria(5));
    }

    @Test
    @DisplayName("Somatória de n = 0 deve ser 0")
    void testSomatoriaZero() {
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    @DisplayName("Somatória com n negativo deve retornar 0")
    void testSomatoriaNegativa() {
        // n < 0 não entra no while, retorna 0
        assertEquals(0, calc.somatoria(-5));
    }

    // ---------------------- EH POSITIVO ----------------------
    @Test
    @DisplayName("Número positivo deve retornar true")
    void testEhPositivo() {
        assertTrue(calc.ehPositivo(10));
    }

    @Test
    @DisplayName("Zero deve retornar true")
    void testEhPositivoZero() {
        assertTrue(calc.ehPositivo(0));
    }

    @Test
    @DisplayName("Número negativo deve retornar false")
    void testEhPositivoNegativo() {
        assertFalse(calc.ehPositivo(-1));
    }

    // ---------------------- COMPARA ----------------------
    @Test
    @DisplayName("Comparar números iguais")
    void testComparaIguais() {
        assertEquals(0, calc.compara(5, 5));
    }

    @Test
    @DisplayName("Comparar: a > b")
    void testComparaMaior() {
        assertEquals(1, calc.compara(10, 2));
    }

    @Test
    @DisplayName("Comparar: a < b")
    void testComparaMenor() {
        assertEquals(-1, calc.compara(2, 10));
    }
}
