package sp.senai.br.produtosapi.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import sp.senai.br.produtosapi.model.Produto;

@Repository
public class ProdutoRepository {

	private static List<Produto> produtos;
	{

		produtos = new ArrayList<Produto>();

		produtos.add(new Produto(1L, "Nome A", "https://bit.ly/2EZKKQ8", new Date()));
		produtos.add(new Produto(2L, "Nome B", "https://bit.ly/2EZKKQ8", new Date()));
		produtos.add(new Produto(3L, "Nome C", "https://bit.ly/2EZKKQ8", new Date()));
		
	}

	/**
	 * 
	 * @return lista de produtos
	 */
	public List<Produto> list() {
		return produtos;
	}

	public Produto find(Long id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	/**
	 * Salva o objeto Produto.
	 * 
	 * @param c
	 * @return Produto
	 */
	public Produto save(Produto c) {
		c.setId((long) (produtos.size() + 1));
		produtos.add(c);
		return c;
	}

	/**
	 * Remove o objeto Produto.
	 * 
	 * @param id
	 * @return Produto
	 */
	public Produto remove(Long id) {
		for (Produto curso : produtos) {
			if (curso.getId() == id) {
				produtos.remove(curso);
				return curso;
			}
		}
		return null;
	}

	/**
	 * Atualizar o objeto Produto.
	 * 
	 * @param id
	 * @return Produto
	 */
	public Produto merge(Long id, Produto c) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				c.setId(produto.getId());
				produtos.remove(produto);
				produtos.add(c);
				return produto;
			}
		}
		return null;

}
	
}
