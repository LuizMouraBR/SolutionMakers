package br.edu.fapi.poo.SolutionMakers.usuario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.UsuarioDAO;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	public Usuario buscaConta(Usuario usuario) {
		List<Usuario> usuarios = listarTodos();

		for (Usuario usuarioLista : usuarios) {
			if (usuarioLista.equals(usuario)) {
				return usuarioLista;
			}
		}
		return null;
	}

	public List<Usuario> listarTodos() {
		List<Usuario> listUsers = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Usuario usuario = new Usuario();

				usuario.setId(resultSet.getInt("id"));
				usuario.setNickname(resultSet.getString("nickname"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setBio(resultSet.getString("bio"));
				usuario.setNivelAcesso(resultSet.getInt("nivelAcesso"));
				usuario.setBloqueado(resultSet.getBoolean("bloqueado"));
				usuario.setDataCriacao(resultSet.getDate("dataCriacao"));
				usuario.setUltimoAcesso(resultSet.getDate("ultimoAcesso"));

				listUsers.add(usuario);

			}

			return listUsers;

		} catch (SQLException e) {

			System.out.println("Erro de base de dados:" + e.getMessage());

		}
		return listUsers;
	}

	public Usuario buscaPorNick(String nickname) {
		Usuario usuario = new Usuario();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from usuario where nickname = ?", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nickname);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				usuario.setId(resultSet.getInt("id"));
				usuario.setNickname(resultSet.getString("nickname"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setBio(resultSet.getString("bio"));
				usuario.setNivelAcesso(resultSet.getInt("nivelAcesso"));
				usuario.setBloqueado(resultSet.getBoolean("bloqueado"));
				usuario.setDataCriacao(resultSet.getDate("dataCriacao"));
				usuario.setUltimoAcesso(resultSet.getDate("ultimoAcesso"));

			}

			return usuario;

		} catch (SQLException e) {

			System.out.println("Erro de base de dados:" + e.getMessage());

		}
		return usuario;
	}

	// Retornar um usuário utilizando email como chave de busca.
	public static Usuario buscaPorEmail(String emailUser) {

		Usuario usuario = new Usuario();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM usuario WHERE email LIKE ?");
			preparedStatement.setString(1, emailUser);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				usuario.setId(resultSet.getInt("id"));
				usuario.setNickname(resultSet.getString("nickname"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setNivelAcesso(resultSet.getInt("nivelAcesso"));
				usuario.setBloqueado(resultSet.getBoolean("bloqueado"));
				usuario.setDataCriacao(resultSet.getDate("dataCriacao"));
				usuario.setUltimoAcesso(resultSet.getDate("ultimoAcesso"));
			}

			preparedStatement.executeQuery();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

		return usuario;

	}
	
	public static Usuario buscaPorId(int id) {

		Usuario usuario = new Usuario();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM usuario WHERE id = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				usuario.setId(resultSet.getInt("id"));
				usuario.setNickname(resultSet.getString("nickname"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setNivelAcesso(resultSet.getInt("nivelAcesso"));
				usuario.setBloqueado(resultSet.getBoolean("bloqueado"));
				usuario.setDataCriacao(resultSet.getDate("dataCriacao"));
				usuario.setUltimoAcesso(resultSet.getDate("ultimoAcesso"));
			}

			preparedStatement.executeQuery();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

		return usuario;

	}

	// Trocar a senha de um usuário utilizando o email como chave.
	public static void trocaSenha(String emailUser, String novaSenha) {

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE usuario SET senha=? WHERE email LIKE ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, novaSenha);
			preparedStatement.setString(2, emailUser);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}

	public static void atualizaUltimoAcesso(String emailUser) {

		try (Connection connection = Conexao.connection()) {

			String dataNovoAcesso = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE usuario SET ultimoAcesso=? WHERE email LIKE ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, dataNovoAcesso);
			preparedStatement.setString(2, emailUser);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}

	// Adicionar usuário ao log de acesso
	public static void adicionarLogAcesso(String emailUser, String acaoUser) {

		try (Connection connection = Conexao.connection()) {

			String dataNovoAcesso = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `log_acesso` VALUES (NULL, ? , ? , ? )", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, emailUser);
			preparedStatement.setString(2, acaoUser);
			preparedStatement.setString(3, dataNovoAcesso);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
}
