package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
/*	@Test 
	public void testAddItem() {
		
		Carrinho carrinho = new Carrinho();
		Produto batata = new Produto("Batata", 3.0);
		
		carrinho.addItem(batata);
		assertEquals(1, carrinho.getQtdeItems());
	}

	@Test
	public void testRemoveItem() throws ProdutoNaoEncontradoException {
		
		Carrinho carrinho = new Carrinho();
        Produto tomate = new Produto("Tomate", 5.0);

        carrinho.addItem(tomate);
        carrinho.removeItem(tomate);

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.01);
        
	}	*/

	private Carrinho carrinho;

    @BeforeEach
    void setup() {
        carrinho = new Carrinho();
    }

    // Criando produtos simples para os testes
    private Produto criarProduto(String nome, double preco) {
        return new Produto(nome, preco);
    }

    // ---------------------- TESTE DE ADIÇÃO ----------------------
    @Test
    @DisplayName("Adicionar um item aumenta a quantidade")
    void testAdicionarItem() {
        Produto p = criarProduto("Livro", 50.0);
        carrinho.addItem(p);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Adicionar vários itens aumenta corretamente a quantidade")
    void testAdicionarMultiplosItens() {
        carrinho.addItem(criarProduto("A", 10));
        carrinho.addItem(criarProduto("B", 20));
        carrinho.addItem(criarProduto("C", 30));

        assertEquals(3, carrinho.getQtdeItems());
    }

    // ---------------------- TESTE DE VALOR TOTAL ----------------------
    @Test
    @DisplayName("Valor total deve ser a soma dos produtos")
    void testValorTotal() {
        carrinho.addItem(criarProduto("Produto1", 10));
        carrinho.addItem(criarProduto("Produto2", 20));
        carrinho.addItem(criarProduto("Produto3", 5.5));

        assertEquals(35.5, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Carrinho vazio tem valor total igual a zero")
    void testValorTotalVazio() {
        assertEquals(0.0, carrinho.getValorTotal());
    }

    // ---------------------- TESTE DE REMOÇÃO ----------------------
    @Test
    @DisplayName("Remover item existente deve reduzir a quantidade")
    void testRemoverItem() throws ProdutoNaoEncontradoException {
        Produto p = criarProduto("Mouse", 40);
        carrinho.addItem(p);

        carrinho.removeItem(p);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Remover item inexistente deve lançar ProdutoNaoEncontradoException")
    void testRemoverItemInexistente() {
        Produto p = criarProduto("Teclado", 80);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(p);
        });
    }

    @Test
    @DisplayName("Remover um item não deve afetar outros")
    void testRemoverItemEntreVarios() throws ProdutoNaoEncontradoException {
        Produto p1 = criarProduto("A", 10);
        Produto p2 = criarProduto("B", 20);
        Produto p3 = criarProduto("C", 30);

        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.addItem(p3);

        carrinho.removeItem(p2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(40, carrinho.getValorTotal(), 0.0001); // p1 + p3
    }

    // ---------------------- ITENS DUPLICADOS ----------------------
    @Test
    @DisplayName("Carrinho aceita itens duplicados")
    void testItensDuplicados() {
        Produto p = criarProduto("Caneta", 2);

        carrinho.addItem(p);
        carrinho.addItem(p);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(4, carrinho.getValorTotal(), 0.0001);
    }

    // ---------------------- TESTE DO MÉTODO ESVAZIA ----------------------
    @Test
    @DisplayName("Esvaziar carrinho deve zerar quantidade e valor")
    void testEsvaziarCarrinho() {
        carrinho.addItem(criarProduto("X", 10));
        carrinho.addItem(criarProduto("Y", 20));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover item após esvaziar deve lançar exceção")
    void testRemoverDepoisDeEsvaziar() {
        Produto p = criarProduto("Z", 15);
        carrinho.addItem(p);

        carrinho.esvazia();

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(p);
        });
    }

}
