package br.edu.fapi.poo.SolutionMakers.discussao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.SolutionMakers.conexao.Conexao;
import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.resposta.dao.impl.RespostaDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.dao.TopicoDAO;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

public class DiscussaoDAOImpl implements TopicoDAO{
	
	static RespostaDAOImpl respostaDAOImpl = new RespostaDAOImpl();
	
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
				topico.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
				topico.setData_postagem(resultSet.getString("data_postagem"));
				topico.setResolvido(resultSet.getBoolean("resolvido"));
				topico.setpChave1(resultSet.getString("pChave1"));
				topico.setpChave2(resultSet.getString("pChave2"));
				topico.setpChave3(resultSet.getString("pChave3"));
				topico.setQtdRespostas(getQtdRespostas(topico.getId()));
				
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
					topico.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));
					topico.setQtdRespostas(getQtdRespostas(topico.getId()));
					topico.setRespostas(respostaDAOImpl.listarTodas(topico.getId()));	
					
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
					topico.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));
					topico.setQtdRespostas(getQtdRespostas(topico.getId()));
					topico.setRespostas(respostaDAOImpl.listarTodas(topico.getId()));	
					
					listTopicos.add(topico);
				}
				return listTopicos;
			} catch (SQLException e) {
				System.out.println("Erro de conexão: "+e.getMessage());
			}
			return listTopicos;
		}
		
		public List<Topico> listarUltimos(int qtd) {

			List<Topico> listTopicos = new ArrayList<>();

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from ticket order by data_postagem desc limit " + qtd);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					Topico topico = new Topico();
					
					topico.setId(resultSet.getInt("id"));
					topico.setTitulo(resultSet.getString("titulo"));
					topico.setDescricao(resultSet.getString("descricao"));
					topico.setAutor_nickname(resultSet.getString("autor_nickname"));
					topico.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					topico.setData_postagem(resultSet.getString("data_postagem"));
					topico.setResolvido(resultSet.getBoolean("resolvido"));
					topico.setpChave1(resultSet.getString("pChave1"));
					topico.setpChave2(resultSet.getString("pChave2"));
					topico.setpChave3(resultSet.getString("pChave3"));
					topico.setQtdRespostas(getQtdRespostas(topico.getId()));
					topico.setRespostas(respostaDAOImpl.listarTodas(topico.getId()));	
					
					listTopicos.add(topico);
				}
				return listTopicos;
			} catch (SQLException e) {
				System.out.println("Erro de conexão: "+e.getMessage());
			}
			return listTopicos;
		}
		
		public int getQtdRespostas(int id) {

			int topicoID = (id);
			int qtdRespostas = 0;

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) FROM `ticket_comentario` WHERE topico_id = "+topicoID);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					qtdRespostas = (resultSet.getInt("count(*)"));

				}

				return qtdRespostas;

			} catch (SQLException e) {

				System.out.println("Erro de conexão: "+e.getMessage());
			}
		return 0;
	}
	public static int criarTopico(String titulo, String descricao, String autorNickname, int autorNivelAcesso, String pChave1, String pChave2, String pChave3) {

		try (Connection connection = Conexao.connection()) {

			String dataPostagem = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `ticket` VALUES (null,?,?,?,?,?,0,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, descricao);
			preparedStatement.setString(3, autorNickname);
			preparedStatement.setInt(4, autorNivelAcesso);
			preparedStatement.setString(5, dataPostagem);
			preparedStatement.setString(6, pChave1);
			preparedStatement.setString(7, pChave2);
			preparedStatement.setString(8, pChave3);

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
