package br.edu.fapi.poo.SolutionMakers.logAcesso.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.logAcesso.dao.LogAcessoDAO;
import br.edu.fapi.poo.SolutionMakers.logAcesso.model.LogAcesso;

public class LogAcessoDAOImpl implements LogAcessoDAO {

	public List<LogAcesso> listar() {

		List<LogAcesso> listLogs = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select * from log_acesso order by id desc";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				LogAcesso log = new LogAcesso();
				
				log.setId(resultSet.getInt("id"));
				log.setEmailUser(resultSet.getString("usuario_email"));
				log.setAcao(resultSet.getString("acao_user"));
				log.setData(resultSet.getString("data_hora"));
				
				listLogs.add(log);

			}

			return listLogs;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}
		return listLogs;

	}
	
}
