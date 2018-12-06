package br.edu.fapi.poo.SolutionMakers.cliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.cliente.dao.ClienteDAO;
import br.edu.fapi.poo.SolutionMakers.cliente.model.Cliente;

public class ClienteDAOImpl implements ClienteDAO{

	public List<Cliente> listarTodos() {

		List<Cliente> listClientes = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select *,empresa.nome_fantasia from cliente inner join empresa on cliente.empresa_id = empresa.id";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNomeCompleto(resultSet.getString("nome_completo"));
				cliente.setRg(resultSet.getString("rg"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setPis(resultSet.getString("pis"));
				cliente.setUsuarioId(resultSet.getInt("usuario_id"));
				cliente.setEmpresaId(resultSet.getInt("empresa_id"));
				cliente.setEmpresaNome(resultSet.getString("nome_fantasia"));
				
				listClientes.add(cliente);

			}

			return listClientes;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return listClientes;

	}
	
	public static void adicionarCliente(String nickname, String email, String bio, String nomeCompleto, String rg, String cpf, String pis, int empresaId) {

		int usuarioId = 0;
		
		try (Connection connection = Conexao.connection()) {

			String dataCriacao = ColetorData.datetime();
			
			//Adicionar na table USUARIO
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `usuario` VALUES (null,?,?,'12345',?,3,0,?,null)", Statement.RETURN_GENERATED_KEYS);
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
			
			//Adicionar na table CLIENTE
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `cliente` VALUES (null,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nomeCompleto);
			preparedStatement.setString(2, rg);
			preparedStatement.setString(3, cpf);
			preparedStatement.setString(4, pis);
			preparedStatement.setInt(5, empresaId);
			preparedStatement.setInt(6, usuarioId);

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
	public static void excluirCliente(int usuarioId) {

		try (Connection connection = Conexao.connection()) {
					
			//deletar da table CLIENTE
			PreparedStatement preparedStatement = connection.prepareStatement(
					"DELETE FROM `cliente` WHERE usuario_id = ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, usuarioId);

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}
		
		try (Connection connection = Conexao.connection()) {
			
			//deletar da table USUARIO
			PreparedStatement preparedStatement = connection.prepareStatement(
					"DELETE FROM `usuario` WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, usuarioId);

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println("Erro de conexão: " + e.getMessage());

		}

	}
	
}
