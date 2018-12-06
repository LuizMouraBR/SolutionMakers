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
import br.edu.fapi.poo.SolutionMakers.discussao.dao.DiscussaoDAO;
import br.edu.fapi.poo.SolutionMakers.discussao.model.Discussao;

public class DiscussaoDAOImpl implements DiscussaoDAO{
	
	static RespostaDAOImpl respostaDAOImpl = new RespostaDAOImpl();
	
	public List<Discussao> listarTodos(String ordem) {

		List<Discussao> listDiscussoes = new ArrayList<>();

		try (Connection connection = Conexao.connection()) {
			
			String preparedStmt = "select * from discussao";
			
			if(ordem.equals("maisRecentes")) {
				preparedStmt = "select * from discussao order by data_postagem desc";
			}else if (ordem.equals("")) {
				
			}
			
			PreparedStatement preparedStatement;
		
			preparedStatement = connection.prepareStatement(preparedStmt);			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Discussao discussao = new Discussao();
				
				discussao.setId(resultSet.getInt("id"));
				discussao.setTitulo(resultSet.getString("titulo"));
				discussao.setDescricao(resultSet.getString("descricao"));
				discussao.setAutor_nickname(resultSet.getString("autor_nickname"));
				discussao.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
				discussao.setData_postagem(resultSet.getString("data_postagem"));
				discussao.setQtdRespostas(getQtdRespostas(discussao.getId()));
				
				listDiscussoes.add(discussao);

			}

			return listDiscussoes;

		} catch (SQLException e) {

			System.out.println("Erro de conexão: "+e.getMessage());

		}

		
		return listDiscussoes;

	}
	
	//Buscar um tópico em específico
	public Discussao buscaPorID(int id) {

			int discussaoID = (id);

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from discussao where id ="+discussaoID);
				ResultSet resultSet = preparedStatement.executeQuery();

				Discussao discussao = new Discussao();
				discussao.setId(discussaoID);
				
				
				while (resultSet.next()) {
					
					discussao.setTitulo(resultSet.getString("titulo"));
					discussao.setDescricao(resultSet.getString("descricao"));
					discussao.setAutor_nickname(resultSet.getString("autor_nickname"));
					discussao.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					discussao.setData_postagem(resultSet.getString("data_postagem"));
					discussao.setQtdRespostas(getQtdRespostas(discussao.getId()));
					discussao.setRespostas(respostaDAOImpl.listarTodasDISCUSSAO(discussao.getId()));	
					
				}

				return discussao;

			} catch (SQLException e) {

				System.out.println("Erro de conexão: "+e.getMessage());
			}
		return null;
	}
	
	
	//Buscar uma lista de tópicos (POR PALAVRA CHAVE ou TAG)
		public List<Discussao> buscaPorTag(String tag) {

			List<Discussao> listDiscussoes = new ArrayList<>();

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from discussao where titulo LIKE ? OR descricao LIKE ? OR pChave1 LIKE ? OR pChave2 LIKE ? OR pChave2 LIKE?",PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, "%"+tag+"%");
				preparedStatement.setString(2, "%"+tag+"%");
				preparedStatement.setString(3, "%"+tag+"%");
				preparedStatement.setString(4, "%"+tag+"%");
				preparedStatement.setString(5, "%"+tag+"%");
				
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					Discussao discussao = new Discussao();
					
					discussao.setId(resultSet.getInt("id"));
					discussao.setTitulo(resultSet.getString("titulo"));
					discussao.setDescricao(resultSet.getString("descricao"));
					discussao.setAutor_nickname(resultSet.getString("autor_nickname"));	
					discussao.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					discussao.setData_postagem(resultSet.getString("data_postagem"));
					discussao.setQtdRespostas(getQtdRespostas(discussao.getId()));
					discussao.setRespostas(respostaDAOImpl.listarTodasDISCUSSAO(discussao.getId()));	
					
					listDiscussoes.add(discussao);
				}
				return listDiscussoes;
			} catch (SQLException e) {
				System.out.println("Erro de conexão: "+e.getMessage());
			}
			return listDiscussoes;
		}
		
		public List<Discussao> listarUltimos(int qtd) {

			List<Discussao> listDiscussoes = new ArrayList<>();

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("select * from discussao order by data_postagem desc limit " + qtd);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					Discussao discussao = new Discussao();
					
					discussao.setId(resultSet.getInt("id"));
					discussao.setTitulo(resultSet.getString("titulo"));
					discussao.setDescricao(resultSet.getString("descricao"));
					discussao.setAutor_nickname(resultSet.getString("autor_nickname"));
					discussao.setAutor_nivelAcesso(resultSet.getInt("autor_nivelAceso"));
					discussao.setData_postagem(resultSet.getString("data_postagem"));
					discussao.setQtdRespostas(getQtdRespostas(discussao.getId()));
					discussao.setRespostas(respostaDAOImpl.listarTodasDISCUSSAO(discussao.getId()));	
					
					listDiscussoes.add(discussao);
				}
				return listDiscussoes;
			} catch (SQLException e) {
				System.out.println("Erro de conexão: "+e.getMessage());
			}
			return listDiscussoes;
		}
		
		public int getQtdRespostas(int id) {

			int discussaoID = (id);
			int qtdRespostas = 0;

			try (Connection connection = Conexao.connection()) {

				PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) FROM `discussao_comentario` WHERE discussao_id = "+discussaoID);
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
	public static int criarDiscussao(String titulo, String descricao, String autorNickname, int autorNivelAcesso) {

		try (Connection connection = Conexao.connection()) {

			String dataPostagem = ColetorData.datetime();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO `discussao` VALUES (null,?,?,?,?,?,0,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, descricao);
			preparedStatement.setString(3, autorNickname);
			preparedStatement.setInt(4, autorNivelAcesso);
			preparedStatement.setString(5, dataPostagem);

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
