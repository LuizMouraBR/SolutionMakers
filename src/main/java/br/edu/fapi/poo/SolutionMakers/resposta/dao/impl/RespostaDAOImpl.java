package br.edu.fapi.poo.SolutionMakers.resposta.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.resposta.dao.RespostaDAO;
import br.edu.fapi.poo.SolutionMakers.resposta.model.Resposta;

public class RespostaDAOImpl implements RespostaDAO{

	public List<Resposta> listarTodas(int topicoId) {

		List<Resposta> listaRespostas = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "SELECT *,usuario.nickname FROM ticket_comentario INNER JOIN usuario ON ticket_comentario.usuario_id = usuario.id WHERE topico_id = " + topicoId;
			
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
	
}
