package com.produtos.apirestproduto.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*entity mostra que essa classe será uma entidade e logo 
abaixo a table mostra que essa classe pertence a tal tabela*/
@Entity
@Table(name = "tab_produto")
public class Produto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * anotacao id informa que esse atributo é a chave principal e mostra como ela
	 * será incrementada
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "des_produto")
	private String desProduto;
	
	@Column(name = "val_produto", length = 100)
	private BigDecimal valProduto;
	
	public Produto() {
		
	}

	public Produto(long id, String desProduto, BigDecimal valProduto) {
		this.id = id;
		this.desProduto = desProduto;
		this.valProduto = valProduto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getDesProduto() {
		return desProduto;
	}

	public void setDesProduto(String desProduto) {
		this.desProduto = desProduto;
	}

	public BigDecimal getValProduto() {
		return valProduto;
	}

	public void setValProduto(BigDecimal valProduto) {
		this.valProduto = valProduto;
	}	

}
