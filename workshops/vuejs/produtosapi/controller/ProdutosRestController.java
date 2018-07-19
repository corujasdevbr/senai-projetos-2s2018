package br.senai.sp.produtosapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.produtosapi.model.Produto;
import br.senai.sp.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:8080")
public class ProdutosRestController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping
	public ResponseEntity<List<Produto>> list() {
		List<Produto> produtos = produtoRepository.list();
		if (produtos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable("id") Long id) {
		Produto produto = produtoRepository.find(id);
		if (produto == null)
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<List<Produto>> save(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return new ResponseEntity<List<Produto>>(produtoRepository.list(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Long id) {
		produtoRepository.remove(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> merge(@PathVariable Long id, @RequestBody Produto produto) {
		produtoRepository.merge(id, produto);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}

}
