package br.edu.fapi.poo.SolutionMakers.empresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.empresa.dao.EmpresaDAO;
import br.edu.fapi.poo.SolutionMakers.empresa.model.Empresa;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.UsuarioDAO;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

public class EmpresaDAOImpl implements EmpresaDAO {

	@Override
	public Empresa buscaEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Empresa> listarTodos() {
		List<Empresa> listaEmpresa = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Empresa empresa = new Empresa();

				empresa.setId(resultSet.getInt("id"));
				empresa.setNomeFantasia(resultSet.getString("nome_fantasia"));
				empresa.setRazaoSocial(resultSet.getString("razao_social"));
				empresa.setCnpj(resultSet.getString("endereco"));
				
				
				listaEmpresa.add(empresa);

			}

			return listaEmpresa;

		} catch (SQLException e) {

			System.out.println("Erro de base de dados:" + e.getMessage());

		}
		return listaEmpresa;
	}

	public Empresa buscaPorNome(String nomeFantasia) {
		Empresa empresa = new Empresa();

		try (Connection connection = Conexao.connection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from empresa where nome_fantasia = ?", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nomeFantasia);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				empresa.setId(resultSet.getInt("id"));
				empresa.setNomeFantasia(resultSet.getString("nome_fantasia"));
				empresa.setRazaoSocial(resultSet.getString("razao_social"));
				empresa.setCnpj(resultSet.getString("endereco"));

			}

			return empresa;

		} catch (SQLException e) {

			System.out.println("Erro de base de dados:" + e.getMessage());

		}
		return empresa;


	}
	
	public static int criarEmpresa(String nomeEmpresa, String razaoSocial,String cnpj,String endereco) {

		try (Connection connection = Conexao.connection()) {


			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `empresa` VALUES (null,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nomeEmpresa);
			preparedStatement.setString(2, razaoSocial);
			preparedStatement.setString(3, cnpj);
			preparedStatement.setString(4, endereco);


			preparedStatement.executeUpdate();
			ResultSet res = preparedStatement.getGeneratedKeys();
			int result = 0;
			if (res.first()) {
				result = res.getInt(1);
			}
			return result;

		} catch (SQLException e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		return 0;
	}



}
