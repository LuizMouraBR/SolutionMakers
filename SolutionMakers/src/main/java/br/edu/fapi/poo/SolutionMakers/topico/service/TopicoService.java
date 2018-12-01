package br.edu.fapi.poo.SolutionMakers.topico.service;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.topico.dao.TopicoDAO;
import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

public class TopicoService {

private TopicoDAO topicoDAO;
	
	public TopicoService() {
		this.topicoDAO = new TopicoDAOImpl();
	}
	
	public TopicoService(TopicoDAO topicoDAO) {
		this.topicoDAO = topicoDAO;
	}
	

	public List<Topico> listarTodos() {
		return topicoDAO.listarTodos("todos");
	}
		
}
