package br.edu.fapi.poo.SolutionMakers.discussao.dao;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.discussao.model.Discussao;

public interface DiscussaoDAO {
	
	List<Discussao> listarTodos(String ordem);
	
	List<Discussao> listarUltimos(int qtd);
	
	Discussao buscaPorID(int id);
	
	List<Discussao> buscaPorTag(String tag);
	
}
