package jokenpo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    private final Main jogo = new Main();

    // ---------------------- TESTES DE EMPATE ----------------------
    @Test
    @DisplayName("Empate: papel (1) x papel (1)")
    void testEmpatePapel() {
        assertEquals(0, jogo.jogar(1, 1));
    }

    @Test
    @DisplayName("Empate: pedra (2) x pedra (2)")
    void testEmpatePedra() {
        assertEquals(0, jogo.jogar(2, 2));
    }

    @Test
    @DisplayName("Empate: tesoura (3) x tesoura (3)")
    void testEmpateTesoura() {
        assertEquals(0, jogo.jogar(3, 3));
    }

    // ---------------------- TESTES DE VITÓRIA DO JOGADOR 1 ----------------------
    @Test
    @DisplayName("Jogador 1 vence: papel (1) ganha da pedra (2)")
    void testJog1VencePapelPedra() {
        assertEquals(1, jogo.jogar(1, 2));
    }

    @Test
    @DisplayName("Jogador 1 vence: pedra (2) ganha da tesoura (3)")
    void testJog1VencePedraTesoura() {
        assertEquals(1, jogo.jogar(2, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence: tesoura (3) ganha do papel (1)")
    void testJog1VenceTesouraPapel() {
        assertEquals(1, jogo.jogar(3, 1));
    }

    // ---------------------- TESTES DE VITÓRIA DO JOGADOR 2 ----------------------
    @Test
    @DisplayName("Jogador 2 vence: pedra (2) perde para papel (1)")
    void testJog2VencePedraPapel() {
        assertEquals(2, jogo.jogar(2, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence: tesoura (3) perde para pedra (2)")
    void testJog2VenceTesouraPedra() {
        assertEquals(2, jogo.jogar(3, 2));
    }

    @Test
    @DisplayName("Jogador 2 vence: papel (1) perde para tesoura (3)")
    void testJog2VencePapelTesoura() {
        assertEquals(2, jogo.jogar(1, 3));
    }

    // ---------------------- TESTES DE VALIDAÇÃO DE ENTRADA ----------------------
    @Test
    @DisplayName("Entrada inválida: jogador 1 menor que 1")
    void testJogador1InvalidoBaixo() {
        assertEquals(-1, jogo.jogar(0, 1));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 1 maior que 3")
    void testJogador1InvalidoAlto() {
        assertEquals(-1, jogo.jogar(4, 1));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 2 menor que 1")
    void testJogador2InvalidoBaixo() {
        assertEquals(-1, jogo.jogar(1, 0));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 2 maior que 3")
    void testJogador2InvalidoAlto() {
        assertEquals(-1, jogo.jogar(1, 5));
    }

    @Test
    @DisplayName("Entradas totalmente inválidas nos dois jogadores")
    void testAmbosInvalidos() {
        assertEquals(-1, jogo.jogar(-1, 7));
    }

    // ---------------------- TESTE DE FRONTEIRA ----------------------
    @Test
    @DisplayName("Limites válidos: 1 e 3")
    void testLimitesValidos() {
        assertEquals(2, jogo.jogar(1, 3)); // tesoura ganha de papel → jogador 2
    }
}
