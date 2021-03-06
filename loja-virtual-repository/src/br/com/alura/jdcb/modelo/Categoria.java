package br.com.alura.jdcb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionar(Produto produto) {
		
		this.produtos.add(produto);
		
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
}
