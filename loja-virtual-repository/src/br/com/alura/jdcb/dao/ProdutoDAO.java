package br.com.alura.jdcb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdcb.modelo.Categoria;
import br.com.alura.jdcb.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}

	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>(); 
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {			
				
				while (rst.next()) {					
					Integer id = rst.getInt("id");
					String nome = rst.getString("nome");
					String descricao = rst.getString("descricao");
					Produto produto = new Produto(id, nome, descricao);	
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public List<Produto> buscar(Categoria lc) throws SQLException {
		List<Produto> produtos = new ArrayList<>(); 
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, lc.getId());
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {			
				
				while (rst.next()) {					
					Integer id = rst.getInt("id");
					String nome = rst.getString("nome");
					String descricao = rst.getString("descricao");
					Produto produto = new Produto(id, nome, descricao);	
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

}
