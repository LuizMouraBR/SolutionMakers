package br.edu.fapi.poo.SolutionMakers.resposta.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.resposta.dao.RespostaDAO;
import br.edu.fapi.poo.SolutionMakers.resposta.model.Resposta;

public class RespostaDAOImpl implements RespostaDAO{

	public List<Resposta> listarTodasTICKET(int topicoId) {

		List<Resposta> listaRespostas = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "SELECT *,usuario.nickname FROM ticket_comentario INNER JOIN usuario ON ticket_comentario.usuario_id = usuario.id WHERE topico_id = " + topicoId + " ORDER BY data_postagem DESC";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Resposta resposta = new Resposta();
				
				resposta.setId(resultSet.getInt("id"));
				resposta.setUsuarioId(resultSet.getInt("usuario_id"));
				resposta.setConteudo(resultSet.getString("conteudo"));				
				resposta.setEditada(resultSet.getBoolean("isEditada"));
				resposta.setDataPostagem(resultSet.getString("data_postagem"));
				resposta.setDataEdicao(resultSet.getString("data_edicao"));
				resposta.setEditorId(resultSet.getInt("editor_id"));
				resposta.setUsuarioNick(resultSet.getString("nickname"));
				resposta.setUsuarioNivelAcesso(resultSet.getInt("usuarioNivelAcesso"));
				
				listaRespostas.add(resposta);

			}

			return listaRespostas;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return null;

	}
	
	public static Resposta buscaPorIdTICKET(int Id) {

		try (Connection connection = Conexao.connection()) {
			Resposta resposta = new Resposta();
			
			String preparedStmt = "SELECT *,usuario.nickname AS nickname FROM ticket_comentario INNER JOIN usuario WHERE ticket_comentario.id = " + Id;
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				resposta.setId(resultSet.getInt("id"));
				resposta.setUsuarioId(resultSet.getInt("usuario_id"));
				resposta.setConteudo(resultSet.getString("conteudo"));				
				resposta.setEditada(resultSet.getBoolean("isEditada"));
				resposta.setDataPostagem(resultSet.getString("data_postagem"));
				resposta.setDataEdicao(resultSet.getString("data_edicao"));
				resposta.setEditorId(resultSet.getInt("editor_id"));
				resposta.setUsuarioNick(resultSet.getString("nickname"));
				resposta.setUsuarioNivelAcesso(resultSet.getInt("usuarioNivelAcesso"));
				
			}

			return resposta;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return null;

	}
	
	public static void adicionarRespostaTICKET(String conteudo, String usuarioNick, int topicoId, int usuarioId, int usuarioNivelAcesso) {
		
		try (Connection connection = Conexao.connection()) {

			String dataPostagem = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `ticket_comentario` VALUES (null,?,?,?,?,null,?,null,null)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, topicoId);
			preparedStatement.setInt(2, usuarioId);
			preparedStatement.setInt(3, usuarioNivelAcesso);
			preparedStatement.setString(4, conteudo);
			preparedStatement.setString(5, dataPostagem);
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
	public static void editarRespostaTICKET(String conteudo, int editorId, int respostaId) {
		
		try (Connection connection = Conexao.connection()) {

			String dataEdicao = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE `ticket_comentario` SET `conteudo`= ? ,`isEditada`= '1' , `data_edicao`= ? ,`editor_id`= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, conteudo);
			preparedStatement.setString(2, dataEdicao);
			preparedStatement.setInt(3, editorId);
			preparedStatement.setInt(4, respostaId);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
	public List<Resposta> listarTodasDISCUSSAO(int discussaoId) {

		List<Resposta> listaRespostas = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "SELECT *,usuario.nickname FROM discussao_comentario INNER JOIN usuario ON discussao_comentario.usuario_id = usuario.id WHERE discussao_id = " + discussaoId + " ORDER BY data_postagem DESC";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Resposta resposta = new Resposta();
				
				resposta.setId(resultSet.getInt("id"));
				resposta.setUsuarioId(resultSet.getInt("usuario_id"));
				resposta.setConteudo(resultSet.getString("conteudo"));				
				resposta.setEditada(resultSet.getBoolean("isEditada"));
				resposta.setDataPostagem(resultSet.getString("data_postagem"));
				resposta.setDataEdicao(resultSet.getString("data_edicao"));
				resposta.setEditorId(resultSet.getInt("editor_id"));
				resposta.setUsuarioNick(resultSet.getString("nickname"));
				resposta.setUsuarioNivelAcesso(resultSet.getInt("usuarioNivelAcesso"));
				
				listaRespostas.add(resposta);

			}

			return listaRespostas;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return null;

	}
	
	public static Resposta buscaPorIdDISCUSSAO(int Id) {

		try (Connection connection = Conexao.connection()) {
			Resposta resposta = new Resposta();
			
			String preparedStmt = "SELECT *,usuario.nickname AS nickname FROM discussao_comentario INNER JOIN usuario WHERE discussao_comentario.id = " + Id;
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				resposta.setId(resultSet.getInt("id"));
				resposta.setUsuarioId(resultSet.getInt("usuario_id"));
				resposta.setConteudo(resultSet.getString("conteudo"));				
				resposta.setEditada(resultSet.getBoolean("isEditada"));
				resposta.setDataPostagem(resultSet.getString("data_postagem"));
				resposta.setDataEdicao(resultSet.getString("data_edicao"));
				resposta.setEditorId(resultSet.getInt("editor_id"));
				resposta.setUsuarioNick(resultSet.getString("nickname"));
				resposta.setUsuarioNivelAcesso(resultSet.getInt("usuarioNivelAcesso"));
				
			}

			return resposta;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return null;

	}
	
	public static void adicionarRespostaDISCUSSAO(String conteudo, String usuarioNick, int discussaoId, int usuarioId, int usuarioNivelAcesso) {
		
		try (Connection connection = Conexao.connection()) {

			String dataPostagem = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `discussao_comentario` VALUES (null,?,?,?,?,null,?,null,null)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, discussaoId);
			preparedStatement.setInt(2, usuarioId);
			preparedStatement.setInt(3, usuarioNivelAcesso);
			preparedStatement.setString(4, conteudo);
			preparedStatement.setString(5, dataPostagem);
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
	public static void editarRespostaDISCUSSAO(String conteudo, int editorId, int respostaId) {
		
		try (Connection connection = Conexao.connection()) {

			String dataEdicao = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE `discussao_comentario` SET `conteudo`= ? ,`isEditada`= '1' , `data_edicao`= ? ,`editor_id`= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, conteudo);
			preparedStatement.setString(2, dataEdicao);
			preparedStatement.setInt(3, editorId);
			preparedStatement.setInt(4, respostaId);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
}
