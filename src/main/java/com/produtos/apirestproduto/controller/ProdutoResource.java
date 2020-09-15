package com.produtos.apirestproduto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirestproduto.models.Produto;
import com.produtos.apirestproduto.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> listarProdutoUnico(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}

		return ResponseEntity.notFound().build();

	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
