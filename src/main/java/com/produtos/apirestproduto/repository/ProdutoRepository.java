package com.produtos.apirestproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirestproduto.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
