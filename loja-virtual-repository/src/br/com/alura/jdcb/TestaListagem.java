package br.com.alura.jdcb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactoy = new ConnectionFactory();
		Connection connection = connectionFactoy.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute(); //boolean
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
		}
		
		connection.close();

	}

}
