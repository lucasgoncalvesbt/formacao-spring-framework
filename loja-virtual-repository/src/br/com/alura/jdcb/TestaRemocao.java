package br.com.alura.jdcb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactoy = new ConnectionFactory();
		Connection connection = connectionFactoy.recuperarConexao();	
		
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
	}

}
