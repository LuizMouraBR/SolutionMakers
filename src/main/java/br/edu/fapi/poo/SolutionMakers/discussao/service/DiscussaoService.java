package br.edu.fapi.poo.SolutionMakers.discussao.service;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.discussao.dao.DiscussaoDAO;
import br.edu.fapi.poo.SolutionMakers.discussao.dao.impl.DiscussaoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.discussao.model.Discussao;

public class DiscussaoService {

private DiscussaoDAO discussaoDAO;
	
	public DiscussaoService() {
		this.discussaoDAO = (DiscussaoDAO) new DiscussaoDAOImpl();
	}
	
	public DiscussaoService(DiscussaoDAO discussaoDAO) {
		this.discussaoDAO = discussaoDAO;
	}
	

	public List<Discussao> listarTodos() {
		return discussaoDAO.listarTodos("todos");
	}
		
}
