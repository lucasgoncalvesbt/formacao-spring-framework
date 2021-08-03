package br.com.alura.jdcb.modelo;

public class Produto {
		
	private Integer id;
	private String nome;
	private String descricao;	
	
	public Produto(String nome, String descricao) {
		this.setNome(nome);
		this.setDescricao(descricao);
	}
	
	
	public Produto(Integer id, String nome, String descricao) {
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {		
		return String.format("O produto criado foi: %d, %s, %s ", this.id, this.nome, this.descricao);
	}
	
}
