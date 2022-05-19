package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import biblioteca.connection.MysqlConnection;
import biblioteca.model.ModelLivro;


public class DAOcadLivro {

	private Connection connection;

	public DAOcadLivro() throws SQLException {
		connection = MysqlConnection.getConnection();
	}

	public ModelLivro salvarLivro(ModelLivro livro) throws SQLException {
		if (livro.isNovo()) {

			String sql = "insert into public.livros(nome_livro, author, genero, editora) values(?,?,?,?)";

			PreparedStatement statemant = connection.prepareStatement(sql);

			statemant.setString(1, livro.getTitulo());
			statemant.setString(2, livro.getAutor());
			statemant.setString(3, livro.getGenero());
			statemant.setString(4, livro.getEditora());

			statemant.execute();

			connection.commit();
		} else {
			String sql = "update livros set nome_livro=?, author=?, genero=?, editora=? where id = " + livro.getId()
					+ "";
			PreparedStatement statemant = connection.prepareStatement(sql);

			statemant.setString(1, livro.getTitulo());
			statemant.setString(2, livro.getAutor());
			statemant.setString(3, livro.getGenero());
			statemant.setString(4, livro.getEditora());

			statemant.executeUpdate();

			connection.commit();

		}

		return this.consultarLivro(livro.getTitulo());

	}

	public ModelLivro consultarLivro(String titulo) throws SQLException {

		ModelLivro modelLivro = new ModelLivro();

		String sql = "select * from livros where upper(nome_livro) = upper('" + titulo + "')";

		PreparedStatement statemant = connection.prepareStatement(sql);

		ResultSet rs = statemant.executeQuery();

		while (rs.next()) {

			modelLivro.setId(rs.getLong("id"));
			modelLivro.setTitulo(rs.getString("nome"));
			modelLivro.setAutor(rs.getString("email"));
			modelLivro.setGenero(rs.getString("login"));
			modelLivro.setEditora(rs.getString("senha"));

		}

		return modelLivro;

	}

	public void deletarLivro(String idLivro) throws SQLException {

		String sql = "delet from livros where id = ?";
		PreparedStatement statemant = connection.prepareStatement(sql);
		statemant.setLong(1, Long.parseLong(idLivro));
		statemant.executeUpdate();

		connection.commit();

	}

}
