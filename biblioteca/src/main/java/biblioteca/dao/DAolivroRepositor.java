package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import biblioteca.connection.MysqlConnection;
import biblioteca.model.ModelLivro;

public class DAolivroRepositor {
	private Connection connection;

	public DAolivroRepositor() throws SQLException {
	connection = MysqlConnection.getConnection();
	}
	public boolean validarAutenticacao(ModelLivro modelLivro) throws SQLException {

		String sql = "select * from livrs where nome_livro = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLivro.getTitulo());
		statement.execute();
		ResultSet res = statement.executeQuery();

		if (res.next()) {
			return true;
		}

		return false;

	}

}
