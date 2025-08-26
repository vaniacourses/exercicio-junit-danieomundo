package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
	@Test 
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
        
	}	

}
