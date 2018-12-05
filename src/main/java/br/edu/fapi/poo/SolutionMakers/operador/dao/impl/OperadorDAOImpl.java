package br.edu.fapi.poo.SolutionMakers.operador.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.operador.dao.OperadorDAO;
import br.edu.fapi.poo.SolutionMakers.operador.model.Operador;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;

public class OperadorDAOImpl implements OperadorDAO{

	public List<Operador> listarTodos() {

		List<Operador> listOperadores = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select * from operador";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Operador operador = new Operador();
				
				operador.setId(resultSet.getInt("id"));
				operador.setUsuarioId(resultSet.getInt("usuario_id"));
				operador.setTicketsResolvidos(resultSet.getInt("tickets_resolvidos"));
				operador.setUsuarioNickname(UsuarioDAOImpl.buscaPorId(operador.getUsuarioId()).getNickname());
				
				listOperadores.add(operador);

			}

			return listOperadores;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return listOperadores;

	}
	
	public static void adicionarOperador(String nickname, String email, String bio) {

		int usuarioId = 0;
		
		try (Connection connection = Conexao.connection()) {

			String dataCriacao = ColetorData.datetime();
			
			//Adicionar na table USUARIO
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `usuario` VALUES (null,?,?,'12345',?,2,0,?,null)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, bio);
			preparedStatement.setString(4, dataCriacao);

			preparedStatement.executeUpdate();
			ResultSet res = preparedStatement.getGeneratedKeys();
			int result = 0;
			if (res.first()) {
				result = res.getInt(1);
			}
			usuarioId = result;
			
		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}
		
		try (Connection connection = Conexao.connection()) {
			
			//Adicionar na table OPERADOR
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `operador` VALUES (null,0,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, usuarioId);

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
}
