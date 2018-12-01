package br.edu.fapi.poo.SolutionMakers.topico.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.topico.dao.TopicoDAO;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

public class TopicoDAOImpl implements TopicoDAO{
	
	
	//Buscar uma lista de tópicos (TODOS)
	public List<Topico> listarTodos(String ordem) {

		List<Topico> listTopicos = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select * from ticket";
			
			if(ordem.equals("maisRecentes")) {
				preparedStmt = "select * from ticket order by data_postagem desc";
			}else if (ordem.equals("")) {
				
			}
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Topico topico = new Topico();
				
				topico.setId(resultSet.getInt("id"));
				topico.setTitulo(resultSet.getString("titulo"));
				topico.setDescricao(resultSet.getString("descricao"));
				topico.setAutor_nickname(resultSet.getString("autor_nickname"));				
				topico.setData_postagem(resultSet.getString("data_postagem"));
				topico.setResolvido(resultSet.getBoolean("resolvido"));
				topico.setpChave1(resultSet.getString("pChave1"));
				topico.setpChave2(resultSet.getString("pChave2"));
				topico.setpChave3(resultSet.getString("pChave3"));
				
				listTopicos.add(topico);

			}

			return listTopicos;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}

		
		return listTopicos;

	}
	
	//Buscar um tópico em específico
	public Topico buscaPorID(int id) {

			int topicoID = (id);

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where id ="+topicoID);
				ResultSet resultSet = preparedStatement.executeQuery();

				Topico topico = new Topico();
				topico.setId(topicoID);
				
				while (resultSet.next()) {
					
					topico.setTitulo(resultSet.getString("titulo"));
					topico.setDescricao(resultSet.getString("descricao"));
					topico.setAutor_nickname(resultSet.getString("autor_nickname"));				
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));

				}

				return topico;

			} catch (SQLException e) {

				System.out.println("Erro de conexão: "+e.getMessage());
			}
		return null;
	}
	
	
	//Buscar uma lista de tópicos (POR PALAVRA CHAVE ou TAG)
		public List<Topico> buscaPorTag(String tag) {

			List<Topico> listTopicos = new ArrayList<>();

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket where titulo LIKE ? OR descricao LIKE ? OR pChave1 LIKE ? OR pChave2 LIKE ? OR pChave2 LIKE?",PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, "%"+tag+"%");
				preparedStatement.setString(2, "%"+tag+"%");
				preparedStatement.setString(3, "%"+tag+"%");
				preparedStatement.setString(4, "%"+tag+"%");
				preparedStatement.setString(5, "%"+tag+"%");
				
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					Topico topico = new Topico();
					
					topico.setId(resultSet.getInt("id"));
					topico.setTitulo(resultSet.getString("titulo"));
					topico.setDescricao(resultSet.getString("descricao"));
					topico.setAutor_nickname(resultSet.getString("autor_nickname"));				
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));
					
					listTopicos.add(topico);
				}
				return listTopicos;
			} catch (SQLException e) {
				System.out.println("Erro de conexão: "+e.getMessage());
			}
			return listTopicos;
		}
		
		public List<Topico> listarUltimos10() {

			List<Topico> listTopicos = new ArrayList<>();

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket order by data_postagem desc limit 10");
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					Topico topico = new Topico();
					
					topico.setId(resultSet.getInt("id"));
					topico.setTitulo(resultSet.getString("titulo"));
					topico.setDescricao(resultSet.getString("descricao"));
					topico.setAutor_nickname(resultSet.getString("autor_nickname"));				
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));
					
					listTopicos.add(topico);

				}

				return listTopicos;

			} catch (SQLException e) {

				System.out.println("Erro de conexão: "+e.getMessage());

			}

			
			return listTopicos;

		}
		
}
