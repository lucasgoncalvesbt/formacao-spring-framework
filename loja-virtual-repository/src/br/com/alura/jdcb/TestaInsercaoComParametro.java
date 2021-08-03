package br.com.alura.jdcb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactoy = new ConnectionFactory();
		try (Connection connection = connectionFactoy.recuperarConexao()) {
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("Pc", "Computador com RGB", stm);
				adicionarVariavel("Geladeira", "Geladeira com TV", stm);

				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi" + id);
			}

		}
	}

}
