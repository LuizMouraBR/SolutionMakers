package br.edu.fapi.poo.SolutionMakers.logAcoes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.logAcoes.dao.LogAcoesDAO;
import br.edu.fapi.poo.SolutionMakers.logAcoes.model.LogAcoes;

public class LogAcoesDAOImpl implements LogAcoesDAO {
	
	public List<LogAcoes> listar() {

		List<LogAcoes> listLogs = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select * from log_acoes order by id desc";
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				LogAcoes log = new LogAcoes();
				
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
