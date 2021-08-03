package br.com.alura.jdcb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdcb.dao.CategoriaDAO;
import br.com.alura.jdcb.dao.ProdutoDAO;
import br.com.alura.jdcb.modelo.Categoria;
import br.com.alura.jdcb.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDao.listarComProdutos();
			listaDeCategoria.stream().forEach(lc -> {
				System.out.println(lc.getNome());

				for (Produto produto : lc.getProdutos()) {
					System.out.println(lc.getNome() + " - " + produto.getNome());
				}
			});
		}

	}

}
