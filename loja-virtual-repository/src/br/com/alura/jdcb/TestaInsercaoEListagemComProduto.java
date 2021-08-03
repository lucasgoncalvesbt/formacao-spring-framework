package br.com.alura.jdcb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdcb.dao.ProdutoDAO;
import br.com.alura.jdcb.modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> produtos = produtoDao.listar();
			produtos.stream().forEach(p -> System.out.println("Produto: " + p.getNome() + ", Descrição: " + p.getDescricao()));
		} 
		
		//System.out.println(comoda);
	}	
}
