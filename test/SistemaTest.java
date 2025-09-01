import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;
import carrinho.Carrinho;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

/**
 * Classe de testes unitários para Calculadora e Carrinho
 * Usando JUnit 5
 */
public class SistemaTest {

    private Calculadora calculadora;
    private Carrinho carrinho;

    @BeforeEach
    void setup() {
        calculadora = new Calculadora();
        carrinho = new Carrinho();
    }

    // ---------------- Testes da Calculadora ----------------

    @Test
    @DisplayName("Soma de dois inteiros positivos")
    void testSomaPositivos() {
        assertEquals(7, calculadora.soma(3, 4));
    }

    @Test
    @DisplayName("Soma com número negativo")
    void testSomaComNegativo() {
        assertEquals(-2, calculadora.soma(3, -5));
    }

    @Test
    @DisplayName("Subtração simples")
    void testSubtracao() {
        assertEquals(1, calculadora.subtracao(5, 4));
    }

    @Test
    @DisplayName("Multiplicação com zero")
    void testMultiplicacaoZero() {
        assertEquals(0, calculadora.multiplicacao(10, 0));
    }

    @Test
    @DisplayName("Multiplicação com valores positivos")
    void testMultiplicacaoPositivos() {
        assertEquals(20, calculadora.multiplicacao(4, 5));
    }

    @Test
    @DisplayName("Divisão exata")
    void testDivisaoExata() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    @DisplayName("Divisão por zero deve lançar ArithmeticException")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(10, 0));
    }

    @Test
    @DisplayName("Somatória de número positivo")
    void testSomatoriaPositivo() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5 = 15
    }

    @Test
    @DisplayName("Somatória de zero")
    void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("ehPositivo retorna verdadeiro para número positivo")
    void testEhPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("ehPositivo retorna verdadeiro para zero")
    void testEhPositivoZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("ehPositivo retorna falso para número negativo")
    void testEhPositivoNegativo() {
        assertFalse(calculadora.ehPositivo(-3));
    }

    @Test
    @DisplayName("Comparação de números iguais")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Comparação de número maior que outro")
    void testComparaMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    @DisplayName("Comparação de número menor que outro")
    void testComparaMenor() {
        assertEquals(-1, calculadora.compara(3, 7));
    }

    // ---------------- Testes do Carrinho ----------------

    @Test
    @DisplayName("Carrinho inicia vazio")
    void testCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Adicionar item ao carrinho aumenta a quantidade e valor total")
    void testAddItem() {
        Produto p1 = new Produto("Notebook", 2500.0);
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(2500.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover item existente do carrinho")
    void testRemoveItem() throws ProdutoNaoEncontradoException {
        Produto p1 = new Produto("Mouse", 50.0);
        carrinho.addItem(p1);
        carrinho.removeItem(p1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Remover item inexistente lança exceção")
    void testRemoveItemInexistente() {
        Produto p1 = new Produto("Teclado", 100.0);
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(p1));
    }

    @Test
    @DisplayName("Esvaziar carrinho remove todos os itens")
    void testEsvaziarCarrinho() {
        carrinho.addItem(new Produto("Produto 1", 10.0));
        carrinho.addItem(new Produto("Produto 2", 20.0));
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
