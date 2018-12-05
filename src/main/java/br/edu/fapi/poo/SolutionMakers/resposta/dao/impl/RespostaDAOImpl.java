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

	public List<Resposta> listarTodas(int topicoId) {

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
				
				listaRespostas.add(resposta);

			}

			return listaRespostas;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return null;

	}
	
	public static void adicionarResposta(String conteudo, String usuarioNick, int topicoId, int usuarioId) {
		
		try (Connection connection = Conexao.connection()) {

			String dataPostagem = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `ticket_comentario` VALUES (null,?,?,?,null,?,null,null)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, topicoId);
			preparedStatement.setInt(2, usuarioId);
			preparedStatement.setString(3, conteudo);
			preparedStatement.setString(4, dataPostagem);
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
}
