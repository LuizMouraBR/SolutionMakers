package br.edu.fapi.poo.SolutionMakers.topico.dao;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

public interface TopicoDAO {
	
	List<Topico> listarTodos(String ordem);
	
	List<Topico> listarUltimos10();
	
	Topico buscaPorID(int id);
	
	List<Topico> buscaPorTag(String tag);
	
}
